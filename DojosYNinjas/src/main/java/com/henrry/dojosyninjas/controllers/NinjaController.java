package com.henrry.dojosyninjas.controllers;


import com.henrry.dojosyninjas.models.Dojo;
import com.henrry.dojosyninjas.models.Ninja;
import com.henrry.dojosyninjas.services.DojoService;
import com.henrry.dojosyninjas.services.NinjaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/ninjas")
public class NinjaController {
    private final NinjaService ninjaService;
    private final DojoService dojoService;

    public NinjaController(NinjaService ninjaService, DojoService dojoService) {
        this.ninjaService = ninjaService;
        this.dojoService = dojoService;
    }

    @GetMapping("/new")
    public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
        List<Dojo> dojos = dojoService.allDojos();
        model.addAttribute("dojos", dojos);
        return "ninja/newNinja.jsp";
    }

    @PostMapping("/new")
    public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
        if(result.hasErrors()) {
            return "ninja/newNinja.jsp";
        } else {
            ninjaService.createNinja(ninja);
            return "redirect:/dojos/" + ninja.getDojo().getId();
        }
    }
}
