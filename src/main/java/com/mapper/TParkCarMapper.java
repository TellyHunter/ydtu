package com.mapper;

import com.bean.TParkCar;
import com.bean.TParkCarExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TParkCarMapper {
    int countByExample(TParkCarExample example);

    int deleteByExample(TParkCarExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TParkCar record);

    int insertSelective(TParkCar record);

    List<TParkCar> selectByExample(TParkCarExample example);

    TParkCar selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TParkCar record, @Param("example") TParkCarExample example);

    int updateByExample(@Param("record") TParkCar record, @Param("example") TParkCarExample example);

    int updateByPrimaryKeySelective(TParkCar record);

    int updateByPrimaryKey(TParkCar record);
}