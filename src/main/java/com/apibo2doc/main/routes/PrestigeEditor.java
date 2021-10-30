package com.apibo2doc.main.routes;

import com.apibo2doc.main.Variables;
import com.apibo2doc.main.controllers.ScriptController;
import com.apibo2doc.main.models.ScriptModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prestigeeditor")
public class PrestigeEditor {

    @GetMapping()
    public ScriptModel getPrestigeEditor() {
        String prestigeEditorText = ScriptController.getFileText(Variables.URL_PRESTIGE_EDITOR);
        return ScriptController.generateResponse("Prestige Editor", prestigeEditorText);
    }

}
