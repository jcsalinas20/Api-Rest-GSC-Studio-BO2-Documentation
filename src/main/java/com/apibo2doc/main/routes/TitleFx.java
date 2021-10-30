package com.apibo2doc.main.routes;

import com.apibo2doc.main.Variables;
import com.apibo2doc.main.controllers.ScriptController;
import com.apibo2doc.main.models.ScriptModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/titlefx")
public class TitleFx {

    @GetMapping()
    public ScriptModel getTitleFx() {
        String titleFxText = ScriptController.getFileText(Variables.URL_TITLE_FX);
        return ScriptController.generateResponse("Title Fx", titleFxText);
    }

}
