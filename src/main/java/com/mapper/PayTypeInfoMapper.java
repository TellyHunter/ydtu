package com.mapper;

import com.bean.PayTypeInfo;
import com.bean.PayTypeInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PayTypeInfoMapper {
    int countByExample(PayTypeInfoExample example);

    int deleteByExample(PayTypeInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PayTypeInfo record);

    int insertSelective(PayTypeInfo record);

    List<PayTypeInfo> selectByExample(PayTypeInfoExample example);

    PayTypeInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PayTypeInfo record, @Param("example") PayTypeInfoExample example);

    int updateByExample(@Param("record") PayTypeInfo record, @Param("example") PayTypeInfoExample example);

    int updateByPrimaryKeySelective(PayTypeInfo record);

    int updateByPrimaryKey(PayTypeInfo record);
}