package com.services.products.ihelp.service.enums;

/**
 * 订单流水类型
 */
public enum OrderRecordTypeEnum
{
    RECHARGE(0, "充值"),
    COST(1, "服务花费"),
    REWARD(2, "服务获取"),
    TRANSFER(3, "转账"),
    RECEIVE(4, "收到转账"),
    REFUND(5, "服务积分退还"),
    OTHER(6, "其它");

    public final Integer num;
    public final String description;

    OrderRecordTypeEnum(Integer num, String description)
    {
        this.num = num;
        this.description = description;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("OrderRecordTypeEnum{");
        sb.append("num=").append(num);
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
