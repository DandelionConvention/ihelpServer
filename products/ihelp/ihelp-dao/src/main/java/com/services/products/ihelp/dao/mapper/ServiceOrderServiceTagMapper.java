package com.services.products.ihelp.dao.mapper;

import com.services.products.ihelp.dao.domain.ServiceOrderServiceTag;
import com.services.products.ihelp.dao.domain.ServiceOrderServiceTagExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServiceOrderServiceTagMapper {
    long countByExample(ServiceOrderServiceTagExample example);

    int deleteByExample(ServiceOrderServiceTagExample example);

    int deleteByPrimaryKey(@Param("serviceOrderId") Long serviceOrderId, @Param("serviceTagId") Integer serviceTagId);

    int insert(ServiceOrderServiceTag record);

    int insertSelective(ServiceOrderServiceTag record);

    List<ServiceOrderServiceTag> selectByExample(ServiceOrderServiceTagExample example);

    ServiceOrderServiceTag selectByPrimaryKey(@Param("serviceOrderId") Long serviceOrderId, @Param("serviceTagId") Integer serviceTagId);

    int updateByExampleSelective(@Param("record") ServiceOrderServiceTag record, @Param("example") ServiceOrderServiceTagExample example);

    int updateByExample(@Param("record") ServiceOrderServiceTag record, @Param("example") ServiceOrderServiceTagExample example);

    int updateByPrimaryKeySelective(ServiceOrderServiceTag record);

    int updateByPrimaryKey(ServiceOrderServiceTag record);
}