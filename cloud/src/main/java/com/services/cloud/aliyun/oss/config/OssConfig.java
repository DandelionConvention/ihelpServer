package com.services.cloud.aliyun.oss.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * oss配置
 */
@Component
@ConfigurationProperties(prefix = "aliyun.oss")
public class OssConfig
{
    private String accessKeyId;
    private String accessKeySecret;
    private String endpoint;
    private String bucketName;
    private String domain;

    public String getAccessKeyId()
    {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId)
    {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessKeySecret()
    {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret)
    {
        this.accessKeySecret = accessKeySecret;
    }

    public String getEndpoint()
    {
        return endpoint;
    }

    public void setEndpoint(String endpoint)
    {
        this.endpoint = endpoint;
    }

    public String getBucketName()
    {
        return bucketName;
    }

    public void setBucketName(String bucketName)
    {
        this.bucketName = bucketName;
    }

    public String getDomain()
    {
        return domain;
    }

    public void setDomain(String domain)
    {
        this.domain = domain;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("OssConfig{");
        sb.append("accessKeyId='").append(accessKeyId).append('\'');
        sb.append(", accessKeySecret='").append(accessKeySecret).append('\'');
        sb.append(", endpoint='").append(endpoint).append('\'');
        sb.append(", bucketName='").append(bucketName).append('\'');
        sb.append(", domain='").append(domain).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
