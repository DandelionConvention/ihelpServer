package com.services.cloud.tencent.cloud.controller;

import com.services.cloud.tencent.cloud.service.OcrService;
import com.services.core.bo.tencent.cloud.IDCardOcrRequestBO;
import com.services.core.vo.ResponseVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tencent/cloud/ocr")
public class OcrController
{
    public static final String BUSINESS_NAME = "腾讯云 -> 文字识别";
    private final OcrService ocrService;

    public OcrController(OcrService ocrService)
    {
        this.ocrService = ocrService;
    }

    /**
     * 身份证识别
     *
     * @param idCardOcrRequestBO
     * @return
     */
    @PostMapping("/idCard")
    public ResponseVO idCardOcr(@RequestBody IDCardOcrRequestBO idCardOcrRequestBO)
    {
        return ocrService.idCardOcr(idCardOcrRequestBO);
    }
}