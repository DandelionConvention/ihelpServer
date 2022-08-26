package com.services.products.ihelp.dao.mapper;

import com.services.products.ihelp.dao.domain.InterestRate;
import com.services.products.ihelp.dao.domain.InterestRateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InterestRateMapper {
    long countByExample(InterestRateExample example);

    int deleteByExample(InterestRateExample example);

    int deleteByPrimaryKey(Byte id);

    int insert(InterestRate record);

    int insertSelective(InterestRate record);

    List<InterestRate> selectByExample(InterestRateExample example);

    InterestRate selectByPrimaryKey(Byte id);

    int updateByExampleSelective(@Param("record") InterestRate record, @Param("example") InterestRateExample example);

    int updateByExample(@Param("record") InterestRate record, @Param("example") InterestRateExample example);

    int updateByPrimaryKeySelective(InterestRate record);

    int updateByPrimaryKey(InterestRate record);
}