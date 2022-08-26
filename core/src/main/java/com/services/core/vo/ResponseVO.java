package com.services.core.vo;

import com.alibaba.fastjson.JSON;
import com.services.core.exception.ResponseException;

/**
 * 响应数据结构
 */
public class ResponseVO<T>
{
    public static final String OK = "ok";

    /**
     * 返回码
     */
    private String status = OK;

    /**
     * 消息
     */
    private String message;

    /**
     * 详情
     */
    private String detail;

    /**
     * 返回数据
     */
    private T data;
    private Exception exception;

    public JSON dataJson()
    {
        return (JSON) JSON.toJSON(data);
    }

    public static ResponseVO check(ResponseVO responseVO)
    {
        if (!ResponseVO.OK.equals(responseVO.getStatus()))
        {
            throw new ResponseException(responseVO);
        }
        return new ResponseVO();
    }

    public static <T> T getData(ResponseVO responseVO, Class<T> clazz)
    {
        check(responseVO);
        return JSON.toJavaObject(responseVO.dataJson(), clazz);
    }

    public ResponseVO()
    {
    }

    public ResponseVO(T data)
    {
        this.data = data;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public String getDetail()
    {
        return detail;
    }

    public void setDetail(String detail)
    {
        this.detail = detail;
    }

    public T getData()
    {
        return data;
    }

    public void setData(T data)
    {
        this.data = data;
    }

    public Exception getException()
    {
        return exception;
    }

    public void setException(Exception exception)
    {
        this.exception = exception;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("ResponseVO{");
        sb.append("status='").append(status).append('\'');
        sb.append(", message='").append(message).append('\'');
        sb.append(", detail='").append(detail).append('\'');
        sb.append(", data=").append(data);
        sb.append(", exception=").append(exception);
        sb.append('}');
        return sb.toString();
    }
}
