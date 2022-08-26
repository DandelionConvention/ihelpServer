package com.services.products.ihelp.dao.mapper;

import com.services.products.ihelp.dao.domain.CertificationRecord;
import com.services.products.ihelp.dao.domain.CertificationRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CertificationRecordMapper {
    long countByExample(CertificationRecordExample example);

    int deleteByExample(CertificationRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CertificationRecord record);

    int insertSelective(CertificationRecord record);

    List<CertificationRecord> selectByExample(CertificationRecordExample example);

    CertificationRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CertificationRecord record, @Param("example") CertificationRecordExample example);

    int updateByExample(@Param("record") CertificationRecord record, @Param("example") CertificationRecordExample example);

    int updateByPrimaryKeySelective(CertificationRecord record);

    int updateByPrimaryKey(CertificationRecord record);
}