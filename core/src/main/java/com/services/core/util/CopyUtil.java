package com.services.core.util;

import com.services.core.exception.ErrorException;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * bean复制工具
 */
public class CopyUtil
{

    public static <T> T copy(Object source, Class<T> clazz)
    {
        if (source == null)
        {
            return null;
        }
        T obj;
        try
        {
            obj = clazz.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e)
        {
            throw new ErrorException(e);
        }
        BeanUtils.copyProperties(source, obj);
        return obj;
    }

    public static <T> List<T> copyList(List source, Class<T> clazz)
    {
        List<T> target = new ArrayList<>();
        if (!CollectionUtils.isEmpty(source))
        {
            for (Object c : source)
            {
                T obj = copy(c, clazz);
                target.add(obj);
            }
        }
        return target;
    }
}
