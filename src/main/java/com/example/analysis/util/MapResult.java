package com.example.analysis.util;


public class MapResult {

    private Object data ;

    private String open_id;

    private Integer status ;

    public String getOpen_id() {
        return open_id;
    }

    public void setOpen_id(String open_id) {
        this.open_id = open_id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static MapResult success(){
        MapResult result = new MapResult();
        result.setStatus(1);
        return result;
    }

    public static MapResult fail(){
        MapResult result = new MapResult();
        result.setStatus(0);
        return result;
    }

    public MapResult add(Object value) {
        this.setData(value);
        return this;
    }

    public MapResult addOpenid(String value){
        this.setOpen_id(value);
        return this;
    }

}
