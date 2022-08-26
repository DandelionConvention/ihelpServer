package com.services.products.ihelp.service.exception;

import com.services.core.vo.ResponseVO;

/**
 * 业务码
 */
public enum BusinessExceptionCode
{

    SERVER_BUSY("B0502", "系统繁忙"),
    SERVICE_UNAVAILABLE("B0503", "服务暂不可用"),
    BAD_REQUEST("A0400", "请求参数错误"),
    NAME_EXISTED("A0111", "名称已存在"),
    WX_ERROR("C1000", "微信调用出错"),
    SERVER_ERROR("B0500", "系统执行出错"),
    FORBIDDEN("A0403", "Forbidden"),
    INSUFFICIENT_BALANCE("A0002", "余额不足"),
    ID_CARD_OCR_ERROR("C0201", "身份证识别出错"),
    COMPARE_FACE_ERROR("C0202", "人脸比对出错"),
    ID_CARD_BORDER_CHECK_WARN("A0201", "身份证边框不完整"),
    IMAGE_BLUR("A0202", "图像模糊"),
    NAME_NOT_MATCH("A0203", "姓名不匹配"),
    ID_NUM_NOT_MATCH("A0204", "证件号码不匹配"),
    ID_CARD_EXPIRATION_DATE_ILLEGAL("A0205", "身份证有效日期不合法"),
    COPY_OF_ID_CARD("A0206", "身份证复印件告警"),
    ID_CARD_REMAKE("A0207", "身份证翻拍告警"),
    BLOCKING_IN_THE_ID_CARD_FRAME("A0208", "身份证框内遮挡告警"),
    TEMPORARY_ID_CARD("A0209", "临时身份证告警"),
    ID_CARD_PS("A0210", "身份证PS告警"),
    FACE_MISMATCH("A0211", "人脸不匹配"),
    ID_CARD_EXPIRED("A02012", "身份证已过期")
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
