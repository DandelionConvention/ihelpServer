package com.services.cloud.tencent.lbs.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 腾讯位置服务配置
 */
@Component
@ConfigurationProperties(prefix = "tencent.lbs")
public class TencentLbsConfig
{
    private String key;
    private String secretKey;

    public String getKey()
    {
        return key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }

    public String getSecretKey()
    {
        return secretKey;
    }

    public void setSecretKey(String secretKey)
    {
        this.secretKey = secretKey;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("TencentLbsConfig{");
        sb.append("key='").append(key).append('\'');
        sb.append(", secretKey='").append(secretKey).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
