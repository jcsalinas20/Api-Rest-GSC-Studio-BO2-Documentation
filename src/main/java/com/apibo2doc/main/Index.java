package com.apibo2doc.main;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Index {

    @RequestMapping("/")
    public String hello() {
        return "<a href='/weapons'>Weapons</a>";
    }
}
