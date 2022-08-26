package com.services.products.ihelp.dao.mapper;

import com.services.products.ihelp.dao.domain.ServiceCancelApplication;
import com.services.products.ihelp.dao.domain.ServiceCancelApplicationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServiceCancelApplicationMapper {
    long countByExample(ServiceCancelApplicationExample example);

    int deleteByExample(ServiceCancelApplicationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ServiceCancelApplication record);

    int insertSelective(ServiceCancelApplication record);

    List<ServiceCancelApplication> selectByExample(ServiceCancelApplicationExample example);

    ServiceCancelApplication selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ServiceCancelApplication record, @Param("example") ServiceCancelApplicationExample example);

    int updateByExample(@Param("record") ServiceCancelApplication record, @Param("example") ServiceCancelApplicationExample example);

    int updateByPrimaryKeySelective(ServiceCancelApplication record);

    int updateByPrimaryKey(ServiceCancelApplication record);
}