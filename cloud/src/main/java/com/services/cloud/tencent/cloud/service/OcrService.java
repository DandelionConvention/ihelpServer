package com.services.cloud.tencent.cloud.service;

import com.alibaba.fastjson.JSON;
import com.services.cloud.enums.IDCardWarnEnum;
import com.services.cloud.exception.BusinessExceptionCode;
import com.services.cloud.tencent.cloud.config.TencentCloudConfig;
import com.services.core.bo.tencent.cloud.IDCardOcrRequestBO;
import com.services.core.bo.tencent.cloud.IDCardOcrResponseBO;
import com.services.core.util.CopyUtil;
import com.services.core.vo.ResponseVO;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.ocr.v20181119.OcrClient;
import com.tencentcloudapi.ocr.v20181119.models.IDCardOCRRequest;
import com.tencentcloudapi.ocr.v20181119.models.IDCardOCRResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OcrService
{
    private final static String END_POINT = "ocr.tencentcloudapi.com";
    /**
     * ocr.tencentcloudapi.com
     * 图片质量分数，请求 Config.Quality 时返回（取值范围：0~100，分数越低越模糊，建议阈值≥50）
     */
    private final static Integer QUALITY = 50;
    /**
     * 身份证边框不完整告警阈值分数，请求 Config.BorderCheckWarn时返回（取值范围：0~100，分数越低边框遮挡可能性越低，建议阈值≥50）
     */
    private final static Integer BORDER_CODE_VALUE = 50;
    private final TencentCloudConfig tencentCloudConfig;

    public OcrService(TencentCloudConfig tencentCloudConfig)
    {
        this.tencentCloudConfig = tencentCloudConfig;
    }

    public ResponseVO idCardOcr(IDCardOcrRequestBO idCardOcrRequestBO)
    {
        idCardOCRConfig(idCardOcrRequestBO);
        OcrClient client = getOcrClient();
        String params = JSON.toJSONString(idCardOcrRequestBO);
        System.out.println("--->");
        System.out.println(params);
        IDCardOCRRequest req = IDCardOCRRequest.fromJsonString(params, IDCardOCRRequest.class);
        IDCardOCRResponse idCardOcrResponse;
        try
        {
            idCardOcrResponse = client.IDCardOCR(req);
        } catch (TencentCloudSDKException e)
        {
            throw BusinessExceptionCode.ID_CARD_OCR_ERROR.exception(e);
        }
        IDCardOcrResponseBO idCardOcrResponseBO = CopyUtil.copy(idCardOcrResponse, IDCardOcrResponseBO.class);
        idCardCheck(idCardOcrResponseBO.advancedInfoBean());
        return new ResponseVO(idCardOcrResponseBO);
    }

    /**
     * client配置
     *
     * @return
     */
    private OcrClient getOcrClient()
    {
        Credential cred = new Credential(tencentCloudConfig.getSecretId(), tencentCloudConfig.getSecretKey());
        HttpProfile httpProfile = new HttpProfile();
        httpProfile.setEndpoint(END_POINT);
        ClientProfile clientProfile = new ClientProfile();
        clientProfile.setHttpProfile(httpProfile);
        return new OcrClient(cred, tencentCloudConfig.getRegion(), clientProfile);
    }

    /**
     * 身份证识别配置
     *
     * @return
     */
    private void idCardOCRConfig(IDCardOcrRequestBO idCardOcrRequestBO)
    {
        IDCardOcrRequestBO.ConfigBean configBean = new IDCardOcrRequestBO.ConfigBean();
        configBean.setBorderCheckWarn(true);
        //configBean.setCopyWarn(true);
        configBean.setCropPortrait(true);
        configBean.setDetectPsWarn(true);
        configBean.setInvalidDateWarnf(true);
        configBean.setMultiCardDetect(true);
        configBean.setQuality(true);
        configBean.setReshootWarn(true);
        configBean.setTempIdWarn(true);
        //configBean.setReflectWarn(true);
        idCardOcrRequestBO.setConfig(JSON.toJSONString(configBean));
    }

    /**
     * 身份证检查
     *
     * @param advanceInfoBean
     */
    private void idCardCheck(IDCardOcrResponseBO.AdvanceInfoBean advanceInfoBean)
    {
        // 图像模糊
        if (advanceInfoBean.getQuality() <= QUALITY)
        {
            BusinessExceptionCode.IMAGE_BLUR.throwException();
        }
        // 身份证边框不完整
        if (advanceInfoBean.getBorderCodeValue() >= BORDER_CODE_VALUE)
        {
            BusinessExceptionCode.ID_CARD_BORDER_CHECK_WARN.throwException();
        }
        // 身份证告警信息
        List<Integer> warnInfos = advanceInfoBean.getWarnInfos();
        if (warnInfos.size() > 0)
        {
            IDCardWarnEnum.check(warnInfos.get(0));
        }
    }
}
