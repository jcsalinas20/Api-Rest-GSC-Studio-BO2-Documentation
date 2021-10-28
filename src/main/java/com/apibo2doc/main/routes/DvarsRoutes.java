package com.apibo2doc.main.routes;

import com.apibo2doc.main.controllers.DvarsController;
import com.apibo2doc.main.controllers.WeaponsController;
import com.apibo2doc.main.models.DvarsModel;
import com.apibo2doc.main.models.WeaponsModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dvars")
public class DvarsRoutes {

    @GetMapping()
    public DvarsModel getAllDvars() {
        Map<String, String> dvarsList = DvarsController.getAllDvars();

        DvarsModel response = new DvarsModel();
        response.setStatus(dvarsList.size() > 0);
        response.setMessage("List of dvars");
        response.setCount(dvarsList.size());
        response.setList(dvarsList);

        return response;
    }

    @GetMapping("/query")
    public DvarsModel getDvar(@RequestParam("name") String name) {
        Map<String, String> dvarsList = DvarsController.getCustomList(name.toLowerCase());

        DvarsModel response = new DvarsModel();
        response.setStatus(dvarsList.size() > 0);
        response.setMessage("List of dvars");
        response.setCount(dvarsList.size());
        response.setList(dvarsList);

        return response;
    }
}