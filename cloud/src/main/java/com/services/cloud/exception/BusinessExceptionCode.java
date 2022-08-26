package com.services.cloud.exception;

import com.services.core.vo.ResponseVO;

/**
 * 业务码
 */
public enum BusinessExceptionCode
{
    /**
     * 服务器内部错误
     */
    SERVER_ERROR("B0500", "系统执行出错"),
    ID_CARD_OCR_ERROR("C0201", "身份证识别出错"),
    COMPARE_FACE_ERROR("C0202", "人脸比对出错"),
    ID_CARD_BORDER_CHECK_WARN("A0201", "身份证边框不完整"),
    IMAGE_BLUR("A0202", "图像模糊"),
    ID_CARD_EXPIRATION_DATE_ILLEGAL("A0205", "身份证有效日期不合法"),
    COPY_OF_ID_CARD("A0206", "身份证复印件告警"),
    ID_CARD_REMAKE("A0207", "身份证翻拍告警"),
    BLOCKING_IN_THE_ID_CARD_FRAME("A0208", "身份证框内遮挡告警"),
    TEMPORARY_ID_CARD("A0209", "临时身份证告警"),
    ID_CARD_PS("A0210", "身份证PS告警"),
    FACE_MISMATCH("A0211", "人脸不匹配"),
    ID_CARD_REFLECTION("A0212", "身份证反光告警"),
    WX_ERROR("C1000", "微信调用出错"),
    ;

    public final String code;
    public final String description;

    public void throwException()
    {
        throw new BusinessException(this);
    }

    public BusinessException exception()
    {
        return new BusinessException(this);
    }

    public BusinessException exception(Exception e)
    {
        return new BusinessException(this, e);
    }

    public BusinessException businessException()
    {
        return new BusinessException(this);
    }

    public ResponseVO response()
    {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setStatus(code);
        responseVO.setMessage(description);
        return responseVO;
    }

    public ResponseVO response(String detail)
    {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setStatus(code);
        responseVO.setMessage(description);
        responseVO.setDetail(detail);
        return responseVO;
    }

    BusinessExceptionCode(String code, String description)
    {
        this.code = code;
        this.description = description;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("BusinessExceptionCode{");
        sb.append("code='").append(code).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
