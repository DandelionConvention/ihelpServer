package com.services.products.ihelp.miniapp.controller;

import com.services.core.vo.ResponseVO;
import com.services.products.ihelp.service.service.ReasonsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/reasons")
public class ReasonsController
{
    public static final String BUSINESS_NAME = "小程序 -> 服务取消原因";
    @Resource
    private ReasonsService reasonsService;

    /**
     * 返回服务取消原因列表
     *
     * @return
     */
    @GetMapping
    public ResponseVO listServiceCancelReason() {
        return reasonsService.listUsedServiceCancelReasons();
    }
}
