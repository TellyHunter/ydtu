package com.mapper;

import com.bean.TCompanyPark;
import com.bean.TCompanyParkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCompanyParkMapper {
    int countByExample(TCompanyParkExample example);

    int deleteByExample(TCompanyParkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TCompanyPark record);

    int insertSelective(TCompanyPark record);

    List<TCompanyPark> selectByExample(TCompanyParkExample example);

    TCompanyPark selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TCompanyPark record, @Param("example") TCompanyParkExample example);

    int updateByExample(@Param("record") TCompanyPark record, @Param("example") TCompanyParkExample example);

    int updateByPrimaryKeySelective(TCompanyPark record);

    int updateByPrimaryKey(TCompanyPark record);
}