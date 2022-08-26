package com.services.products.ihelp.dao.mapper;

import com.services.products.ihelp.dao.domain.ServiceApplication;
import com.services.products.ihelp.dao.domain.ServiceApplicationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServiceApplicationMapper {
    long countByExample(ServiceApplicationExample example);

    int deleteByExample(ServiceApplicationExample example);

    int deleteByPrimaryKey(@Param("serviceOrderId") Long serviceOrderId, @Param("servantId") Long servantId);

    int insert(ServiceApplication record);

    int insertSelective(ServiceApplication record);

    List<ServiceApplication> selectByExample(ServiceApplicationExample example);

    ServiceApplication selectByPrimaryKey(@Param("serviceOrderId") Long serviceOrderId, @Param("servantId") Long servantId);

    int updateByExampleSelective(@Param("record") ServiceApplication record, @Param("example") ServiceApplicationExample example);

    int updateByExample(@Param("record") ServiceApplication record, @Param("example") ServiceApplicationExample example);

    int updateByPrimaryKeySelective(ServiceApplication record);

    int updateByPrimaryKey(ServiceApplication record);
}