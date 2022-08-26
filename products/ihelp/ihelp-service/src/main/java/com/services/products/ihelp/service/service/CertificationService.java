package com.services.products.ihelp.service.service;

import com.services.cloud.api.ApiFeign;
import com.services.core.bo.FileInfoBO;
import com.services.core.bo.aliyun.oss.PutBytesRequestBO;
import com.services.core.bo.tencent.cloud.CompareFaceRequestBO;
import com.services.core.bo.tencent.cloud.IDCardOcrRequestBO;
import com.services.core.bo.tencent.cloud.IDCardOcrResponseBO;
import com.services.core.util.FileUtil;
import com.services.core.util.TimeUtil;
import com.services.core.vo.ResponseVO;
import com.services.products.ihelp.dao.domain.User;
import com.services.products.ihelp.dao.mapper.UserMapper;
import com.services.products.ihelp.service.config.BaseConfig;
import com.services.products.ihelp.dao.dto.CertificationDTO;
import com.services.products.ihelp.service.enums.FileUseEnum;
import com.services.products.ihelp.service.enums.GenderEnum;
import com.services.products.ihelp.service.enums.UserStatusEnum;
import com.services.products.ihelp.service.enums.UserTypeEnum;
import com.services.products.ihelp.service.exception.BusinessExceptionCode;
import com.services.products.ihelp.service.util.RedisKeyUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Base64;

@Service
public class CertificationService
{
    private final BaseConfig baseConfig;
    private final ApiFeign apiFeign;
    private final FileService fileService;

    @Resource
    private UserMapper userMapper;

    public CertificationService(BaseConfig baseConfig, ApiFeign apiFeign, FileService fileService)
    {
        this.baseConfig = baseConfig;
        this.apiFeign = apiFeign;
        this.fileService = fileService;
    }

    @Transactional
    public ResponseVO certification(String session, CertificationDTO certificationDTO)
    {
        // 身份证正面识别
        IDCardOcrResponseBO frontIdCardOcrResponseBO = idCardOcr("FRONT",
                certificationDTO.getImages().getFront());
        inputCheck(certificationDTO, frontIdCardOcrResponseBO);
        // 身份证背面识别
        IDCardOcrResponseBO backIdCardOcrResponseBO = idCardOcr("BACK", certificationDTO.getImages().getBack());
        // 身份证到期时间
        String expirationString = backIdCardOcrResponseBO.getValidDate().split("-")[1];
        LocalDate expiration = TimeUtil.dateStringToLocalDate(expirationString, "yyyy.MM.dd");
        // 身份证已过期
        if (expiration.isBefore(LocalDate.now()))
        {
            BusinessExceptionCode.ID_CARD_EXPIRED.throwException();
        }

        Long userId = RedisKeyUtil.getUserId(session);
        String portrait = savePortrait(frontIdCardOcrResponseBO.advancedInfoBean().getPortrait(), userId);
        String portraitUrl = baseConfig.getOssDomain() + portrait;
        compareFace(certificationDTO.getPhoto(), portraitUrl);
        updateUserInfo(userId, portrait, expiration, frontIdCardOcrResponseBO);
        return new ResponseVO();
    }

    /**
     * 身份证识别
     *
     * @param cardSide
     * @param imageUrl
     * @return
     */
    private IDCardOcrResponseBO idCardOcr(String cardSide, String imageUrl)
    {
        IDCardOcrRequestBO idCardOCRRequestBO = new IDCardOcrRequestBO();
        idCardOCRRequestBO.setCardSide(cardSide);
        idCardOCRRequestBO.setImageUrl(imageUrl);
        return ResponseVO.getData(apiFeign.idCardOcr(idCardOCRRequestBO), IDCardOcrResponseBO.class);
    }

    /**
     * 比对输入信息
     *
     * @param certificationDTO
     * @param frontIdCardOcrResponseBO
     */
    private void inputCheck(CertificationDTO certificationDTO, IDCardOcrResponseBO frontIdCardOcrResponseBO)
    {
        // 证件号不匹配
        if (!certificationDTO.getIdNumber().equals(frontIdCardOcrResponseBO.getIdNum()))
        {
            BusinessExceptionCode.ID_NUM_NOT_MATCH.throwException();
        }
        // 姓名不匹配
        if (!certificationDTO.getName().equals(frontIdCardOcrResponseBO.getName()))
        {
            BusinessExceptionCode.NAME_NOT_MATCH.throwException();
        }
    }

    /**
     * 人脸比对
     *
     * @param photo 人脸url
     * @param portrait 身份证人像url
     */
    private void compareFace(String photo, String portrait)
    {
        CompareFaceRequestBO compareFaceRequestBO = new CompareFaceRequestBO();
        compareFaceRequestBO.setUrlA(photo);
        compareFaceRequestBO.setUrlB(portrait);
        ResponseVO.check(apiFeign.compareFace(compareFaceRequestBO));
    }

    /**
     * 更新用户信息
     *
     * @param userId
     * @param photo
     * @param expiration 身份证到期时间
     * @param frontIdCardOcrResponseBO
     */
    private void updateUserInfo(Long userId, String photo, LocalDate expiration,
                                IDCardOcrResponseBO frontIdCardOcrResponseBO)
    {
        LocalDate birthday = TimeUtil.dateStringToLocalDate(frontIdCardOcrResponseBO.getBirth(), "y/M/d");
        int age = Period.between(birthday, LocalDate.now()).getYears();
        User user = new User();
        user.setId(userId);
        user.setBirthday(birthday);
        user.setName(frontIdCardOcrResponseBO.getName());
        user.setIdNumber(frontIdCardOcrResponseBO.getIdNum());
        user.setGender(GenderEnum.getNumByDescription(frontIdCardOcrResponseBO.getSex()).byteValue());
        user.setRole(UserTypeEnum.getNumByAge(age).byteValue());
        user.setStatus(UserStatusEnum.CERTIFIED.num.byteValue());
        user.setExpiration(expiration);
        user.setPhoto(photo);
        user.setUpdateTime(LocalDateTime.now());
        userMapper.updateByPrimaryKeySelective(user);
    }

    /**
     * 保存身份证人像
     *
     * @param portrait
     * @param userId
     * @return
     */
    private String savePortrait(String portrait, Long userId)
    {
        String suffix = ".jpg";
        byte[] bytes = Base64.getDecoder().decode(portrait);
        FileInfoBO fileInfoBO = FileUtil.generateFileInfo(FileUseEnum.TEST.path, suffix, bytes.length);
        PutBytesRequestBO putBytesRequestBO = new PutBytesRequestBO();
        putBytesRequestBO.setBytes(bytes);
        putBytesRequestBO.setObjectName(fileInfoBO.getObjectName());
        ResponseVO.check(apiFeign.putBytes(putBytesRequestBO));
        fileService.saveFileRecord(FileUseEnum.TEST, userId, fileInfoBO, true);
        return fileInfoBO.getObjectName();
    }
}
