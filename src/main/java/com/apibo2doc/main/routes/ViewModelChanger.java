package com.apibo2doc.main.routes;

import com.apibo2doc.main.Variables;
import com.apibo2doc.main.controllers.ScriptController;
import com.apibo2doc.main.models.ScriptModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/viewmodelchanger")
public class ViewModelChanger {

    @GetMapping()
    public ScriptModel getViewModelChanger() {
        String toggleScriptText = ScriptController.getFileText(Variables.URL_VIEW_MODEL_CHANGER);
        return ScriptController.generateResponse("View Model Changer", toggleScriptText);
    }

}
