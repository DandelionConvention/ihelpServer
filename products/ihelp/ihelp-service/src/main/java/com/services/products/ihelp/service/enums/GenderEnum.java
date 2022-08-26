package com.services.products.ihelp.service.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 性别
 */
public enum GenderEnum
{
    OTHER(0, "其他"),
    MALE(1, "男"),
    FEMALE(2, "女")
    ;

    public final Integer num;
    public final String description;
    public static final int LENGTH = GenderEnum.values().length;
    public static final Map<Integer, String> NUM_NAME = new HashMap<>(LENGTH);
    public static final Map<String, Integer> DESCRIPTION_NUM = new HashMap<>(LENGTH);

    static
    {
        for (GenderEnum e : GenderEnum.values())
        {
            NUM_NAME.put(e.num, e.name());
            DESCRIPTION_NUM.put(e.description, e.num);
        }
    }

    public static String getNameByNum(Integer num)
    {
        return NUM_NAME.get(num);
    }

    public static Integer getNumByDescription(String description)
    {
        return DESCRIPTION_NUM.get(description);
    }

    GenderEnum(Integer num, String description)
    {
        this.num = num;
        this.description = description;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("GenderEnum{");
        sb.append("num=").append(num);
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
