package com.services.products.ihelp.service.enums;

/**
 * 用户状态
 */
public enum UserStatusEnum
{
    NOT_CERTIFIED(0, "未认证"),
    CERTIFIED(1, "已认证"),
    EXPIRED(2, "认证已到期"),
    CANCELLATION(3, "已注销")
    ;

    public final Integer num;
    public final String description;

    UserStatusEnum(Integer num, String description)
    {
        this.num = num;
        this.description = description;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("UserStatusEnum{");
        sb.append("num=").append(num);
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
