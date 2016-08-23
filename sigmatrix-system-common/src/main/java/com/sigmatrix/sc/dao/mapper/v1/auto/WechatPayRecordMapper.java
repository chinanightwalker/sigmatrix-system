package com.sigmatrix.sc.dao.mapper.v1.auto;

import com.sigmatrix.sc.entity.v1.WechatPayRecord;
import com.sigmatrix.sc.entity.v1.WechatPayRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WechatPayRecordMapper {
    int countByExample(WechatPayRecordExample example);

    int deleteByExample(WechatPayRecordExample example);

    int deleteByPrimaryKey(@Param("id") Integer id, @Param("tablePrefix") String tablePrefix);

    int insert(WechatPayRecord record);

    int insertSelective(WechatPayRecord record);

    List<WechatPayRecord> selectByExample(WechatPayRecordExample example);

    WechatPayRecord selectByPrimaryKey(@Param("id") Integer id, @Param("tablePrefix") String tablePrefix);

    int updateByExampleSelective(@Param("record") WechatPayRecord record, @Param("example") WechatPayRecordExample example);

    int updateByExample(@Param("record") WechatPayRecord record, @Param("example") WechatPayRecordExample example);

    int updateByPrimaryKeySelective(WechatPayRecord record);

    int updateByPrimaryKey(WechatPayRecord record);
}
