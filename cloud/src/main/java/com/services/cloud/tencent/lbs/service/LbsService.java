package com.services.cloud.tencent.lbs.service;

import com.services.cloud.tencent.lbs.config.TencentLbsConfig;
import com.services.core.bo.tencent.lbs.AddressDetailResponseBO;
import com.services.core.bo.tencent.lbs.CoordinateDetailResponseBO;
import com.services.core.vo.ResponseVO;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

@Service
public class LbsService
{
    private static final String BASE_URL = "https://apis.map.qq.com";
    private final RestTemplate restTemplate;
    private final TencentLbsConfig tencentLbsConfig;

    public LbsService(RestTemplate restTemplate, TencentLbsConfig tencentLbsConfig)
    {
        this.restTemplate = restTemplate;
        this.tencentLbsConfig = tencentLbsConfig;
    }

    public ResponseVO getCoordinateDetail(String location)
    {
        String path = "/ws/geocoder/v1";
        String parameters = "?key=" + tencentLbsConfig.getKey() + "&location=" + location;
        String s = path + parameters + tencentLbsConfig.getSecretKey();
        String sig = DigestUtils.md5DigestAsHex(s.getBytes(StandardCharsets.UTF_8));
        String url = BASE_URL + path + parameters + "&sig=" + sig;
        return new ResponseVO(restTemplate.getForObject(url, CoordinateDetailResponseBO.class));
    }

    public ResponseVO getAddressDetail(String address)
    {
        String path = "/ws/geocoder/v1";
        String parameters = "?address=" + address + "&key=" + tencentLbsConfig.getKey();
        String s = path + parameters + tencentLbsConfig.getSecretKey();
        String sig = DigestUtils.md5DigestAsHex(s.getBytes(StandardCharsets.UTF_8));
        String url = BASE_URL + path + parameters + "&sig=" + sig;
        return new ResponseVO(restTemplate.getForObject(url, AddressDetailResponseBO.class));
    }
}
