package com.sigmatrix.sc.dao.mapper.v1.auto;

import com.sigmatrix.sc.entity.v1.ScancodeTransition;
import com.sigmatrix.sc.entity.v1.ScancodeTransitionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ScancodeTransitionMapper {
    int countByExample(ScancodeTransitionExample example);

    int deleteByExample(ScancodeTransitionExample example);

    int deleteByPrimaryKey(@Param("transitionId") Integer transitionId, @Param("tablePrefix") String tablePrefix);

    int insert(ScancodeTransition record);

    int insertSelective(ScancodeTransition record);

    List<ScancodeTransition> selectByExample(ScancodeTransitionExample example);

    ScancodeTransition selectByPrimaryKey(@Param("transitionId") Integer transitionId, @Param("tablePrefix") String tablePrefix);

    int updateByExampleSelective(@Param("record") ScancodeTransition record, @Param("example") ScancodeTransitionExample example);

    int updateByExample(@Param("record") ScancodeTransition record, @Param("example") ScancodeTransitionExample example);

    int updateByPrimaryKeySelective(ScancodeTransition record);

    int updateByPrimaryKey(ScancodeTransition record);
}
