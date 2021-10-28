package com.apibo2doc.main.routes;

import com.apibo2doc.main.Variables;
import com.apibo2doc.main.controllers.JsonController;
import com.apibo2doc.main.models.JsonModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/dvars")
public class Dvars {

    @GetMapping()
    public JsonModel getAllDvars() {
        Map<String, String> dvarsList = JsonController.getAll(Variables.URL_DVARS);
        return JsonController.generateResponse("List of dvars", dvarsList);
    }

    @GetMapping("/query")
    public JsonModel getDvar(@RequestParam("name") String name) {
        Map<String, String> dvarsList = JsonController.getCustomList(Variables.URL_DVARS, name.toLowerCase());
        return JsonController.generateResponse("List of dvars", dvarsList);
    }
}