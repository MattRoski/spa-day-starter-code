package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.Client;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller //This is the controller that handles the route: localhost:8080..or the / root page
public class SpaDayController {

    @GetMapping
    //can use RequestMapping(method = RequestMethod.GET) they both do the same thing
    public String customerForm () {
        return "serviceSelection";
    }

    @PostMapping
    public String spaMenu(@RequestParam String skintype, @RequestParam String manipedi, Model model) {

        Client newClient = new Client(skintype, manipedi);
        newClient.setAppropriateFacials(skintype);
        model.addAttribute("client" , newClient);

        return "menu";
    }
}
