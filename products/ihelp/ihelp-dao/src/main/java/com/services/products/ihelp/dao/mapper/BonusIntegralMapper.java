package com.services.products.ihelp.dao.mapper;

import com.services.products.ihelp.dao.domain.BonusIntegral;
import com.services.products.ihelp.dao.domain.BonusIntegralExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BonusIntegralMapper {
    long countByExample(BonusIntegralExample example);

    int deleteByExample(BonusIntegralExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BonusIntegral record);

    int insertSelective(BonusIntegral record);

    List<BonusIntegral> selectByExample(BonusIntegralExample example);

    BonusIntegral selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BonusIntegral record, @Param("example") BonusIntegralExample example);

    int updateByExample(@Param("record") BonusIntegral record, @Param("example") BonusIntegralExample example);

    int updateByPrimaryKeySelective(BonusIntegral record);

    int updateByPrimaryKey(BonusIntegral record);
}