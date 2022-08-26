package com.services.products.ihelp.miniapp.controller;

import com.services.core.vo.ResponseVO;
import com.services.products.ihelp.service.service.AuthService;
import com.services.products.ihelp.dao.dto.LoginDTO;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController
{
    public static final String BUSINESS_NAME = "小程序 -> 微信登录";
    private final AuthService authService;

    public AuthController(AuthService authService)
    {
        this.authService = authService;
    }

    /**
     * 微信登录
     *
     * @param loginDTO
     * @return
     */
    @Transactional
    @PostMapping("/login")
    public ResponseVO login(@Validated @RequestBody LoginDTO loginDTO)
    {
        return authService.login(loginDTO);
    }
}
