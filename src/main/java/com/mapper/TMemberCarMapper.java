package com.mapper;

import com.bean.TMemberCar;
import com.bean.TMemberCarExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TMemberCarMapper {
    int countByExample(TMemberCarExample example);

    int deleteByExample(TMemberCarExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TMemberCar record);

    int insertSelective(TMemberCar record);

    List<TMemberCar> selectByExample(TMemberCarExample example);

    TMemberCar selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TMemberCar record, @Param("example") TMemberCarExample example);

    int updateByExample(@Param("record") TMemberCar record, @Param("example") TMemberCarExample example);

    int updateByPrimaryKeySelective(TMemberCar record);

    int updateByPrimaryKey(TMemberCar record);
}