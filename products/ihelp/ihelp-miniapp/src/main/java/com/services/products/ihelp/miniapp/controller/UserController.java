package com.services.products.ihelp.miniapp.controller;

import com.services.core.vo.ResponseVO;
import com.services.products.ihelp.dao.dto.PageDTO;
import com.services.products.ihelp.service.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController
{
    public static final String BUSINESS_NAME = "小程序 -> 用户";
    private final UserService userService;

    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    /**
     * 获取他的服务
     *
     * @param id
     * @param pageDTO
     * @return
     */
    @GetMapping("/{id}/services")
    public ResponseVO listHisServices(@PathVariable("id") Long id, PageDTO pageDTO)
    {
        return userService.listHisServices(id, pageDTO);
    }

    /**
     * 获取用户详情
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseVO getUserDetail(@PathVariable("id") Long id)
    {
        return userService.getUserDetail(id);
    }

    /**
     * 获取我的信息
     *
     * @param session
     * @return
     */
    @GetMapping
    public ResponseVO getMyfInfo(@RequestHeader("session") String session)
    {
        return userService.getMyInfo(session);
    }

    /**
     * 获取服务者照片
     *
     * @param id 服务者id
     * @return
     */
    @GetMapping("/photo/{id}")
    public ResponseVO getUserPhoto(@PathVariable("id") Long id)
    {
        return userService.getUserPhoto(id);
    }
}
