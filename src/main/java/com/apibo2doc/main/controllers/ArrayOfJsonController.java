package com.apibo2doc.main.controllers;

import com.apibo2doc.main.models.AddressesModel;
import com.apibo2doc.main.models.ArrayOfJsonModel;
import com.apibo2doc.main.models.PlainTextModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ArrayOfJsonController {

    public static List<AddressesModel> getAll(String uri) {
        List<AddressesModel> dataList = new ArrayList<>();
        try {
            URL url = new URL(uri);
            BufferedReader read = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            String[] values = new String[4];
            int index = 0;
            while ((line = read.readLine()) != null) {
                if (line.isEmpty()) {
                    dataList.add(generateAddressModel(values[0], values[1], values[2], values[3]));
                    index = 0;
                } else {
                    values[index] = line.split(": ")[1];
                    index++;
                }
            }
            read.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataList;
    }

    public static List<AddressesModel> getCustomList(String uri, String query) {
        List<AddressesModel> dataList = new ArrayList<>();
        try {
            URL url = new URL(uri);
            BufferedReader read = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            String[] values = new String[4];
            int index = 0;
            boolean match = false;
            while ((line = read.readLine()) != null) {
                if (line.isEmpty()) {
                    if (match) {
                        dataList.add(generateAddressModel(values[0], values[1], values[2], values[3]));
                    }
                    index = 0;
                } else {
                    values[index] = line.split(": ")[1];
                    if (index == 0) {
                        match = values[index].contains(query);
                    }
                    index++;
                }
            }
            read.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataList;
    }

    public static AddressesModel generateAddressModel(String name, String pointer, String buffer, String size) {
        AddressesModel address = new AddressesModel();
        address.setName(name);
        address.setPointerAddress(pointer);
        address.setBufferAddress(buffer);
        address.setSize(size);
        return address;
    }

    public static ArrayOfJsonModel generateResponse(String msg, List<AddressesModel> list) {
        ArrayOfJsonModel response = new ArrayOfJsonModel();
        response.setStatus(list.size() > 0);
        response.setMessage(msg);
        response.setCount(list.size());
        response.setList(list);
        return response;
    }

}
