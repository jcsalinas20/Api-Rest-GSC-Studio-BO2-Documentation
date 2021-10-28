package com.apibo2doc.main.controllers;

import com.apibo2doc.main.models.JsonModel;
import com.apibo2doc.main.models.PlainTextModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;

public class JsonController {

    public static Map<String, String> getAll(String uri) {
        Map<String, String> dvarList = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        try {
            URL url = new URL(uri);
            BufferedReader read = new BufferedReader(new InputStreamReader(url.openStream()));
            String name;
            while ((name = read.readLine()) != null) {
                if (!name.contains("{") && !name.contains("}")) {
                    String[] line = name.split(": ");
                    String key = line[0].replaceAll("\"", "").replaceAll("\t", "");
                    String value = line[1].replaceAll("\"", "").replaceAll(",", "");
                    dvarList.put(key, value);
                }
            }
            read.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dvarList;
    }

    public static Map<String, String> getCustomList(String uri, String query) {
        Map<String, String> dvarList = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        try {
            URL url = new URL(uri);
            BufferedReader read = new BufferedReader(new InputStreamReader(url.openStream()));
            String name;
            while ((name = read.readLine()) != null) {
                if (!name.contains("{") && !name.contains("}")) {
                    String[] line = name.split(": ");
                    String key = line[0].replaceAll("\"", "").replaceAll("\t", "");
                    String value = line[1].replaceAll("\"", "").replaceAll(",", "");
                    if (key.toLowerCase().contains(query) || value.toLowerCase().contains(query)) {
                        dvarList.put(key, value);
                    }
                }
            }
            read.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dvarList;
    }

    public static JsonModel generateResponse(String msg, Map<String, String> list) {
        JsonModel response = new JsonModel();
        response.setStatus(list.size() > 0);
        response.setMessage(msg);
        response.setCount(list.size());
        response.setList(list);
        return response;
    }

}
