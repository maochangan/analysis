package com.example.analysis.util;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class JsonResult {

    private int status;

    private Map<String, Object> data = new HashMap<String, Object>();

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public static JsonResult success() {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setStatus(1);
        return jsonResult;
    }

    public static JsonResult fail() {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setStatus(0);
        return jsonResult;
    }

    public JsonResult add(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    @ExceptionHandler(RuntimeException.class)
    public Map<String, Object> exceptionResult(Exception exception) {
        exception.printStackTrace();
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("status", 0);
        result.put("message", "系统异常，请稍后再试！");
        return result;
    }
}
