package com.apibo2doc.main.models;

import java.util.Map;

public class JsonModel {

    public boolean status;
    public String message;
    public int count;
    public Map<String, String> list;

    public JsonModel() {}

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Map<String, String> getList() {
        return list;
    }

    public void setList(Map<String, String> list) {
        this.list = list;
    }

}

