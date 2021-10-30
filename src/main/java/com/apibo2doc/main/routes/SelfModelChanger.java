package com.apibo2doc.main.routes;

import com.apibo2doc.main.Variables;
import com.apibo2doc.main.controllers.ScriptController;
import com.apibo2doc.main.models.ScriptModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/selfmodelchanger")
public class SelfModelChanger {

    @GetMapping()
    public ScriptModel getSelfModelChanger() {
        String selfModelChangerText = ScriptController.getFileText(Variables.URL_SELF_MODEL_CHANGER);
        return ScriptController.generateResponse("Self Model Changer", selfModelChangerText);
    }

}
