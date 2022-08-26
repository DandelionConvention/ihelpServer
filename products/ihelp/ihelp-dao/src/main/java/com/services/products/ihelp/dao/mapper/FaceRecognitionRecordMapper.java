package com.services.products.ihelp.dao.mapper;

import com.services.products.ihelp.dao.domain.FaceRecognitionRecord;
import com.services.products.ihelp.dao.domain.FaceRecognitionRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FaceRecognitionRecordMapper {
    long countByExample(FaceRecognitionRecordExample example);

    int deleteByExample(FaceRecognitionRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FaceRecognitionRecord record);

    int insertSelective(FaceRecognitionRecord record);

    List<FaceRecognitionRecord> selectByExample(FaceRecognitionRecordExample example);

    FaceRecognitionRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FaceRecognitionRecord record, @Param("example") FaceRecognitionRecordExample example);

    int updateByExample(@Param("record") FaceRecognitionRecord record, @Param("example") FaceRecognitionRecordExample example);

    int updateByPrimaryKeySelective(FaceRecognitionRecord record);

    int updateByPrimaryKey(FaceRecognitionRecord record);
}