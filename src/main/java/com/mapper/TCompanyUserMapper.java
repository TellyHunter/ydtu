package com.mapper;

import com.bean.TCompanyUser;
import com.bean.TCompanyUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCompanyUserMapper {
    int countByExample(TCompanyUserExample example);

    int deleteByExample(TCompanyUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TCompanyUser record);

    int insertSelective(TCompanyUser record);

    List<TCompanyUser> selectByExample(TCompanyUserExample example);

    TCompanyUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TCompanyUser record, @Param("example") TCompanyUserExample example);

    int updateByExample(@Param("record") TCompanyUser record, @Param("example") TCompanyUserExample example);

    int updateByPrimaryKeySelective(TCompanyUser record);

    int updateByPrimaryKey(TCompanyUser record);
}