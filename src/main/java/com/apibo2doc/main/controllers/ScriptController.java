package com.apibo2doc.main.controllers;

import com.apibo2doc.main.models.PlainTextModel;
import com.apibo2doc.main.models.ScriptModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

public class ScriptController {

    public static String getFileText(String uri) {
        String textFile = "";
        try {
            URL url = new URL(uri);
            BufferedReader read = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            boolean commentLines = false;
            while ((line = read.readLine()) != null) {
                if (line.contains("/*")){
                    commentLines = true;
                }
                if (line.contains("*/")){
                    commentLines = false;

                } else if (!commentLines) {
                    textFile = textFile.concat(line + "\n");
                }
            }
            read.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(textFile);
        return textFile;
    }

    public static ScriptModel generateResponse(String msg, String textFile) {
        ScriptModel response = new ScriptModel();
        response.setStatus(true);
        response.setMessage(msg);
        response.setText(textFile);
        return response;
    }
}
