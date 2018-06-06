package com.example.analysis.dao;

import com.example.analysis.bean.WxUser;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

public interface WxUserDao {

    int insert(WxUser user);

    int update(WxUser user);

    @Delete("DELETE FORM wx_user WHERE id = #{id , jdbcType=INTEGER} ")
    int delete(Integer id);

    Boolean checkUserRegister(String openId);

    WxUser returnWxUserByOpenId(String openId);

    WxUser returnWxUserById(Integer id);

    List<WxUser> getAllWxUser();


}
