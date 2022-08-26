package com.services.products.ihelp.miniapp.controller;

import com.services.core.util.RedisUtil;
import com.services.core.vo.ResponseVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/test")
public class TestController
{
    public static final String BUSINESS_NAME = "测试";
    private final RedisUtil redisUtil;

    public TestController(RedisUtil redisUtil)
    {
        this.redisUtil = redisUtil;
    }

    @GetMapping
    public ResponseVO test()
    {
        return new ResponseVO();
    }

    @PostMapping("/redis")
    public ResponseVO add(@RequestParam(value = "key") String key, @RequestParam(value = "value") String value)
    {
        redisUtil.valueOperations.set(key, value, 1, TimeUnit.HOURS);
        return new ResponseVO();
    }
}
