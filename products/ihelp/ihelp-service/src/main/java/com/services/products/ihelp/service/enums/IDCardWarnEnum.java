package com.services.products.ihelp.service.enums;

import com.services.products.ihelp.service.exception.BusinessExceptionCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * 身份证告警
 */
public enum IDCardWarnEnum
{
    ID_CARD_EXPIRATION_DATE_ILLEGAL(-9100, BusinessExceptionCode.ID_CARD_EXPIRATION_DATE_ILLEGAL),
    ID_CARD_BORDER_CHECK_WARN(-9101, BusinessExceptionCode.ID_CARD_BORDER_CHECK_WARN),
    COPY_OF_ID_CARD(-9102, BusinessExceptionCode.COPY_OF_ID_CARD),
    ID_CARD_REMAKE(-9103, BusinessExceptionCode.ID_CARD_REMAKE),
    BLOCKING_IN_THE_ID_CARD_FRAME(-9105, BusinessExceptionCode.BLOCKING_IN_THE_ID_CARD_FRAME),
    TEMPORARY_ID_CARD(-9104, BusinessExceptionCode.TEMPORARY_ID_CARD),
    ID_CARD_PS(-9106, BusinessExceptionCode.ID_CARD_PS)
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
