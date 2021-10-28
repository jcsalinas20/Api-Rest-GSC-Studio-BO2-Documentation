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
@RequestMapping("/weapons")
public class WeaponsRoutes {

    @GetMapping()
    public PlainTextModel getAllWeapons() {
        List<String> weaponsList = PlainTextController.getAll(Variables.URL_WEAPONS);
        return PlainTextController.generateResponse("List of weapons", weaponsList);
    }

    @GetMapping("/query")
    public PlainTextModel getWeapon(@RequestParam("name") String name) {
        List<String> weaponsList = PlainTextController.getCustomList(Variables.URL_WEAPONS, name.toLowerCase());
        return PlainTextController.generateResponse("List of weapons", weaponsList);
    }
}
