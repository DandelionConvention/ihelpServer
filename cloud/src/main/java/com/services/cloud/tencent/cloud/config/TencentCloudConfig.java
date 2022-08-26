package com.services.cloud.tencent.cloud.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 腾讯云配置
 */
@Component
@ConfigurationProperties(prefix = "tencent.cloud")
public class TencentCloudConfig
{
    private String secretId;

    private String secretKey;

    private String token;
    
    private String region;

    public String getSecretId()
    {
        return secretId;
    }

    public void setSecretId(String secretId)
    {
        this.secretId = secretId;
    }

    public String getSecretKey()
    {
        return secretKey;
    }

    public void setSecretKey(String secretKey)
    {
        this.secretKey = secretKey;
    }

    public String getToken()
    {
        return token;
    }

    public void setToken(String token)
    {
        this.token = token;
    }

    public String getRegion()
    {
        return region;
    }

    public void setRegion(String region)
    {
        this.region = region;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("TencentCloudConfig{");
        sb.append("secretId='").append(secretId).append('\'');
        sb.append(", secretKey='").append(secretKey).append('\'');
        sb.append(", token='").append(token).append('\'');
        sb.append(", region='").append(region).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
