package com.apibo2doc.main.routes;

import com.apibo2doc.main.Variables;
import com.apibo2doc.main.controllers.ArrayOfJsonController;
import com.apibo2doc.main.models.AddressesModel;
import com.apibo2doc.main.models.ArrayOfJsonModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class Addresses {

    @GetMapping()
    public ArrayOfJsonModel getAllAddresses() {
        List<AddressesModel> addressesList = ArrayOfJsonController.getAll(Variables.URL_ADDRESSES);
        return ArrayOfJsonController.generateResponse("List of addresses", addressesList);
    }

    @GetMapping("/query")
    public ArrayOfJsonModel getAddress(@RequestParam("name") String name) {
        List<AddressesModel> addressesList = ArrayOfJsonController.getCustomList(Variables.URL_ADDRESSES, name.toLowerCase());
        return ArrayOfJsonController.generateResponse("List of addresses", addressesList);
    }

}
