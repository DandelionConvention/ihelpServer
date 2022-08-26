package com.services.products.ihelp.miniapp.config;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@ComponentScan("com.services")
@MapperScan("com.services.products.ihelp.dao.mapper")
@EnableFeignClients("com.services.cloud.api")
public class MiniappApplication
{

    private static final Logger logger = LoggerFactory.getLogger(MiniappApplication.class);

    public static void main(String[] args)
    {
        SpringApplication app = new SpringApplication(MiniappApplication.class);
        Environment env = app.run(args).getEnvironment();
        logger.info("地址: \thttp://127.0.0.1:{}", env.getProperty("server.port"));
    }

}
