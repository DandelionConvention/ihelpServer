package com.services.core.config;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;

/**
 * 校验配置
 */
@Configuration
public class ValidatorConfig
{
    @Bean
    public Validator validator()
    {
        return Validation.byProvider(HibernateValidator.class).configure().failFast(true).buildValidatorFactory()
                .getValidator();
    }
}
