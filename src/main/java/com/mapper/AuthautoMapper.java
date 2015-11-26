package com.mapper;

import com.bean.Authauto;
import com.bean.AuthautoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AuthautoMapper {
    int countByExample(AuthautoExample example);

    int deleteByExample(AuthautoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Authauto record);

    int insertSelective(Authauto record);

    List<Authauto> selectByExample(AuthautoExample example);

    Authauto selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Authauto record, @Param("example") AuthautoExample example);

    int updateByExample(@Param("record") Authauto record, @Param("example") AuthautoExample example);

    int updateByPrimaryKeySelective(Authauto record);

    int updateByPrimaryKey(Authauto record);
}