package com.services.cloud.exception;

/**
 * 业务异常
 */
public class BusinessException extends RuntimeException
{

    private BusinessExceptionCode code;
    private Exception exception;

    public BusinessException(BusinessExceptionCode code)
    {
        super(code.description);
        this.code = code;
    }

    public BusinessException(BusinessExceptionCode code, Exception exception)
    {
        super(code.description);
        this.code = code;
        this.exception = exception;
    }

    public BusinessExceptionCode getCode()
    {
        return code;
    }

    public void setCode(BusinessExceptionCode code)
    {
        this.code = code;
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
        final StringBuilder sb = new StringBuilder("BusinessException{");
        sb.append("code=").append(code);
        sb.append(", exception=").append(exception);
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