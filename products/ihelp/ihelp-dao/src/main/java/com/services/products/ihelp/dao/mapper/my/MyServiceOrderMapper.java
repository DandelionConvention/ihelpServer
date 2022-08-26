package com.services.products.ihelp.dao.mapper.my;

import com.services.products.ihelp.dao.bo.HisServiceBO;
import com.services.products.ihelp.dao.bo.ListServicesBO;
import com.services.products.ihelp.dao.domain.ServiceOrder;
import com.services.products.ihelp.dao.dto.ListServiceOrdersDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MyServiceOrderMapper
{
    void commitCountIncrement(@Param("orderId") Long orderId);

    void updateServiceOrderStatusByOrderId(@Param("orderId") Long orderId, @Param("statusNum") Byte statusNum);

    List<ServiceOrder> selectServiceOrderByClientId(@Param("clientId") Long clientId);

    List<ServiceOrder> selectServiceOrderByClientIdAndStatus(@Param("clientId") Long clientId, @Param("status") Byte status);

    List<ServiceOrder> selectServiceOrderByServiceApplicationServantId(@Param("servantId") Long servantId);

    List<ServiceOrder> selectServiceOrderByServiceApplicationServantIdAndStatus(@Param("servantId") Long servantId, @Param("status") Byte status);

    Object serviceOrderExistedByOrderIdAndUserId(@Param("orderId") Long orderId, @Param("userId") Long userId);

    List<HisServiceBO> getHisServices(@Param("clientId") Long clientId, @Param("servantId") Long servantId);

    Integer countRecruiting(@Param("id") Long id);

    List<ListServicesBO> listServices(@Param("condition") ListServiceOrdersDTO condition);
}
