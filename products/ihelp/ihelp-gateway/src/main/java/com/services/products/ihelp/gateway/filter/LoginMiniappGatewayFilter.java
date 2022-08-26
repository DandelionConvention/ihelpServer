package com.services.products.ihelp.gateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;

/**
 * 微信小程序filter
 */
@Component
public class LoginMiniappGatewayFilter implements GatewayFilter, Ordered
{

    private static final Logger logger = LoggerFactory.getLogger(LoginMiniappGatewayFilter.class);

    private final StringRedisTemplate redisTemplate;

    public LoginMiniappGatewayFilter(StringRedisTemplate redisTemplate)
    {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String path = exchange.getRequest().getURI().getPath();
        String basePath = "/mp/";
        String loginPath = "/mp/auth/login";
        // 放行
        if (!path.contains(basePath) || path.contains(loginPath)) {
            return chain.filter(exchange);
        }
        String session = exchange.getRequest().getHeaders().getFirst("session");
        logger.warn("微信小程序登录拦截 -> path: {}, session：{}", path, session);
        if (session == null || session.isEmpty()) {
            logger.warn( "session为空，请求被拦截" );
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
        Object object = redisTemplate.opsForValue().get(session);
        if (object == null) {
            logger.warn( "session无效，请求被拦截" );
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        } else {
            logger.info("已登录：{}", object);
            // 延长session有效期
            redisTemplate.expire(session, 3, TimeUnit.DAYS);
            return chain.filter(exchange);
        }
    }

    @Override
    public int getOrder()
    {
        return 1;
    }
}