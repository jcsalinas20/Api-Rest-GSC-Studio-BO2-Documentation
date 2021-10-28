package com.apibo2doc.main.routes;

import com.apibo2doc.main.controllers.VisionsController;
import com.apibo2doc.main.models.PlainTextModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/visions")
public class VisionsRoutes {

    @GetMapping()
    public PlainTextModel getAllVisions() {
        List<String> weaponList = VisionsController.getAllVisions();

        PlainTextModel response = new PlainTextModel();
        response.setStatus(weaponList.size() > 0);
        response.setMessage("List of visions");
        response.setCount(weaponList.size());
        response.setList(weaponList);

        return response;
    }

    @GetMapping("/query")
    public PlainTextModel getVision(@RequestParam("name") String name) {
        List<String> weaponList = VisionsController.getCustomList(name.toLowerCase());

        PlainTextModel response = new PlainTextModel();
        response.setStatus(weaponList.size() > 0);
        response.setMessage("List of visions");
        response.setCount(weaponList.size());
        response.setList(weaponList);

        return response;
    }
}
