package com.services.products.ihelp.dao.mapper.my;

import org.apache.ibatis.annotations.Param;

public interface MyServiceApplicationMapper
{
    void updateServiceApplicationStatusByOrderIdAndServiceStatusNum(@Param("orderId") Long orderId,
                                                                    @Param("previousServiceStatusNum") Byte previousServiceStatusNum,
                                                                    @Param("afterServiceStatusNum") Byte afterServiceStatusNum);
}
