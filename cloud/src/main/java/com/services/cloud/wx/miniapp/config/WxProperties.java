package com.services.cloud.wx.miniapp.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 微信小程序属性
 */
@Component
@ConfigurationProperties(prefix = "wx.miniapp")
public class WxProperties {
    /**
     * 设置微信小程序的appid
     */
    private String appid;

    /**
     * 设置微信小程序的Secret
     */
    private String secret;

    /**
     * 设置微信小程序消息服务器配置的token
     */
    private String token;

    /**
     * 设置微信小程序消息服务器配置的EncodingAESKey
     */
    private String aesKey;

    /**
     * 消息格式，XML或者JSON
     */
    private String msgDataFormat;

    public String getAppid()
    {
        return appid;
    }

    public void setAppid(String appid)
    {
        this.appid = appid;
    }

    public String getSecret()
    {
        return secret;
    }

    public void setSecret(String secret)
    {
        this.secret = secret;
    }

    public String getToken()
    {
        return token;
    }

    public void setToken(String token)
    {
        this.token = token;
    }

    public String getAesKey()
    {
        return aesKey;
    }

    public void setAesKey(String aesKey)
    {
        this.aesKey = aesKey;
    }

    public String getMsgDataFormat()
    {
        return msgDataFormat;
    }

    public void setMsgDataFormat(String msgDataFormat)
    {
        this.msgDataFormat = msgDataFormat;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("WxProperties{");
        sb.append("appid='").append(appid).append('\'');
        sb.append(", secret='").append(secret).append('\'');
        sb.append(", token='").append(token).append('\'');
        sb.append(", aesKey='").append(aesKey).append('\'');
        sb.append(", msgDataFormat='").append(msgDataFormat).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
