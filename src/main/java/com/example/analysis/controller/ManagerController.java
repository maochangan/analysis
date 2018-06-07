package com.example.analysis.controller;


import com.example.analysis.service.ManagerService;
import com.example.analysis.util.AdminUtil;
import com.example.analysis.util.AppMd5Util;
import com.example.analysis.util.JsonResult;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping(value = "manager")
public class ManagerController {


    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    Logger logger = LoggerFactory.getLogger(ManagerController.class);

    @Autowired
    private ManagerService managerService;


    @RequestMapping(value = "adminLogin", method = RequestMethod.POST)
    public JsonResult adminLogin(@Param("username") String username, @Param("password") String password, HttpSession session) {
        if(null == username && null == password){
            return JsonResult.fail().add("msg", "请输入用户名密码");
        }
        logger.info("check null" + username + password);
        if (username.equals(AdminUtil.USER_NAME) && AppMd5Util.md5Password(password).equals(AdminUtil.PASSWORD)) {
            session.setAttribute("userName", username);
            return JsonResult.success().add("msg", "登陆成功！");
        } else {
            return JsonResult.fail().add("msg", "用户名密码错误");
        }
    }

    @RequestMapping(value = "analysis", method = RequestMethod.GET)
    public JsonResult analysis(@Param("beginTime") Timestamp beginTime, @Param("endTime") Timestamp endTime, @Param("eventId") Integer eventId, HttpSession session) {
        logger.info("事件数据查询API");
        if (null == session.getAttribute("userName")) {
            return JsonResult.fail().add("msg", "请登陆！");
        }
        logger.info("查询使用信息:" + beginTime + endTime + eventId);
        List<Map<String, Object>> data = managerService.analysis(beginTime, endTime, eventId);
        if (null == data) {
            return JsonResult.fail().add("msg", "no date");
        } else {
            return JsonResult.success().add("data", data);
        }
    }

    @RequestMapping(value = "analysis/users", method = RequestMethod.GET)
    public JsonResult analysisUsers(@Param("beginTime")Timestamp beginTime, @Param("endTime")Timestamp endTime, HttpSession session) {
        logger.info("用户数据查询API");
        if (null == session.getAttribute("userName")) {
            return JsonResult.fail().add("msg", "请登陆！");
        }
        logger.info("查询使用信息:" + beginTime + endTime);
        List<Map<String, Object>> data = managerService.analysisUsers(beginTime, endTime);
        if (null == data) {
            return JsonResult.fail().add("msg", "no data");
        } else {
            return JsonResult.success().add("data", data);
        }
    }


//    @RequestMapping(value = "analysis/usersWithPage", method = RequestMethod.GET)
//    public JsonResult usersWithPage(@Param("beginTime")Timestamp beginTime, @Param("endTime")Timestamp endTime, @Param("pSize") Integer pSize , @Param("pn") Integer pn , HttpSession session) {
//        logger.info("用户数据查询API分页查询");
//        PageHelper.startPage(pn , pSize);
//        List<Map<String, Object>> data = managerService.analysisUsers(beginTime, endTime);
//        if (null == data){
//            return JsonResult.fail().add("msg", "no data");
//        }else{
//            PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String , Object>>(data);
//            return JsonResult.success().add("pageInfo" , pageInfo);
//        }
//    }



    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String test() {
        Date endTime = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DATE, 1);
        Date beginTime = calendar.getTime();
        Integer eventId = null;
        List<Map<String, Object>> list = managerService.analysis(beginTime, endTime, eventId);
        List<Map<String, Object>> data1 = managerService.analysisUsers(beginTime, endTime);
        Map<String, Object> data = new HashMap<>();
        data.put("status", 1);
        data.put("data", list);
        data.put("data1", data1);
        return data.toString();
    }


}
