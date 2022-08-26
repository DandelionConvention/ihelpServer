package com.services.products.ihelp.miniapp.controller;

import com.services.core.vo.ResponseVO;
import com.services.products.ihelp.dao.dto.FinishServiceOrderDTO;
import com.services.products.ihelp.dao.dto.ListServiceOrderServantsDTO;
import com.services.products.ihelp.dao.dto.ListServiceOrdersDTO;
import com.services.products.ihelp.dao.dto.SaveServiceApplicationDTO;
import com.services.products.ihelp.dao.dto.SaveServiceOrderDTO;
import com.services.products.ihelp.service.service.ServicesService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/services")
public class ServicesController
{
    public static final String BUSINESS_NAME = "小程序 -> 服务";

    private final ServicesService servicesService;

    public ServicesController(ServicesService servicesService)
    {
        this.servicesService = servicesService;
    }

    /**
     * 获取审核详情
     *
     * @param serviceId
     * @param servantId
     * @return
     */
    @GetMapping("/{serviceId}/servants/{servantId}")
    public ResponseVO getApplicationDetail(@PathVariable("serviceId") Long serviceId,
                                           @PathVariable("servantId") Long servantId)
    {
        return servicesService.getApplicationDetail(serviceId, servantId);
    }

    /**
     * 发布服务
     *
     * @param session
     * @param requestDto
     * @return
     */
    @PostMapping
    public ResponseVO saveServiceOrder(@RequestHeader(value = "session") String session,
                                       @Validated @RequestBody SaveServiceOrderDTO requestDto)
    {
        return servicesService.saveServiceOrder(session, requestDto);
    }

    /**
     * 申请服务
     *
     * @param session
     * @param orderId
     * @param requestDto
     * @return
     */
    @PostMapping("/{id}")
    public ResponseVO serviceApplication(@RequestHeader(value = "session") String session,
                                         @PathVariable(value = "id") Long orderId,
                                         @Validated @RequestBody SaveServiceApplicationDTO requestDto)
    {
        return servicesService.applyService(session, orderId, requestDto);
    }

    /**
     * 查询服务列表
     *
     * @param requestDto 传入Query
     * @return 响应数据
     */
    @GetMapping
    public ResponseVO listServices(ListServiceOrdersDTO requestDto)
    {

        return servicesService.listServices(requestDto);
    }

    /**
     * 查询服务申请者列表
     *
     * @param id 订单编号
     * @param requestDto 传入Query
     * @return 响应数据
     */
    @GetMapping("/{id}/servants")
    public ResponseVO listApplicants(@PathVariable(value = "id") Long id,
                                               ListServiceOrderServantsDTO requestDto)
    {
        return servicesService.listApplicants(id, requestDto);
    }

    /**
     * 通过服务申请
     *
     * @param session
     * @param orderId
     * @param servantId
     * @return
     */
    @PutMapping("/{id}/servants/{servant_id}")
    public ResponseVO passServiceApplication(@RequestHeader(value = "session") String session,
                                             @PathVariable(value = "id") Long orderId,
                                             @PathVariable(value = "servant_id") Long servantId)
    {
        return servicesService.passServiceApplication(session, orderId, servantId);
    }

    /**
     * 查询服务详情
     *
     * @param session
     * @param orderId
     * @return
     */
    @GetMapping("/{id}")
    public ResponseVO getServiceDetail(@RequestHeader(value = "session") String session,
                                         @PathVariable(value = "id") Long orderId)
    {
        return servicesService.getServiceDetail(session, orderId);
    }

    /**
     * 完成服务
     *
     * @param session
     * @param orderId
     * @param requestDto
     * @return
     */
    @PostMapping("/{id}/finished")
    public ResponseVO finishService(@RequestHeader(value = "session") String session,
                                         @PathVariable(value = "id") Long orderId,
                                         @Validated @RequestBody FinishServiceOrderDTO requestDto)
    {
        return servicesService.finishService(session, orderId, requestDto);
    }
}
