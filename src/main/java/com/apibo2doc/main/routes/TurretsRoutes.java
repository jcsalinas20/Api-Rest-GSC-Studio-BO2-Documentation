package com.apibo2doc.main.routes;

import com.apibo2doc.main.controllers.TurretsController;
import com.apibo2doc.main.controllers.VisionsController;
import com.apibo2doc.main.models.TurretsModel;
import com.apibo2doc.main.models.VisionsModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/turrets")
public class TurretsRoutes {

    @GetMapping()
    public TurretsModel getAllTurrets() {
        List<String> weaponList = TurretsController.getAllTurrets();

        TurretsModel response = new TurretsModel();
        response.setStatus(weaponList.size() > 0);
        response.setMessage("List of turrets");
        response.setCount(weaponList.size());
        response.setList(weaponList);

        return response;
    }

    @GetMapping("/query")
    public TurretsModel getTurret(@RequestParam("name") String name) {
        List<String> weaponList = TurretsController.getCustomList(name.toLowerCase());

        TurretsModel response = new TurretsModel();
        response.setStatus(weaponList.size() > 0);
        response.setMessage("List of turrets");
        response.setCount(weaponList.size());
        response.setList(weaponList);

        return response;
    }
}