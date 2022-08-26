package com.services.products.ihelp.dao.mapper;

import com.services.products.ihelp.dao.domain.ServiceOrderCollect;
import com.services.products.ihelp.dao.domain.ServiceOrderCollectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServiceOrderCollectMapper {
    long countByExample(ServiceOrderCollectExample example);

    int deleteByExample(ServiceOrderCollectExample example);

    int deleteByPrimaryKey(@Param("serviceOrderId") Long serviceOrderId, @Param("userId") Long userId);

    int insert(ServiceOrderCollect record);

    int insertSelective(ServiceOrderCollect record);

    List<ServiceOrderCollect> selectByExample(ServiceOrderCollectExample example);

    ServiceOrderCollect selectByPrimaryKey(@Param("serviceOrderId") Long serviceOrderId, @Param("userId") Long userId);

    int updateByExampleSelective(@Param("record") ServiceOrderCollect record, @Param("example") ServiceOrderCollectExample example);

    int updateByExample(@Param("record") ServiceOrderCollect record, @Param("example") ServiceOrderCollectExample example);

    int updateByPrimaryKeySelective(ServiceOrderCollect record);

    int updateByPrimaryKey(ServiceOrderCollect record);
}