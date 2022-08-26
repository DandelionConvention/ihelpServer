package com.services.products.ihelp.dao.mapper;

import com.services.products.ihelp.dao.domain.ServiceOrder;
import com.services.products.ihelp.dao.domain.ServiceOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServiceOrderMapper {
    long countByExample(ServiceOrderExample example);

    int deleteByExample(ServiceOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ServiceOrder record);

    int insertSelective(ServiceOrder record);

    List<ServiceOrder> selectByExample(ServiceOrderExample example);

    ServiceOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ServiceOrder record, @Param("example") ServiceOrderExample example);

    int updateByExample(@Param("record") ServiceOrder record, @Param("example") ServiceOrderExample example);

    int updateByPrimaryKeySelective(ServiceOrder record);

    int updateByPrimaryKey(ServiceOrder record);
}