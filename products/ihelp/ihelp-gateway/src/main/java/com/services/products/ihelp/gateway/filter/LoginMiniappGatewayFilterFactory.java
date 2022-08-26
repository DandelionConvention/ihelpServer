package com.services.products.ihelp.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 微信小程序filterFactory
 */
@Component
public class LoginMiniappGatewayFilterFactory extends AbstractGatewayFilterFactory<Object>
{

    @Resource
    LoginMiniappGatewayFilter loginMiniappGatewayFilter;

    @Override
    public GatewayFilter apply(Object config) {
        return loginMiniappGatewayFilter;
    }
}