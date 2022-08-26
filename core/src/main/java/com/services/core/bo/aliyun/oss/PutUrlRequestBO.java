package com.services.core.bo.aliyun.oss;

public class PutUrlRequestBO
{
    private String objectName;
    private String url;

    public String getObjectName()
    {
        return objectName;
    }

    public void setObjectName(String objectName)
    {
        this.objectName = objectName;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("PutUrlRequestBO{");
        sb.append("objectName='").append(objectName).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
