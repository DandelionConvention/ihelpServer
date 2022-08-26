package com.services.products.ihelp.cms.controller;

import com.services.core.vo.ResponseVO;
import com.services.products.ihelp.dao.dto.SaveServiceCancelReasonDTO;
import com.services.products.ihelp.dao.dto.UpdateServiceCancelReasonDTO;
import com.services.products.ihelp.service.service.ReasonsService;
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

@RestController
@RequestMapping("/reasons")
public class ReasonsController
{
    public static final String BUSINESS_NAME = "管理后台 -> 服务取消原因";
    @Resource
    private ReasonsService reasonsService;

    /**
     * 添加服务取消原因
     *
     * @param saveServiceCancelReasonDTO
     * @return
     */
    @PostMapping
    public ResponseVO saveServiceCancelReason(
            @Validated @RequestBody SaveServiceCancelReasonDTO saveServiceCancelReasonDTO)
    {
        return reasonsService.saveServiceCancelReason(saveServiceCancelReasonDTO);
    }

    /**
     * 返回服务取消原因列表
     *
     * @return
     */
    @GetMapping
    public ResponseVO listServiceCancelReason() {
        return reasonsService.listAllServiceCancelReasons();
    }

    /**
     * 更新服务取消原因
     *
     * @param id
     * @param updateServiceCancelReasonDTO
     * @return
     */
    @PatchMapping("/{id}")
    public ResponseVO updateServiceCancelReason(
            @PathVariable(value = "id") Integer id,
            @Validated @RequestBody UpdateServiceCancelReasonDTO updateServiceCancelReasonDTO) {
        return reasonsService.updateServiceCancelReason(id, updateServiceCancelReasonDTO);
    }

    /**
     * 删除服务取消原因
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseVO deleteServiceCancelReason(@PathVariable(value = "id") Integer id) {
        return reasonsService.deleteServiceCancelReason(id);
    }
}
