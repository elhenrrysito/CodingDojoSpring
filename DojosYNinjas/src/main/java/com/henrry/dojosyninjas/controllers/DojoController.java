package com.henrry.dojosyninjas.controllers;

import com.henrry.dojosyninjas.models.Dojo;
import com.henrry.dojosyninjas.services.DojoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/dojos")
public class DojoController {
    private final DojoService dojoService;

    public DojoController(DojoService dojoService) {
        this.dojoService = dojoService;
    }

    @GetMapping("/new")
    public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
        return "dojo/newDojo.jsp"; // modificar
    }

    @PostMapping("/new")
    public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
        if(result.hasErrors()) {
            return "dojo/newDojo.jsp";
        } else {
            dojoService.createDojo(dojo);
            return "redirect:/ninjas/new"; // <---
        }
    }

    @GetMapping("/{id}")
    public String showDojo(@PathVariable("id") Long id, Model model) {
        Dojo dojo = dojoService.findDojo(id);
        model.addAttribute("dojo", dojo);
        return "dojo/allDojos.jsp"; // <---
    }

//    @GetMapping("")
//    public String allDojos(Model model) {
//        List<Dojo> dojos = dojoService.allDojos();
//        model.addAttribute("dojos", dojos);
//        return "dojos/allDojos.jsp";
//    }

}
