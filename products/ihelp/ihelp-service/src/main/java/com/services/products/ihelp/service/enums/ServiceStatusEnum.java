package com.services.products.ihelp.service.enums;

import com.google.common.base.Enums;
import com.services.products.ihelp.service.exception.BusinessExceptionCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 服务状态
 */
public enum ServiceStatusEnum
{
    CREATED(1, "待审核"),
    PROCESSING(2, "待完成"),
    EVALUATING(3, "待评价"),
    TIMEOUT(4, "已超时"),
    REJECTED(5, "被拒绝"),
    WITHDRAWING(6, "撤销中"),
    CANCELED(7, "已取消"),
    ILLEGAL(8, "违规"),
    FINISHED(9, "交易完成");

    public final Integer num;
    public final String description;
    public static final int LENGTH = ServiceStatusEnum.values().length;
    public static final Map<Integer, String> NUM_NAME = new HashMap<>(LENGTH);

    static
    {
        for (ServiceStatusEnum e : ServiceStatusEnum.values())
        {
            NUM_NAME.put(e.num, e.name());
        }
    }

    public static Integer getNumByName(String name)
    {
        return Enums.getIfPresent(ServiceStatusEnum.class, name).toJavaUtil()
                .orElseThrow(BusinessExceptionCode.BAD_REQUEST::businessException).num;
    }

    public static String getNameByNum(Integer num)
    {
        return NUM_NAME.get(num);
    }

    ServiceStatusEnum(Integer num, String description)
    {
        this.num = num;
        this.description = description;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("ServiceStatusEnum{");
        sb.append("num=").append(num);
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
