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
@RequestMapping("/visions")
public class VisionsRoutes {

    @GetMapping()
    public PlainTextModel getAllVisions() {
        List<String> visionsList = PlainTextController.getAll(Variables.URL_VISIONS);
        return PlainTextController.generateResponse("List of visions", visionsList);
    }

    @GetMapping("/query")
    public PlainTextModel getVision(@RequestParam("name") String name) {
        List<String> visionsList = PlainTextController.getCustomList(Variables.URL_VISIONS, name.toLowerCase());
        return PlainTextController.generateResponse("List of visions", visionsList);
    }
}
