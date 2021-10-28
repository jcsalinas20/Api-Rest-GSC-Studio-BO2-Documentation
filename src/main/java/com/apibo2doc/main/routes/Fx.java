package com.apibo2doc.main.routes;

import com.apibo2doc.main.Variables;
import com.apibo2doc.main.controllers.PlainTextController;
import com.apibo2doc.main.models.PlainTextModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fx")
public class Fx {

    @GetMapping()
    public PlainTextModel getAllFx() {
        List<String> fxList = PlainTextController.getAll(Variables.URL_FX);
        return PlainTextController.generateResponse("List of fx", fxList);
    }

    @GetMapping("/query")
    public PlainTextModel getFx(@RequestParam("name") String name) {
        List<String> fxList = PlainTextController.getCustomList(Variables.URL_FX, name.toLowerCase());
        return PlainTextController.generateResponse("List of fx", fxList);
    }
}
