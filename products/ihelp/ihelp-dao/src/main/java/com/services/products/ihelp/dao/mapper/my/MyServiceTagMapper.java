package com.services.products.ihelp.dao.mapper.my;

import com.services.products.ihelp.dao.domain.ServiceTag;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MyServiceTagMapper
{
    List<ServiceTag> list();
    List<ServiceTag> selectServiceTagListByOrderId(@Param("orderId") Long orderId);
    Object nameExisted(@Param("name") String name);
}
