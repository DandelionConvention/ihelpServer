package com.services.products.ihelp.service.service;

import com.services.cloud.api.ApiFeign;
import com.services.core.bo.FileInfoBO;
import com.services.core.bo.aliyun.oss.PutUrlRequestBO;
import com.services.core.bo.weixin.miniapp.Code2SessionResponseBO;
import com.services.core.bo.weixin.miniapp.GetUserInfoResponseBO;
import com.services.core.bo.weixin.miniapp.GetUserInfoRquestBO;
import com.services.core.util.CopyUtil;
import com.services.core.util.FileUtil;
import com.services.core.util.RedisUtil;
import com.services.core.util.SnowFlakeUtil;
import com.services.core.util.UuidUtil;
import com.services.core.vo.ResponseVO;
import com.services.products.ihelp.dao.domain.User;
import com.services.products.ihelp.dao.mapper.UserMapper;
import com.services.products.ihelp.dao.mapper.my.MyUserMapper;
import com.services.products.ihelp.service.config.BaseConfig;
import com.services.products.ihelp.dao.dto.LoginDTO;
import com.services.products.ihelp.service.enums.FileUseEnum;
import com.services.products.ihelp.service.enums.RedisKeyEnum;
import com.services.products.ihelp.service.enums.UserStatusEnum;
import com.services.products.ihelp.service.enums.UserTypeEnum;
import com.services.products.ihelp.service.vo.LoginVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
public class AuthService
{
    private final ApiFeign apiFeign;
    private final RedisUtil redisUtil;
    private final FileService fileService;
    private final BaseConfig baseConfig;

    public AuthService(ApiFeign apiFeign, RedisUtil redisUtil, FileService fileService, BaseConfig baseConfig)
    {
        this.apiFeign = apiFeign;
        this.redisUtil = redisUtil;
        this.fileService = fileService;
        this.baseConfig = baseConfig;
    }

    @Resource
    private UserMapper userMapper;

    @Resource
    private MyUserMapper myUserMapper;

    @Transactional
    public ResponseVO login(LoginDTO loginDTO)
    {
        Code2SessionResponseBO code2SessionResponseBO = ResponseVO.getData(
                apiFeign.getSessionInfo(loginDTO.getCode()), Code2SessionResponseBO.class);
        User user = myUserMapper.getUserByOpenid(code2SessionResponseBO.getOpenid());
        // 用户未注册创建新用户
        if (user == null)
        {
            return new ResponseVO(register(code2SessionResponseBO, loginDTO));
        }
        // 获取已注册用户信息
        LoginVO loginVO  = CopyUtil.copy(user, LoginVO.class);
        loginVO.setVerified(user.getStatus().intValue() == 1);
        loginVO.setRole(UserTypeEnum.getNameByNum(user.getRole().intValue()));
        loginVO.setCollection(0);
        loginVO.setFootprint(0);
        Set<String> keys =
                redisUtil.stringRedisTemplate.keys(RedisKeyEnum.SESSION.prefix + user.getId() + ":*");
        redisUtil.stringRedisTemplate.delete(keys);
        String session = RedisKeyEnum.SESSION.prefix + user.getId() + ":" + UuidUtil.getUuid();
        redisUtil.valueOperations.set(session, code2SessionResponseBO.getSessionKey(), 3, TimeUnit.DAYS);
        loginVO.setSession(session);
        loginVO.setAvatar(baseConfig.getOssDomain() + user.getAvatar());
        return new ResponseVO(loginVO);
    }

    /**
     * 注册新用户
     *
     * @param code2SessionResponseBO
     * @param loginDTO
     * @return
     */
    private LoginVO register(Code2SessionResponseBO code2SessionResponseBO, LoginDTO loginDTO)
    {
        GetUserInfoRquestBO getUserInfoRquestBO = CopyUtil.copy(loginDTO, GetUserInfoRquestBO.class);
        getUserInfoRquestBO.setSessionKey(code2SessionResponseBO.getSessionKey());
        GetUserInfoResponseBO getUserInfoResponseBO = ResponseVO.getData(
                apiFeign.getUserInfo(getUserInfoRquestBO), GetUserInfoResponseBO.class);
        Long userId = SnowFlakeUtil.nextId(System.currentTimeMillis());
        String avatar = saveAvatar(getUserInfoResponseBO.getAvatarUrl(), userId);
        User user = new User();
        user.setId(userId);
        user.setOpenid(getUserInfoResponseBO.getOpenId());
        user.setAvatar(avatar);
        user.setNickname(getUserInfoResponseBO.getNickName());
        user.setServiceTimes(0);
        user.setCommitCount(0);
        user.setCreateCount(0);
        user.setCreditScore(550);
        user.setEnjoyTimes(0);
        user.setIntegral(new BigDecimal("0"));
        user.setRole(UserTypeEnum.VISITOR.num.byteValue());
        user.setStatus(UserStatusEnum.NOT_CERTIFIED.num.byteValue());
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        userMapper.insert(user);
        String session = RedisKeyEnum.SESSION.prefix + user.getId() + ":" + UuidUtil.getUuid();
        redisUtil.valueOperations.set(session, code2SessionResponseBO.getSessionKey(), 7, TimeUnit.DAYS);
        LoginVO loginVO = CopyUtil.copy(user, LoginVO.class);
        loginVO.setVerified(false);
        loginVO.setRole(UserTypeEnum.VISITOR.name());
        loginVO.setCollection(0);
        loginVO.setFootprint(0);
        loginVO.setSession(session);
        return loginVO;
    }

    /**
     * 保存微信头像
     *
     * @param avatarUrl 微信头像url
     * @return
     */
    private String saveAvatar(String avatarUrl, Long id)
    {
        String suffix = ".jpg";
        FileInfoBO fileInfoBO = FileUtil.generateFileInfo(FileUseEnum.AVATAR.path, suffix, null);
        PutUrlRequestBO putUrlRequestBO = new PutUrlRequestBO();
        putUrlRequestBO.setUrl(avatarUrl);
        putUrlRequestBO.setObjectName(fileInfoBO.getObjectName());
        ResponseVO.check(apiFeign.putUrl(putUrlRequestBO));
        fileService.saveFileRecord(FileUseEnum.AVATAR, id, fileInfoBO, true);
        return fileInfoBO.getObjectName();
    }
}
