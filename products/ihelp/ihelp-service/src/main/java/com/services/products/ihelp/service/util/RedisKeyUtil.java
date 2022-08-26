package com.services.products.ihelp.service.util;

public class RedisKeyUtil
{
    public static Long getUserId(String session) {
        return Long.parseLong(session.split(":")[2]);
    }
}
