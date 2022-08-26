package com.services.core.bo.weixin.miniapp;

public class Code2SessionResponseBO
{
    private String sessionKey;
    private String openid;
    private String unionid;

    public String getSessionKey()
    {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey)
    {
        this.sessionKey = sessionKey;
    }

    public String getOpenid()
    {
        return openid;
    }

    public void setOpenid(String openid)
    {
        this.openid = openid;
    }

    public String getUnionid()
    {
        return unionid;
    }

    public void setUnionid(String unionid)
    {
        this.unionid = unionid;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("Code2SessionResponseBO{");
        sb.append("sessionKey='").append(sessionKey).append('\'');
        sb.append(", openid='").append(openid).append('\'');
        sb.append(", unionid='").append(unionid).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
