package com.apibo2doc.main.routes;

import com.apibo2doc.main.controllers.WeaponsController;
import com.apibo2doc.main.models.PlainTextModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/weapons")
public class WeaponsRoutes {

    @GetMapping()
    public PlainTextModel getAllWeapons() {
        List<String> weaponList = WeaponsController.getAllWeapons();

        PlainTextModel response = new PlainTextModel();
        response.setStatus(weaponList.size() > 0);
        response.setMessage("List of weapons");
        response.setCount(weaponList.size());
        response.setList(weaponList);

        return response;
    }

    @GetMapping("/query")
    public PlainTextModel getWeapon(@RequestParam("name") String name) {
        List<String> weaponList = WeaponsController.getCustomList(name.toLowerCase());

        PlainTextModel response = new PlainTextModel();
        response.setStatus(weaponList.size() > 0);
        response.setMessage("List of weapons");
        response.setCount(weaponList.size());
        response.setList(weaponList);

        return response;
    }
}
