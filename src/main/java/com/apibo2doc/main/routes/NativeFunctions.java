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
@RequestMapping("/nativefunctions")
public class NativeFunctions {

    @GetMapping()
    public PlainTextModel getAllNativeFunctions() {
        List<String> nativeFunctionsList = PlainTextController.getAll(Variables.URL_NATIVE_FUNCTIONS);
        return PlainTextController.generateResponse("List of native functions", nativeFunctionsList);
    }

    @GetMapping("/query")
    public PlainTextModel getNativeFunction(@RequestParam("name") String name) {
        List<String> nativeFunctionsList = PlainTextController.getCustomList(Variables.URL_NATIVE_FUNCTIONS, name.toLowerCase());
        return PlainTextController.generateResponse("List of native functions", nativeFunctionsList);
    }
}
