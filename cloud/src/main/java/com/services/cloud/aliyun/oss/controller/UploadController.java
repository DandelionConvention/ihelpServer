package com.services.cloud.aliyun.oss.controller;

import com.services.cloud.aliyun.oss.service.UploadService;
import com.services.core.bo.aliyun.oss.PutBytesRequestBO;
import com.services.core.bo.aliyun.oss.PutUrlRequestBO;
import com.services.core.vo.ResponseVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aliyun/oss/upload")
public class UploadController
{
    public static final String BUSINESS_NAME = "阿里云oss -> 上传文件";
    private final UploadService uploadService;

    public UploadController(UploadService uploadService)
    {
        this.uploadService = uploadService;
    }

    /**
     * 上传bytes
     *
     * @param putBytesRequestBO
     * @return
     */
    @PostMapping("/putBytes")
    public ResponseVO putBytes(@RequestBody PutBytesRequestBO putBytesRequestBO)
    {
        return uploadService.putBytes(putBytesRequestBO);
    }

    /**
     * 上传网络流
     *
     * @param putUrlRequestBO
     * @return
     */
    @PostMapping("/putUrl")
    public ResponseVO putUrl(@RequestBody PutUrlRequestBO putUrlRequestBO)
    {
        return uploadService.putUrl(putUrlRequestBO);
    }
}
