package com.services.products.ihelp.dao.mapper;

import com.services.products.ihelp.dao.domain.ServiceCancelReason;
import com.services.products.ihelp.dao.domain.ServiceCancelReasonExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServiceCancelReasonMapper {
    long countByExample(ServiceCancelReasonExample example);

    int deleteByExample(ServiceCancelReasonExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ServiceCancelReason record);

    int insertSelective(ServiceCancelReason record);

    List<ServiceCancelReason> selectByExample(ServiceCancelReasonExample example);

    ServiceCancelReason selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ServiceCancelReason record, @Param("example") ServiceCancelReasonExample example);

    int updateByExample(@Param("record") ServiceCancelReason record, @Param("example") ServiceCancelReasonExample example);

    int updateByPrimaryKeySelective(ServiceCancelReason record);

    int updateByPrimaryKey(ServiceCancelReason record);
}