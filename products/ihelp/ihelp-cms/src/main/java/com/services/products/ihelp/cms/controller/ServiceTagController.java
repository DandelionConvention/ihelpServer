package com.services.products.ihelp.cms.controller;

import com.services.core.util.CopyUtil;
import com.services.core.vo.ResponseVO;
import com.services.products.ihelp.dao.domain.ServiceTag;
import com.services.products.ihelp.dao.dto.SaveServiceTagDTO;
import com.services.products.ihelp.dao.dto.UpdateServiceTagDTO;
import com.services.products.ihelp.service.service.ServiceTagService;
import com.services.products.ihelp.service.vo.ListAllTagsVO;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/tags")
public class ServiceTagController
{
    public static final String BUSINESS_NAME = "管理后台 -> 服务标签";
    @Resource
    private ServiceTagService serviceTagService;


    /**
     * 添加服务标签
     *
     * @param saveServiceTagDTO
     * @return
     */
    @Transactional
    @PostMapping
    public ResponseVO saveServiceTag(@RequestBody @Validated SaveServiceTagDTO saveServiceTagDTO){
        ServiceTag serviceTag = CopyUtil.copy(saveServiceTagDTO, ServiceTag.class);
        serviceTag.setIsUsed(saveServiceTagDTO.getIsUsed());
        serviceTagService.saveServiceTag(serviceTag);
        return listTags();
    }


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


    /**
     * 服务标签更新
     *
     * @param id
     * @param updateServiceTagDTO
     * @return
     */
    @Transactional
    @PatchMapping("/{id}")
    public ResponseVO updateServiceTag(@PathVariable(value = "id") Integer id, @Validated @RequestBody UpdateServiceTagDTO updateServiceTagDTO){
        serviceTagService.updateServiceTag(id, updateServiceTagDTO);
        return listTags();
    }

    /**
     * 删除服务标签
     *
     * @param id
     * @return
     */
    @Transactional
    @DeleteMapping("/{id}")
    public ResponseVO deleteServiceTag(@PathVariable(value = "id") Integer id) {
        serviceTagService.deleteServiceTag(id);
        return listTags();
    }
}
