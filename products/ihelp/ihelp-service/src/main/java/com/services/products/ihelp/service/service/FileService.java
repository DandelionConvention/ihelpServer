package com.services.products.ihelp.service.service;

import com.services.cloud.api.ApiFeign;
import com.services.core.bo.FileInfoBO;
import com.services.core.bo.aliyun.oss.PutBytesRequestBO;
import com.services.core.util.CopyUtil;
import com.services.core.util.FileUtil;
import com.services.core.vo.ResponseVO;
import com.services.products.ihelp.dao.domain.File;
import com.services.products.ihelp.dao.mapper.FileMapper;
import com.services.products.ihelp.service.config.BaseConfig;
import com.services.products.ihelp.service.enums.FileUseEnum;
import com.services.products.ihelp.service.util.RedisKeyUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@Service
public class FileService
{
    private final ApiFeign apiFeign;
    private final BaseConfig baseConfig;

    public FileService(ApiFeign apiFeign, BaseConfig baseConfig)
    {
        this.apiFeign = apiFeign;
        this.baseConfig = baseConfig;
    }

    @Resource
    private FileMapper fileMapper;

    @Transactional
    public ResponseVO upload(MultipartFile file, String use, String session)
    {
        Long userId = RedisKeyUtil.getUserId(session);
        FileUseEnum fileUseEnum = FileUseEnum.getEnumByName(use);
        String suffix = FileUtil.getSuffix(file.getOriginalFilename());
        byte[] bytes = FileUtil.multipartFileToBytes(file);
        FileInfoBO fileInfoBO = FileUtil.generateFileInfo(fileUseEnum.path, suffix, bytes.length);
        PutBytesRequestBO putBytesRequestBO = new PutBytesRequestBO();
        putBytesRequestBO.setBytes(bytes);
        putBytesRequestBO.setObjectName(fileInfoBO.getObjectName());
        ResponseVO.check(apiFeign.putBytes(putBytesRequestBO));
        saveFileRecord(fileUseEnum, userId, fileInfoBO, false);
        return new ResponseVO(baseConfig.getOssDomain() + fileInfoBO.getObjectName());
    }

    /**
     * 保存上传记录
     *
     * @param fileUseEnum 文件用途
     * @param userId 用户id
     * @param size 文件大小
     * @param fileInfoBO
     */
    public void saveFileRecord(FileUseEnum fileUseEnum, Long userId, FileInfoBO fileInfoBO, Boolean isUsed)
    {
        File file = CopyUtil.copy(fileInfoBO, File.class);
        file.setUse(fileUseEnum.num.byteValue());
        file.setIsUsed(isUsed);
        file.setUserId(userId);
        file.setCreateTime(LocalDateTime.now());
        file.setUpdateTime(LocalDateTime.now());
        fileMapper.insert(file);
    }
}
