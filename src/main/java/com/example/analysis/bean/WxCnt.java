package com.example.analysis.bean;

import java.sql.Timestamp;
import java.util.Date;

public class WxCnt {

    private Integer id;

    private Integer userId;

    private Integer eventId;

    private Integer useTime;

    private Date useDate;

    private String ownerId;

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public Integer getUseTime() {
        return useTime;
    }

    public void setUseTime(Integer useTime) {
        this.useTime = useTime;
    }

    public Timestamp getUseDate() {
        return new Timestamp(useDate.getTime());
    }

    public void setUseDate(Date useDate) {
        this.useDate = useDate;
    }
}
