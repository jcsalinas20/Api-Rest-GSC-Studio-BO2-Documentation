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
@RequestMapping("/bones")
public class Bones {

    @GetMapping()
    public PlainTextModel getAllBones() {
        List<String> bonesList = PlainTextController.getAll(Variables.URL_BONES);
        return PlainTextController.generateResponse("List of bones", bonesList);
    }

    @GetMapping("/query")
    public PlainTextModel getBone(@RequestParam("name") String name) {
        List<String> bonesList = PlainTextController.getCustomList(Variables.URL_BONES, name.toLowerCase());
        return PlainTextController.generateResponse("List of bones", bonesList);
    }
}
