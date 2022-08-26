package com.services.products.ihelp.miniapp.controller;

import com.services.core.util.CopyUtil;
import com.services.core.vo.ResponseVO;
import com.services.products.ihelp.dao.domain.ServiceTag;
import com.services.products.ihelp.service.service.ServiceTagService;
import com.services.products.ihelp.service.vo.ListAllTagsVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/tags")
public class ServiceTagController
{
    public static final String BUSINESS_NAME = "小程序 -> 服务标签";
    @Resource
    private ServiceTagService serviceTagService;

    /**
     * 服务标签列表
     *
     * @return
     */
    @GetMapping
    public ResponseVO listTags()
    {
        ResponseVO responseVO = new ResponseVO();
        List<ServiceTag> serviceTagList = serviceTagService.list();
        List<ListAllTagsVO.ListBean> serviceTagVOList = CopyUtil.copyList(serviceTagList, ListAllTagsVO.ListBean.class);
        ListAllTagsVO listAllTagsVO = new ListAllTagsVO();
        listAllTagsVO.setList(serviceTagVOList);
        responseVO.setData(listAllTagsVO);
        return responseVO;
    }
}
