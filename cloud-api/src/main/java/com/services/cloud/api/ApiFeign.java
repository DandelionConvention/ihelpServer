package com.services.cloud.api;

import com.services.core.bo.aliyun.oss.PutBytesRequestBO;
import com.services.core.bo.aliyun.oss.PutUrlRequestBO;
import com.services.core.bo.tencent.cloud.CompareFaceRequestBO;
import com.services.core.bo.tencent.cloud.IDCardOcrRequestBO;
import com.services.core.bo.weixin.miniapp.GetUserInfoRquestBO;
import com.services.core.vo.ResponseVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 阿里云oss
 */
@FeignClient(value = "cloud", path = "cloud")
public interface ApiFeign
{
    /**
     * 阿里云oss上传网络流
     *
     * @param putUrlRequestBO
     * @return
     */
    @PostMapping("/aliyun/oss/upload/putUrl")
    ResponseVO putUrl(@RequestBody PutUrlRequestBO putUrlRequestBO);

    /**
     * 阿里云oss上传bytes
     *
     * @param putBytesRequestBO
     * @return
     */
    @PostMapping("/aliyun/oss/upload/putBytes")
    ResponseVO putBytes(@RequestBody PutBytesRequestBO putBytesRequestBO);

    /**
     * 腾讯位置服务逆地址解析（坐标位置描述）
     *
     * @param location 经纬度 e.g:28.7033487,115.8660847
     * @return
     */
    @GetMapping("/tencent/lbs/coordinateDetail")
    ResponseVO getCoordinateDetail(@RequestParam(value = "location") String location);

    /**
     * 腾讯位置服务地址解析（地址转坐标）
     *
     * @param address 地址 e.g:北京市海淀区彩和坊路海淀西大街74号
     * @return
     */
    @GetMapping("/tencent/lbs/addressDetail")
    ResponseVO getAddressDetail(@RequestParam(value = "address") String address);

    /**
     * 腾讯云身份证识别
     *
     * @param idCardOcrRequestBO
     * @return
     */
    @PostMapping("/tencent/cloud/ocr/idCard")
    ResponseVO idCardOcr(@RequestBody IDCardOcrRequestBO idCardOcrRequestBO);

    /**
     * 腾讯云人脸比对
     *
     * @param compareFaceRequestBO
     * @return
     */
    @PostMapping("/tencent/cloud/iai/compareFace")
    ResponseVO compareFace(@RequestBody CompareFaceRequestBO compareFaceRequestBO);

    /**
     * 获取微信小程序session
     *
     * @param code
     * @return
     */
    @GetMapping("/wx/miniapp/user/code2session")
    ResponseVO getSessionInfo(@RequestParam(value = "code") String code);

    /**
     * 微信小程序获取用户信息
     *
     * @param getUserInfoRquestBO
     * @return
     */
    @PostMapping("/wx/miniapp/user/getUserInfo")
    ResponseVO getUserInfo(@RequestBody GetUserInfoRquestBO getUserInfoRquestBO);
}
