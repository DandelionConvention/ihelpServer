package com.services.core.exception;


/**
 * 返回异常
 */
public class ErrorException extends RuntimeException
{
    private Exception exception;

    public Exception getException()
    {
        return exception;
    }

    public void setException(Exception exception)
    {
        this.exception = exception;
    }

    public ErrorException(Exception exception)
    {
        super(exception.getMessage());
        this.exception = exception;
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