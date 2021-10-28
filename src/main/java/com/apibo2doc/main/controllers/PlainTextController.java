package com.apibo2doc.main.controllers;

import com.apibo2doc.main.models.PlainTextModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class PlainTextController {

    public static List<String> getAll(String uri) {
        List<String> dataList = new ArrayList<>();
        try {
            URL url = new URL(uri);
            BufferedReader read = new BufferedReader(new InputStreamReader(url.openStream()));
            String name;
            while ((name = read.readLine()) != null) {
                dataList.add(name);
            }
            read.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataList;
    }

    public static List<String> getCustomList(String uri, String query) {
        List<String> dataList = new ArrayList<>();
        try {
            URL url = new URL(uri);
            BufferedReader read = new BufferedReader(new InputStreamReader(url.openStream()));
            String name;
            while ((name = read.readLine()) != null) {
                if (name.contains(query)) {
                    dataList.add(name);
                }
            }
            read.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataList;
    }

    public static PlainTextModel generateResponse(String msg, List<String> list) {
        PlainTextModel response = new PlainTextModel();
        response.setStatus(list.size() > 0);
        response.setMessage(msg);
        response.setCount(list.size());
        response.setList(list);
        return response;
    }
}
