package com.mapper;

import com.bean.TParkInOut;
import com.bean.TParkInOutExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TParkInOutMapper {
    int countByExample(TParkInOutExample example);

    int deleteByExample(TParkInOutExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TParkInOut record);

    int insertSelective(TParkInOut record);

    List<TParkInOut> selectByExample(TParkInOutExample example);

    TParkInOut selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TParkInOut record, @Param("example") TParkInOutExample example);

    int updateByExample(@Param("record") TParkInOut record, @Param("example") TParkInOutExample example);

    int updateByPrimaryKeySelective(TParkInOut record);

    int updateByPrimaryKey(TParkInOut record);
}