package com.services.cloud.tencent.cloud.service;

import com.alibaba.fastjson.JSON;
import com.services.cloud.exception.BusinessExceptionCode;
import com.services.cloud.tencent.cloud.config.TencentCloudConfig;
import com.services.core.bo.tencent.cloud.CompareFaceRequestBO;
import com.services.core.vo.ResponseVO;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.iai.v20200303.IaiClient;
import com.tencentcloudapi.iai.v20200303.models.CompareFaceRequest;
import com.tencentcloudapi.iai.v20200303.models.CompareFaceResponse;
import org.springframework.stereotype.Service;

@Service
public class IaiService
{
    private static final String END_POINT = "iai.tencentcloudapi.com";
    /**
     * 两张图片中人脸的相似度分数。一般超过50分则可认定为同一人
     */
    private final static Integer SCORE = 50;
    private final TencentCloudConfig tencentCloudConfig;

    public IaiService(TencentCloudConfig tencentCloudConfig)
    {
        this.tencentCloudConfig = tencentCloudConfig;
    }

    public ResponseVO compareFace(CompareFaceRequestBO compareFaceRequestBO)
    {
//        IaiClient client = getIaiClient();
//        compareFaceRequestBO.setQualityControl(4L);
//        String params = JSON.toJSONString(compareFaceRequestBO);
//        CompareFaceRequest req = CompareFaceRequest.fromJsonString(params, CompareFaceRequest.class);
//        CompareFaceResponse compareFaceResponse;
//        try
//        {
//            compareFaceResponse = client.CompareFace(req);
//        } catch (TencentCloudSDKException e)
//        {
//            throw BusinessExceptionCode.COMPARE_FACE_ERROR.exception(e);
//        }
//        // 人脸不匹配
//        if (compareFaceResponse.getScore() < SCORE)
//        {
//            BusinessExceptionCode.FACE_MISMATCH.throwException();
//        }

        return new ResponseVO();
    }

    /**
     * client配置
     *
     * @return
     */
    private IaiClient getIaiClient()
    {
        Credential cred = new Credential(tencentCloudConfig.getSecretId(), tencentCloudConfig.getSecretKey());
        HttpProfile httpProfile = new HttpProfile();
        httpProfile.setEndpoint(END_POINT);
        ClientProfile clientProfile = new ClientProfile();
        clientProfile.setHttpProfile(httpProfile);
        return new IaiClient(cred, tencentCloudConfig.getRegion(), clientProfile);
    }
}
