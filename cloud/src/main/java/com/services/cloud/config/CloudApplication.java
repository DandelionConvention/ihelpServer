package com.services.cloud.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@ComponentScan("com.services")
public class CloudApplication
{

    private static final Logger logger = LoggerFactory.getLogger(CloudApplication.class);

    public static void main(String[] args)
    {
        SpringApplication app = new SpringApplication(CloudApplication.class);
        Environment env = app.run(args).getEnvironment();
        logger.info("地址: \thttp://127.0.0.1:{}", env.getProperty("server.port"));
    }

}
