package com.example.analysis.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ManagerService {
    List<Map<String, Object>> analysis(Date beginTime, Date endTime, Integer eventId);

    List<Map<String,Object>> analysisUsers(Date beginTime, Date endTime);
}
