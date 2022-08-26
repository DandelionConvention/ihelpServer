package com.services.products.ihelp.dao.mapper;

import com.services.products.ihelp.dao.domain.RechargeOrder;
import com.services.products.ihelp.dao.domain.RechargeOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RechargeOrderMapper {
    long countByExample(RechargeOrderExample example);

    int deleteByExample(RechargeOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RechargeOrder record);

    int insertSelective(RechargeOrder record);

    List<RechargeOrder> selectByExample(RechargeOrderExample example);

    RechargeOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RechargeOrder record, @Param("example") RechargeOrderExample example);

    int updateByExample(@Param("record") RechargeOrder record, @Param("example") RechargeOrderExample example);

    int updateByPrimaryKeySelective(RechargeOrder record);

    int updateByPrimaryKey(RechargeOrder record);
}