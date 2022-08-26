package com.services.products.ihelp.dao.mapper.my;

import org.apache.ibatis.annotations.Param;

public interface MyServiceOrderCollectMapper
{
    Object isOrderCollectedByUser(@Param("orderId") Long orderId, @Param("userId") Long userId);
}
