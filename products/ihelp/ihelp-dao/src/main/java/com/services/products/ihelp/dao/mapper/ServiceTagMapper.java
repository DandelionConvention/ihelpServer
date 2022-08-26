package com.services.products.ihelp.dao.mapper;

import com.services.products.ihelp.dao.domain.ServiceTag;
import com.services.products.ihelp.dao.domain.ServiceTagExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServiceTagMapper {
    long countByExample(ServiceTagExample example);

    int deleteByExample(ServiceTagExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ServiceTag record);

    int insertSelective(ServiceTag record);

    List<ServiceTag> selectByExample(ServiceTagExample example);

    ServiceTag selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ServiceTag record, @Param("example") ServiceTagExample example);

    int updateByExample(@Param("record") ServiceTag record, @Param("example") ServiceTagExample example);

    int updateByPrimaryKeySelective(ServiceTag record);

    int updateByPrimaryKey(ServiceTag record);
}