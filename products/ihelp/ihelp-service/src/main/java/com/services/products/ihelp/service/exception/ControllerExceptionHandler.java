package com.services.products.ihelp.service.exception;

import com.netflix.client.ClientException;
import com.services.core.exception.ErrorException;
import com.services.core.exception.ResponseException;
import com.services.core.vo.ResponseVO;
import feign.RetryableException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

/**
 * 请求异常处理
 */
@RestControllerAdvice
public class ControllerExceptionHandler
{

    private static final Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseVO bindExceptionValidatorHandler(BindException e)
    {
        ResponseVO responseVO = BusinessExceptionCode.BAD_REQUEST.response();
        FieldError fieldError = e.getBindingResult().getFieldError();
        if (fieldError != null)
        {
            String message = fieldError.getDefaultMessage();
            logger.warn("╭( ′• o •′ )╭☞ 请求参数校验未通过: {}", fieldError.getDefaultMessage());
            String detail = message + " -> " + e.toString();
            responseVO.setDetail(detail);
        }
        return responseVO;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseVO constraintViolationExceptionValidatorHandler(ConstraintViolationException e)
    {
        ResponseVO responseVO = BusinessExceptionCode.BAD_REQUEST.response();
        String message = e.getConstraintViolations().iterator().next().getMessage();
        logger.warn("╭( ′• o •′ )╭☞ 请求参数校验未通过: {}", message);
        String detail = message + " -> " + e.toString();
        responseVO.setDetail(detail);
        return responseVO;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseVO methodArgumentNotValidExceptionValidatorHandler(MethodArgumentNotValidException e)
    {
        ResponseVO responseVO = BusinessExceptionCode.BAD_REQUEST.response();
        FieldError fieldError = e.getBindingResult().getFieldError();
        if (fieldError != null)
        {
            String message = fieldError.getDefaultMessage();
            logger.warn("╭( ′• o •′ )╭☞ 请求参数校验未通过: {}", message);
            String detail = message + " -> " + e.toString();
            responseVO.setDetail(detail);
        }
        return responseVO;
    }

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
     * 响应异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = ResponseException.class)
    public ResponseVO responseExceptionHandler(ResponseException e)
    {
        ResponseVO responseVO = e.getResponseVO();
        logger.error("╭( ′• o •′ )╭☞ {} -> {}", e.getMessage(), responseVO.getDetail(), responseVO.getException());
        responseVO.setException(null);
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

    @ExceptionHandler(value = RetryableException.class)
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public ResponseVO retryableExceptionHandler(RetryableException e)
    {
        logger.error("╭( ′• o •′ )╭☞ {}", e.getMessage(), e);
        return BusinessExceptionCode.SERVER_BUSY.response(e.getMessage());
    }

    /**
     * 其他异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler({ClientException.class, Exception.class})
    public ResponseEntity exceptionHandler(ClientException clientException, Exception e)
    {
        if (clientException != null)
        {
            logger.error("╭( ′• o •′ )╭☞ {}", clientException.getMessage(), clientException);
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                    .body(BusinessExceptionCode.SERVICE_UNAVAILABLE.response(e.getMessage()));
        }
        logger.error("╭( ′• o •′ )╭☞ {}", e.getMessage(), e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(BusinessExceptionCode.SERVER_ERROR.response(e.getMessage()));
    }
}
