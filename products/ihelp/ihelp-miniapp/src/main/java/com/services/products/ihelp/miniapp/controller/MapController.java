package com.services.products.ihelp.miniapp.controller;

import com.services.core.vo.ResponseVO;
import com.services.products.ihelp.service.service.MapService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;

@RestController
@RequestMapping("/map")
@Validated
public class MapController
{
    public static final String BUSINESS_NAME = "微信小程序 -> 腾讯位置服务";
    private final MapService mapService;

    public MapController(MapService mapService)
    {
        this.mapService = mapService;
    }

    /**
     * 逆地址解析（坐标位置描述）
     *
     * @param location 经纬度 e.g:28.7033487,115.8660847
     * @return
     */
    @GetMapping("/coordinate-detail")
    public ResponseVO getCoordinateDetail(@NotEmpty(message = "地址不能为空") @RequestParam(value = "location")
                                                      String location)
    {
        return mapService.getCoordinateDetail(location);
    }
}
