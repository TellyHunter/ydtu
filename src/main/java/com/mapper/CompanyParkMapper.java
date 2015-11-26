package com.mapper;

import com.bean.CompanyPark;
import com.bean.CompanyParkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CompanyParkMapper {
    int countByExample(CompanyParkExample example);

    int deleteByExample(CompanyParkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CompanyPark record);

    int insertSelective(CompanyPark record);

    List<CompanyPark> selectByExample(CompanyParkExample example);

    CompanyPark selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CompanyPark record, @Param("example") CompanyParkExample example);

    int updateByExample(@Param("record") CompanyPark record, @Param("example") CompanyParkExample example);

    int updateByPrimaryKeySelective(CompanyPark record);

    int updateByPrimaryKey(CompanyPark record);
}