package com.mapper;

import com.bean.HelpCenter;
import com.bean.HelpCenterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HelpCenterMapper {
    int countByExample(HelpCenterExample example);

    int deleteByExample(HelpCenterExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(HelpCenter record);

    int insertSelective(HelpCenter record);

    List<HelpCenter> selectByExample(HelpCenterExample example);

    HelpCenter selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") HelpCenter record, @Param("example") HelpCenterExample example);

    int updateByExample(@Param("record") HelpCenter record, @Param("example") HelpCenterExample example);

    int updateByPrimaryKeySelective(HelpCenter record);

    int updateByPrimaryKey(HelpCenter record);
}