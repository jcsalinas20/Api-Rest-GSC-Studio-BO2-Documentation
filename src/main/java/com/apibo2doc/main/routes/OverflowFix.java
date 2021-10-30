package com.apibo2doc.main.routes;

import com.apibo2doc.main.Variables;
import com.apibo2doc.main.controllers.ScriptController;
import com.apibo2doc.main.models.ScriptModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/overflowfix")
public class OverflowFix {

    @GetMapping()
    public ScriptModel getOverflowFix() {
        String overflowFixText = ScriptController.getFileText(Variables.URL_OVERFLOW_FIX);
        return ScriptController.generateResponse("Overflow Fix", overflowFixText);
    }

}
