package com.mapper;

import com.bean.Shake;
import com.bean.ShakeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShakeMapper {
    int countByExample(ShakeExample example);

    int deleteByExample(ShakeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Shake record);

    int insertSelective(Shake record);

    List<Shake> selectByExample(ShakeExample example);

    Shake selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Shake record, @Param("example") ShakeExample example);

    int updateByExample(@Param("record") Shake record, @Param("example") ShakeExample example);

    int updateByPrimaryKeySelective(Shake record);

    int updateByPrimaryKey(Shake record);
}