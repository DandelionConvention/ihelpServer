package com.services.products.ihelp.dao.mapper.my;
import org.apache.ibatis.annotations.Param;

public interface MyServiceCancelReasonMapper
{
    Object nameExisted(@Param("name") String name, @Param("id") Integer id);
}
