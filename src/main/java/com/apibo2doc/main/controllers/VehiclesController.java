package com.apibo2doc.main.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class VehiclesController {

    public static List<String> getAllVehicles() {
        List<String> weaponList = new ArrayList<>();
        try {
            URL url = new URL("https://raw.githubusercontent.com/jcsalinas20/GSC-Studio-BO2-Documentation/main/Vehicle.cpp");
            BufferedReader read = new BufferedReader(new InputStreamReader(url.openStream()));
            String name;
            while ((name = read.readLine()) != null) {
                weaponList.add(name);
            }
            read.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return weaponList;
    }

    public static List<String> getCustomList(String query) {
        List<String> weaponList = new ArrayList<>();
        try {
            URL url = new URL("https://raw.githubusercontent.com/jcsalinas20/GSC-Studio-BO2-Documentation/main/Vehicle.cpp");
            BufferedReader read = new BufferedReader(new InputStreamReader(url.openStream()));
            String name;
            while ((name = read.readLine()) != null) {
                if (name.contains(query)) {
                    weaponList.add(name);
                }
            }
            read.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return weaponList;
    }
}
