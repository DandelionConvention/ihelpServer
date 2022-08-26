package com.services.products.ihelp.dao.mapper;

import com.services.products.ihelp.dao.domain.TransferOrder;
import com.services.products.ihelp.dao.domain.TransferOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TransferOrderMapper {
    long countByExample(TransferOrderExample example);

    int deleteByExample(TransferOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TransferOrder record);

    int insertSelective(TransferOrder record);

    List<TransferOrder> selectByExample(TransferOrderExample example);

    TransferOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TransferOrder record, @Param("example") TransferOrderExample example);

    int updateByExample(@Param("record") TransferOrder record, @Param("example") TransferOrderExample example);

    int updateByPrimaryKeySelective(TransferOrder record);

    int updateByPrimaryKey(TransferOrder record);
}