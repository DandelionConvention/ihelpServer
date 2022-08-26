package com.services.products.ihelp.service.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户类型
 */
public enum UserTypeEnum
{
    VISITOR(0, "游客"),
    SERVANT(1, "服务者"),
    CLIENT(2, "老人");

    /**
     * 老人标准年龄
     */
    public final static Integer OLD_AGE = 60;
    public final Integer num;
    public final String description;
    public static final int LENGTH = UserTypeEnum.values().length;
    public static final Map<Integer, String> NUM_NAME = new HashMap<>(LENGTH);

    static
    {
        for (UserTypeEnum e : UserTypeEnum.values())
        {
            NUM_NAME.put(e.num, e.name());
        }
    }

    public static Integer getNumByAge(int age)
    {
        return age >= OLD_AGE ? UserTypeEnum.CLIENT.num : UserTypeEnum.SERVANT.num;
    }

    public static String getNameByNum(Integer num)
    {
        return NUM_NAME.get(num);
    }

    UserTypeEnum(Integer num, String description)
    {
        this.num = num;
        this.description = description;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("UserTypeEnum{");
        sb.append("num=").append(num);
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
