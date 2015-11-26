package com.mapper;

import com.bean.CarPayRule;
import com.bean.CarPayRuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CarPayRuleMapper {
    int countByExample(CarPayRuleExample example);

    int deleteByExample(CarPayRuleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CarPayRule record);

    int insertSelective(CarPayRule record);

    List<CarPayRule> selectByExample(CarPayRuleExample example);

    CarPayRule selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CarPayRule record, @Param("example") CarPayRuleExample example);

    int updateByExample(@Param("record") CarPayRule record, @Param("example") CarPayRuleExample example);

    int updateByPrimaryKeySelective(CarPayRule record);

    int updateByPrimaryKey(CarPayRule record);
}