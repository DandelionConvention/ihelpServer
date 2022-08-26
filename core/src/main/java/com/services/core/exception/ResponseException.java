package com.services.core.exception;


import com.services.core.vo.ResponseVO;

/**
 * 返回异常
 */
public class ResponseException extends RuntimeException
{
    private ResponseVO responseVO;

    public ResponseException(ResponseVO responseVO)
    {
        super(responseVO.getMessage());
        this.responseVO = responseVO;
    }

    public ResponseVO getResponseVO()
    {
        return responseVO;
    }

    public void setResponseVO(ResponseVO responseVO)
    {
        this.responseVO = responseVO;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("ReturnException{");
        sb.append("responseVO=").append(responseVO);
        sb.append('}');
        return sb.toString();
    }

    /**
     * 不写入堆栈信息，提高性能
     */
    @Override
    public Throwable fillInStackTrace()
    {
        return this;
    }
}