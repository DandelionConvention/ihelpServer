package com.services.products.ihelp.service.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 基本配置
 */
@Component
@ConfigurationProperties(prefix = "base")
public class BaseConfig
{
    private String ossDomain;

    public String getOssDomain()
    {
        return ossDomain;
    }

    public void setOssDomain(String ossDomain)
    {
        this.ossDomain = ossDomain;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("BaseConfig{");
        sb.append("ossDomain='").append(ossDomain).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
