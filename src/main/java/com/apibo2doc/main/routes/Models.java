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
@RequestMapping("/models")
public class Models {

    @GetMapping()
    public PlainTextModel getAllModels() {
        List<String> modelsList = PlainTextController.getAll(Variables.URL_MODELS);
        return PlainTextController.generateResponse("List of models", modelsList);
    }

    @GetMapping("/query")
    public PlainTextModel getModel(@RequestParam("name") String name) {
        List<String> modelsList = PlainTextController.getCustomList(Variables.URL_MODELS, name.toLowerCase());
        return PlainTextController.generateResponse("List of models", modelsList);
    }
}
