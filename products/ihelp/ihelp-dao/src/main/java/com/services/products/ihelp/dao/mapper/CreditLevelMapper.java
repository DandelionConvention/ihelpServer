package com.services.products.ihelp.dao.mapper;

import com.services.products.ihelp.dao.domain.CreditLevel;
import com.services.products.ihelp.dao.domain.CreditLevelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CreditLevelMapper {
    long countByExample(CreditLevelExample example);

    int deleteByExample(CreditLevelExample example);

    int deleteByPrimaryKey(Byte id);

    int insert(CreditLevel record);

    int insertSelective(CreditLevel record);

    List<CreditLevel> selectByExample(CreditLevelExample example);

    CreditLevel selectByPrimaryKey(Byte id);

    int updateByExampleSelective(@Param("record") CreditLevel record, @Param("example") CreditLevelExample example);

    int updateByExample(@Param("record") CreditLevel record, @Param("example") CreditLevelExample example);

    int updateByPrimaryKeySelective(CreditLevel record);

    int updateByPrimaryKey(CreditLevel record);
}