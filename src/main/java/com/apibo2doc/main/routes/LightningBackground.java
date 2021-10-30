package com.apibo2doc.main.routes;

import com.apibo2doc.main.Variables;
import com.apibo2doc.main.controllers.ScriptController;
import com.apibo2doc.main.models.ScriptModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lightningbackground")
public class LightningBackground {

    @GetMapping()
    public ScriptModel getLightningBackground() {
        String lightningBackgroundText = ScriptController.getFileText(Variables.URL_LIGHTNING_BACKGROUND);
        return ScriptController.generateResponse("Lightning Background", lightningBackgroundText);
    }

}
