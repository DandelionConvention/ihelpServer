package com.services.cloud.tencent.lbs.controller;

import com.services.cloud.tencent.lbs.service.LbsService;
import com.services.core.vo.ResponseVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tencent/lbs")
public class LbsController
{
    public static final String BUSINESS_NAME = "腾讯位置服务";
    private final LbsService lbsService;

    public LbsController(LbsService lbsService)
    {
        this.lbsService = lbsService;
    }

    /**
     * 逆地址解析（坐标位置描述）
     *
     * @param location 经纬度 e.g:28.7033487,115.8660847
     * @return
     */
    @GetMapping("/coordinateDetail")
    public ResponseVO getCoordinateDetail(@RequestParam(value = "location") String location)
    {
        return lbsService.getCoordinateDetail(location);
    }

    /**
     * 地址解析（地址转坐标）
     *
     * @param address 地址 e.g:北京市海淀区彩和坊路海淀西大街74号
     * @return
     */
    @GetMapping("/addressDetail")
    public ResponseVO getAddressDetail(@RequestParam(value = "address") String address)
    {
        return lbsService.getAddressDetail(address);
    }
}
