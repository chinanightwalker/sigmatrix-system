package com.sigmatrix.sc.dao.mapper.v1.auto;

import com.sigmatrix.sc.entity.v1.ShareRedbagLog;
import com.sigmatrix.sc.entity.v1.ShareRedbagLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShareRedbagLogMapper {
    int countByExample(ShareRedbagLogExample example);

    int deleteByExample(ShareRedbagLogExample example);

    int deleteByPrimaryKey(@Param("id") String id, @Param("tablePrefix") String tablePrefix);

    int insert(ShareRedbagLog record);

    int insertSelective(ShareRedbagLog record);

    List<ShareRedbagLog> selectByExample(ShareRedbagLogExample example);

    ShareRedbagLog selectByPrimaryKey(@Param("id") String id, @Param("tablePrefix") String tablePrefix);

    int updateByExampleSelective(@Param("record") ShareRedbagLog record, @Param("example") ShareRedbagLogExample example);

    int updateByExample(@Param("record") ShareRedbagLog record, @Param("example") ShareRedbagLogExample example);

    int updateByPrimaryKeySelective(ShareRedbagLog record);

    int updateByPrimaryKey(ShareRedbagLog record);
}
