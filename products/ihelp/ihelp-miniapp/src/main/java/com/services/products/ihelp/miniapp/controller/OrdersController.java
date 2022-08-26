package com.services.products.ihelp.miniapp.controller;

import com.services.core.vo.ResponseVO;
import com.services.products.ihelp.dao.dto.CancelServiceOrderDTO;
import com.services.products.ihelp.dao.dto.ListOrdersDTO;
import com.services.products.ihelp.service.service.OrdersServices;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrdersController
{
    public static final String BUSINESS_NAME = "小程序 -> 服务订单";
    private final OrdersServices ordersServices;

    public OrdersController(OrdersServices ordersServices)
    {
        this.ordersServices = ordersServices;
    }

    /**
     * 取消服务订单
     *
     * @param session
     * @param requestDto
     * @return
     */
    @PutMapping("/cancel")
    public ResponseVO cancelServiceOrder(@Validated @RequestBody CancelServiceOrderDTO requestDto)
    {
        return ordersServices.cancelServiceOrder(requestDto);
    }

    /**
     * 查询订单列表
     *
     * @param session
     * @param listOrdersDTO
     * @return
     */
    @GetMapping
    public ResponseVO listOrders(@RequestHeader(value = "session") String session,
                                    ListOrdersDTO listOrdersDTO)
    {
        return ordersServices.listOrders(session, listOrdersDTO);
    }

    /**
     * 查询订单详情
     *
     * @param orderId
     * @return
     */
    @GetMapping("/{id}")
    public ResponseVO getOrderDetail(@PathVariable(value = "id") Long orderId)
    {
        return ordersServices.getOrderDetail(orderId);
    }
}
