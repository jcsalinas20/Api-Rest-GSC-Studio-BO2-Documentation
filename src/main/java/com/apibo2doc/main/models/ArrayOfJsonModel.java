package com.apibo2doc.main.models;

import java.util.List;

public class ArrayOfJsonModel {

    public Boolean status;
    public String message;
    public int count;
    public List<AddressesModel> list;

    public ArrayOfJsonModel(){
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setList(List<AddressesModel> list) {
        this.list = list;
    }
}
