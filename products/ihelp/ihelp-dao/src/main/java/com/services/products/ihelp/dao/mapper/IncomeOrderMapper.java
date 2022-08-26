package com.services.products.ihelp.dao.mapper;

import com.services.products.ihelp.dao.domain.IncomeOrder;
import com.services.products.ihelp.dao.domain.IncomeOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IncomeOrderMapper {
    long countByExample(IncomeOrderExample example);

    int deleteByExample(IncomeOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(IncomeOrder record);

    int insertSelective(IncomeOrder record);

    List<IncomeOrder> selectByExample(IncomeOrderExample example);

    IncomeOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") IncomeOrder record, @Param("example") IncomeOrderExample example);

    int updateByExample(@Param("record") IncomeOrder record, @Param("example") IncomeOrderExample example);

    int updateByPrimaryKeySelective(IncomeOrder record);

    int updateByPrimaryKey(IncomeOrder record);
}