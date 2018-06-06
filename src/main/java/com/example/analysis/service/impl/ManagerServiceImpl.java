package com.example.analysis.service.impl;

import com.example.analysis.dao.WxCntDao;
import com.example.analysis.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private WxCntDao wxCntDao;


    @Override
    public List<Map<String, Object>> analysis(Date beginTime, Date endTime, Integer eventId) {
        List<Map<String, Object>> data = wxCntDao.selectCountWithCondition(beginTime, endTime, eventId);
        if(data.size() == 0){
            return null;
        }
        return data;
    }

    @Override
    public List<Map<String, Object>> analysisUsers(Date beginTime, Date endTime) {
        List<Map<String, Object>> data = wxCntDao.analysisUsers(beginTime, endTime);
        if(data.size() == 0){
            return null;
        }
        return data;
    }
}
