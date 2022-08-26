package com.services.cloud.tencent.cloud.controller;

import com.services.cloud.tencent.cloud.service.IaiService;
import com.services.core.bo.tencent.cloud.CompareFaceRequestBO;
import com.services.core.vo.ResponseVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tencent/cloud/iai")
public class IaiController
{
    public static final String BUSINESS_NAME = "腾讯云 -> 人脸识别";
    private final IaiService iaiService;

    public IaiController(IaiService iaiService)
    {
        this.iaiService = iaiService;
    }

    /**
     * 人脸比对
     *
     * @param compareFaceRequestBO
     * @return
     */
    @PostMapping("/compareFace")
    public ResponseVO compareFace(@RequestBody CompareFaceRequestBO compareFaceRequestBO)
    {
        return iaiService.compareFace(compareFaceRequestBO);
    }
}
