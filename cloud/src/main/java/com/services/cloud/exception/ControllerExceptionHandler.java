package com.services.cloud.exception;

import com.services.core.exception.ErrorException;
import com.services.core.vo.ResponseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 请求异常处理
 */
@RestControllerAdvice
public class ControllerExceptionHandler
{

    private static final Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    /**
     * 业务异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = BusinessException.class)
    public ResponseVO businessExceptionHandler(BusinessException e)
    {
        BusinessExceptionCode businessExceptionCode = e.getCode();
        ResponseVO responseVO = businessExceptionCode.response();
        Exception exception = e.getException();
        if (exception != null)
        {
            responseVO.setException(exception);
            String detail = exception.getMessage() + " -> " + exception.toString();
            responseVO.setDetail(detail);
        }
        logger.error("╭( ′• o •′ )╭☞ {}", e.getMessage(), exception);
        return responseVO;
    }

    /**
     * 通用错误处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = ErrorException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseVO errorExceptionHandler(ErrorException e)
    {
        logger.error("╭( ′• o •′ )╭☞ {}", e.getMessage(), e.getException());
        String detail = e.getMessage() + " -> " + e.toString();
        return BusinessExceptionCode.SERVER_ERROR.response(detail);
    }

    /**
     * 其他异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseVO exceptionHandler(Exception e)
    {
        logger.error("╭( ′• o •′ )╭☞ {}", e.getMessage(), e);
        String detail = e.getMessage() + " -> " + e.toString();
        return BusinessExceptionCode.SERVER_ERROR.response(detail);
    }
}
