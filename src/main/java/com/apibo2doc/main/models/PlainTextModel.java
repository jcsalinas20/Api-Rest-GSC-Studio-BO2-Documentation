package com.apibo2doc.main.models;

import java.util.List;

public class PlainTextModel {

    public Boolean status;
    public String message;
    public int count;
    public List<String> list;

    public PlainTextModel(){
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

