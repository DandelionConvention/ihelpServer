package com.services.cloud.controller;

import com.services.core.vo.ResponseVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController
{
    public static final String BUSINESS_NAME = "测试";

    @GetMapping
    public ResponseVO test()
    {
        return new ResponseVO();
    }
}
