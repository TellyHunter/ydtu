package com.mapper;

import com.bean.Charge;
import com.bean.ChargeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChargeMapper {
    int countByExample(ChargeExample example);

    int deleteByExample(ChargeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Charge record);

    int insertSelective(Charge record);

    List<Charge> selectByExample(ChargeExample example);

    Charge selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Charge record, @Param("example") ChargeExample example);

    int updateByExample(@Param("record") Charge record, @Param("example") ChargeExample example);

    int updateByPrimaryKeySelective(Charge record);

    int updateByPrimaryKey(Charge record);
}