package com.sigmatrix.sc.dao.mapper.v1.auto;

import com.sigmatrix.sc.entity.v1.Settings;
import com.sigmatrix.sc.entity.v1.SettingsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SettingsMapper {
    int countByExample(SettingsExample example);

    int deleteByExample(SettingsExample example);

    int deleteByPrimaryKey(@Param("id") Integer id, @Param("tablePrefix") String tablePrefix);

    int insert(Settings record);

    int insertSelective(Settings record);

    List<Settings> selectByExample(SettingsExample example);

    Settings selectByPrimaryKey(@Param("id") Integer id, @Param("tablePrefix") String tablePrefix);

    int updateByExampleSelective(@Param("record") Settings record, @Param("example") SettingsExample example);

    int updateByExample(@Param("record") Settings record, @Param("example") SettingsExample example);

    int updateByPrimaryKeySelective(Settings record);

    int updateByPrimaryKey(Settings record);
}
