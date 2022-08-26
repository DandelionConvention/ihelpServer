package com.services.cloud.wx.miniapp.controller;

import com.services.cloud.wx.miniapp.service.UserService;
import com.services.core.bo.weixin.miniapp.GetUserInfoRquestBO;
import com.services.core.vo.ResponseVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("wx/miniapp/user")
public class UserController
{
    public static final String BUSINESS_NAME = "微信小程序服务 -> 用户";
    private final UserService userService;

    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    /**
     * 获取登录后的session信息
     *
     * @param code 登录时获取的code
     * @return
     */
    @GetMapping("/code2session")
    public ResponseVO getSessionInfo(@RequestParam(value = "code") String code)
    {
        return userService.getSessionInfo(code);
    }

    /**
     * 获取用户信息
     *
     * @param getUserInfoRquestBO
     * @return
     */
    @PostMapping("/getUserInfo")
    public ResponseVO getUserInfo(@RequestBody GetUserInfoRquestBO getUserInfoRquestBO)
    {
        return userService.getUserInfo(getUserInfoRquestBO);
    }
}
