package com.services.products.ihelp.service.enums;

/**
 * redisKey类型
 */
public enum RedisKeyEnum
{
    SESSION("session:user:"),
    READING_COUNT("readingCount:")
    ;

    public final String prefix;

    RedisKeyEnum(String prefix)
    {
        this.prefix = prefix;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("RedisKeyEnum{");
        sb.append("prefix='").append(prefix).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
