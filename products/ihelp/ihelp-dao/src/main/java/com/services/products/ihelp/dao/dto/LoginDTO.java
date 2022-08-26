package com.services.products.ihelp.dao.dto;

import javax.validation.constraints.NotEmpty;

public class LoginDTO
{
    @NotEmpty(message = "code不能为空")
    private String code;
    @NotEmpty(message = "rawData不能为空")
    private String rawData;
    @NotEmpty(message = "signature不能为空")
    private String signature;
    @NotEmpty(message = "encryptedData不能为空")
    private String encryptedData;
    @NotEmpty(message = "iv不能为空")
    private String iv;

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
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
        final StringBuilder sb = new StringBuilder("LoginDTO{");
        sb.append("code='").append(code).append('\'');
        sb.append(", rawData='").append(rawData).append('\'');
        sb.append(", signature='").append(signature).append('\'');
        sb.append(", encryptedData='").append(encryptedData).append('\'');
        sb.append(", iv='").append(iv).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
