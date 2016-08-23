package com.sigmatrix.sc.dao.mapper.v1.auto;

import com.sigmatrix.sc.entity.v1.ActivityTemplate;
import com.sigmatrix.sc.entity.v1.ActivityTemplateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActivityTemplateMapper {
    int countByExample(ActivityTemplateExample example);

    int deleteByExample(ActivityTemplateExample example);

    int deleteByPrimaryKey(@Param("templateId") Integer templateId, @Param("tablePrefix") String tablePrefix);

    int insert(ActivityTemplate record);

    int insertSelective(ActivityTemplate record);

    List<ActivityTemplate> selectByExample(ActivityTemplateExample example);

    ActivityTemplate selectByPrimaryKey(@Param("templateId") Integer templateId, @Param("tablePrefix") String tablePrefix);

    int updateByExampleSelective(@Param("record") ActivityTemplate record, @Param("example") ActivityTemplateExample example);

    int updateByExample(@Param("record") ActivityTemplate record, @Param("example") ActivityTemplateExample example);

    int updateByPrimaryKeySelective(ActivityTemplate record);

    int updateByPrimaryKey(ActivityTemplate record);
}
