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
@RequestMapping("/turrets")
public class Turrets {

    @GetMapping()
    public PlainTextModel getAllTurrets() {
        List<String> turretsList = PlainTextController.getAll(Variables.URL_TURRETS);
        return PlainTextController.generateResponse("List of turrets", turretsList);
    }

    @GetMapping("/query")
    public PlainTextModel getTurret(@RequestParam("name") String name) {
        List<String> turretsList = PlainTextController.getCustomList(Variables.URL_TURRETS, name.toLowerCase());
        return PlainTextController.generateResponse("List of turrets", turretsList);
    }
}
