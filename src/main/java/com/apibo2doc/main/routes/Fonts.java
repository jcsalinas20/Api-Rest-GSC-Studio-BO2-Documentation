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
@RequestMapping("/fonts")
public class Fonts {

    @GetMapping()
    public PlainTextModel getAllFonts() {
        List<String> fontsList = PlainTextController.getAll(Variables.URL_FONTS);
        return PlainTextController.generateResponse("List of fonts", fontsList);
    }

    @GetMapping("/query")
    public PlainTextModel getFont(@RequestParam("name") String name) {
        List<String> fontsList = PlainTextController.getCustomList(Variables.URL_FONTS, name.toLowerCase());
        return PlainTextController.generateResponse("List of fonts", fontsList);
    }
}
