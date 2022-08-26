package com.services.core.bo.weixin.miniapp;

public class GetUserInfoRquestBO
{
    private String sessionKey;
    private String rawData;
    private String signature;
    private String encryptedData;
    private String iv;

    public String getSessionKey()
    {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey)
    {
        this.sessionKey = sessionKey;
    }

    public String getRawData()
    {
        return rawData;
    }

    public void setRawData(String rawData)
    {
        this.rawData = rawData;
    }

    public String getSignature()
    {
        return signature;
    }

    public void setSignature(String signature)
    {
        this.signature = signature;
    }

    public String getEncryptedData()
    {
        return encryptedData;
    }

    public void setEncryptedData(String encryptedData)
    {
        this.encryptedData = encryptedData;
    }

    public String getIv()
    {
        return iv;
    }

    public void setIv(String iv)
    {
        this.iv = iv;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("GetUserInfoRquestBO{");
        sb.append("sessionKey='").append(sessionKey).append('\'');
        sb.append(", rawData='").append(rawData).append('\'');
        sb.append(", signature='").append(signature).append('\'');
        sb.append(", encryptedData='").append(encryptedData).append('\'');
        sb.append(", iv='").append(iv).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
