package com.services.products.ihelp.dao.mapper;

import com.services.products.ihelp.dao.domain.RechargeDenomination;
import com.services.products.ihelp.dao.domain.RechargeDenominationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RechargeDenominationMapper {
    long countByExample(RechargeDenominationExample example);

    int deleteByExample(RechargeDenominationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RechargeDenomination record);

    int insertSelective(RechargeDenomination record);

    List<RechargeDenomination> selectByExample(RechargeDenominationExample example);

    RechargeDenomination selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RechargeDenomination record, @Param("example") RechargeDenominationExample example);

    int updateByExample(@Param("record") RechargeDenomination record, @Param("example") RechargeDenominationExample example);

    int updateByPrimaryKeySelective(RechargeDenomination record);

    int updateByPrimaryKey(RechargeDenomination record);
}