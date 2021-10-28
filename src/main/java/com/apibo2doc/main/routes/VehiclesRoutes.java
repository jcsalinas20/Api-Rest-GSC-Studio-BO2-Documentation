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
@RequestMapping("/vehicles")
public class VehiclesRoutes {

    @GetMapping()
    public PlainTextModel getAllVehicles() {
        List<String> vehiclesList = PlainTextController.getAll(Variables.URL_VEHICLES);
        return PlainTextController.generateResponse("List of vehicles", vehiclesList);
    }

    @GetMapping("/query")
    public PlainTextModel getVehicle(@RequestParam("name") String name) {
        List<String> vehiclesList = PlainTextController.getCustomList(Variables.URL_VEHICLES, name.toLowerCase());
        return PlainTextController.generateResponse("List of vehicles", vehiclesList);
    }
}
