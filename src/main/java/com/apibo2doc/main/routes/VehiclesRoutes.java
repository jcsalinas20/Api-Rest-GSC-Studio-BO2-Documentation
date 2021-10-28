package com.apibo2doc.main.routes;

import com.apibo2doc.main.controllers.VehiclesController;
import com.apibo2doc.main.models.PlainTextModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehiclesRoutes {

    @GetMapping()
    public PlainTextModel getAllVehicles() {
        List<String> weaponList = VehiclesController.getAllVehicles();

        PlainTextModel response = new PlainTextModel();
        response.setStatus(weaponList.size() > 0);
        response.setMessage("List of vehicles");
        response.setCount(weaponList.size());
        response.setList(weaponList);

        return response;
    }

    @GetMapping("/query")
    public PlainTextModel getVehicle(@RequestParam("name") String name) {
        List<String> weaponList = VehiclesController.getCustomList(name.toLowerCase());

        PlainTextModel response = new PlainTextModel();
        response.setStatus(weaponList.size() > 0);
        response.setMessage("List of vehicles");
        response.setCount(weaponList.size());
        response.setList(weaponList);

        return response;
    }
}
