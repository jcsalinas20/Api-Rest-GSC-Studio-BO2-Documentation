package com.apibo2doc.main.models;

import java.util.List;

public class VehiclesModel {

    private Boolean status;
    private String message;
    private int count;
    private List list;

    public VehiclesModel(){
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
