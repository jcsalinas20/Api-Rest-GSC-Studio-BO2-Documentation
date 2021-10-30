package com.apibo2doc.main;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@RestController
public class Index {

    @RequestMapping("/")
    public String mainPage() {
        InputStream file = getFileAsIOStream("index.html");
        return printFileContent(file);
    }


    private InputStream getFileAsIOStream(final String fileName) {
        InputStream ioStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream(fileName);

        if (ioStream == null) {
            throw new IllegalArgumentException(fileName + " is not found");
        }
        return ioStream;
    }

    private String printFileContent(InputStream file) {
        String fileText = "";
        try (InputStreamReader isr = new InputStreamReader(file);
             BufferedReader br = new BufferedReader(isr);)
        {
            String line;
            while ((line = br.readLine()) != null) {
                fileText += line;
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileText;
    }
}
