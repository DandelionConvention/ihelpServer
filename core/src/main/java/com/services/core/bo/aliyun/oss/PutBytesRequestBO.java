package com.services.core.bo.aliyun.oss;

import java.util.Arrays;

public class PutBytesRequestBO
{
    private String objectName;
    private byte[] bytes;

    public String getObjectName()
    {
        return objectName;
    }

    public void setObjectName(String objectName)
    {
        this.objectName = objectName;
    }

    public byte[] getBytes()
    {
        return bytes;
    }

    public void setBytes(byte[] bytes)
    {
        this.bytes = bytes;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("PutBytesRequestBO{");
        sb.append("objectName='").append(objectName).append('\'');
        sb.append(", bytes=").append(Arrays.toString(bytes));
        sb.append('}');
        return sb.toString();
    }
}
