package com.apibo2doc.main.routes;

import com.apibo2doc.main.Variables;
import com.apibo2doc.main.controllers.PlainTextController;
import com.apibo2doc.main.controllers.ScriptController;
import com.apibo2doc.main.models.PlainTextModel;
import com.apibo2doc.main.models.ScriptModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/togglescript")
public class ToggleScript {

    @GetMapping()
    public ScriptModel getToggleScript() {
        String toggleScriptText = ScriptController.getFileText(Variables.URL_TOGGLE_SCRIPT);
        return ScriptController.generateResponse("Toggle Script", toggleScriptText);
    }

}
