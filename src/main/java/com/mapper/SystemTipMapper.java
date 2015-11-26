package com.mapper;

import com.bean.SystemTip;
import com.bean.SystemTipExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemTipMapper {
    int countByExample(SystemTipExample example);

    int deleteByExample(SystemTipExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SystemTip record);

    int insertSelective(SystemTip record);

    List<SystemTip> selectByExample(SystemTipExample example);

    SystemTip selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SystemTip record, @Param("example") SystemTipExample example);

    int updateByExample(@Param("record") SystemTip record, @Param("example") SystemTipExample example);

    int updateByPrimaryKeySelective(SystemTip record);

    int updateByPrimaryKey(SystemTip record);
}