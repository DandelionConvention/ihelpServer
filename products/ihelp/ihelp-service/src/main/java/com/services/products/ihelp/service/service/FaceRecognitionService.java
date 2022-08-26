package com.services.products.ihelp.service.service;

import com.services.cloud.api.ApiFeign;
import com.services.core.bo.tencent.cloud.CompareFaceRequestBO;
import com.services.core.vo.ResponseVO;
import com.services.products.ihelp.dao.domain.User;
import com.services.products.ihelp.dao.mapper.UserMapper;
import com.services.products.ihelp.service.config.BaseConfig;
import com.services.products.ihelp.dao.dto.FaceRecognitionDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class FaceRecognitionService
{
    @Resource
    private UserMapper userMapper;
    private final ApiFeign apiFeign;
    private final BaseConfig baseConfig;

    public FaceRecognitionService(ApiFeign apiFeign, BaseConfig baseConfig)
    {
        this.apiFeign = apiFeign;
        this.baseConfig = baseConfig;
    }

    public ResponseVO faceRecognition(FaceRecognitionDTO faceRecognitionDTO)
    {
        User user = userMapper.selectByPrimaryKey(faceRecognitionDTO.getUserId());
        CompareFaceRequestBO compareFaceRequestBO = new CompareFaceRequestBO();
        compareFaceRequestBO.setUrlA(faceRecognitionDTO.getPhoto());
        compareFaceRequestBO.setUrlB(baseConfig.getOssDomain() + user.getPhoto());
        return ResponseVO.check(apiFeign.compareFace(compareFaceRequestBO));
    }
}
