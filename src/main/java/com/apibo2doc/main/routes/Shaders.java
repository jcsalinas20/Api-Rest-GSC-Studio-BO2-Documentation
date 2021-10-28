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
@RequestMapping("/shaders")
public class Shaders {

    @GetMapping()
    public PlainTextModel getAllShaders() {
        List<String> shadersList = PlainTextController.getAll(Variables.URL_SHADERS);
        return PlainTextController.generateResponse("List of shaders", shadersList);
    }

    @GetMapping("/query")
    public PlainTextModel getShader(@RequestParam("name") String name) {
        List<String> shadersList = PlainTextController.getCustomList(Variables.URL_SHADERS, name.toLowerCase());
        return PlainTextController.generateResponse("List of shaders", shadersList);
    }
}
