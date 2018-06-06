package com.example.analysis.dao;

import com.example.analysis.bean.WxCnt;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface WxCntDao {

    @Insert("INSERT INTO wx_count (user_id , event_id , use_time , use_date , only_id) VALUES (#{userId , jdbcType=INTEGER} , #{eventId , jdbcType=INTEGER} , #{useTime , jdbcType=INTEGER} , #{useDate , jdbcType=DATE} , #{ownerId , jdbcType=VARCHAR})")
    int insert(WxCnt wxCnt);

    @Select("SELECT id FROM wx_count WHERE user_id=#{userId , jdbcType=INTEGER} AND event_id=#{eventId , jdbcType=INTEGER} AND use_time=#{useTime , jdbcType=INTEGER} AND use_date=#{useDate , jdbcType=DATE}")
    WxCnt selectByEntity(WxCnt cnt);

    WxCnt selectById(Integer id);

    @Select("select * from wx_count where only_id = #{ownerId , jdbcType=VARCHAR}")
    WxCnt selectByOnlyId(String ownerId);

    @Update("UPDATE wx_count SET use_time=#{useTime , jdbcType=INTEGER} WHERE id=#{id , jdbcType=INTEGER}")
    int update(WxCnt wxCnt);

    List<Map<String , Object>> selectCountWithCondition(@Param("beginTime") Date beginTime, @Param("endTime") Date endTime, @Param("eventId") Integer eventId);

    List<Map<String,Object>> analysisUsers(@Param("beginTime") Date beginTime, @Param("endTime") Date endTime);
}
