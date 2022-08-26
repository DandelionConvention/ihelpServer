package com.services.cloud.enums;


import com.services.cloud.exception.BusinessExceptionCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * 身份证告警
 */
public enum IDCardWarnEnum
{
    /**
     * 身份证有效日期不合法告警
     */
    ID_CARD_EXPIRATION_DATE_ILLEGAL(-9100, BusinessExceptionCode.ID_CARD_EXPIRATION_DATE_ILLEGAL),
    /**
     * 身份证边框不完整告警
     */
    ID_CARD_BORDER_CHECK_WARN(-9101, BusinessExceptionCode.ID_CARD_BORDER_CHECK_WARN),
    /**
     * 身份证复印件告警
     */
    COPY_OF_ID_CARD(-9102, BusinessExceptionCode.COPY_OF_ID_CARD),
    /**
     * 身份证翻拍告警
     */
    ID_CARD_REMAKE(-9103, BusinessExceptionCode.ID_CARD_REMAKE),
    /**
     * 身份证框内遮挡告警
     */
    BLOCKING_IN_THE_ID_CARD_FRAME(-9105, BusinessExceptionCode.BLOCKING_IN_THE_ID_CARD_FRAME),
    /**
     * 临时身份证告警
     */
    TEMPORARY_ID_CARD(-9104, BusinessExceptionCode.TEMPORARY_ID_CARD),
    /**
     * 临时身份证告警
     */
    ID_CARD_PS(-9106, BusinessExceptionCode.ID_CARD_PS),
    /**
     * 身份证反光告警
     */
    ID_CARD_REFLECTION(-9107, BusinessExceptionCode.ID_CARD_REFLECTION),
    ;

    public final Integer num;
    public final BusinessExceptionCode code;
    public static final int LENGTH = IDCardWarnEnum.values().length;
    public static final Map<Integer, BusinessExceptionCode> NUM_CODE = new HashMap<>(LENGTH);

    static
    {
        for (IDCardWarnEnum e : IDCardWarnEnum.values())
        {
            NUM_CODE.put(e.num, e.code);
        }
    }

    public static void check(Integer num)
    {
        Optional.ofNullable(NUM_CODE.get(num)).ifPresent(BusinessExceptionCode::throwException);
    }

    IDCardWarnEnum(Integer num, BusinessExceptionCode code)
    {
        this.num = num;
        this.code = code;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("IDCardWarnEnum{");
        sb.append("num=").append(num);
        sb.append(", code=").append(code);
        sb.append('}');
        return sb.toString();
    }
}
