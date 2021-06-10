package com.henrry.lenguajes.controllers;

import com.henrry.lenguajes.models.Lenguaje;
import com.henrry.lenguajes.services.LenguajeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/lenguajes")
public class LenguajeController {
    private final LenguajeService lenguajeService;

    public LenguajeController(LenguajeService lenguajeService) {
        this.lenguajeService = lenguajeService;
    }

    @RequestMapping("")
    public String index(Model model, @ModelAttribute("lenguaje") Lenguaje lenguaje) {
        List<Lenguaje> lenguajes = lenguajeService.allLenguajes();
        model.addAttribute("lenguajes", lenguajes);
        return ("/lenguajes/index.jsp");
    }

    @RequestMapping(value="", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("lenguaje") Lenguaje lenguaje, BindingResult result) {
        if(result.hasErrors()) {
            return "/lenguajes/index.jsp";
        } else {
            lenguajeService.createLenguaje(lenguaje);
            return "redirect:/lenguajes";
        }
    }



    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public String showLenguaje(@PathVariable("id") Long id, Model model) {
        Lenguaje lenguaje = lenguajeService.findLenguaje(id);
        model.addAttribute("lenguaje", lenguaje);
        return "/lenguajes/showLenguaje.jsp";
    }

    @RequestMapping(value="/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        Lenguaje lenguaje = lenguajeService.findLenguaje(id);
        model.addAttribute("lenguaje", lenguaje);
        return "/lenguajes/edit.jsp";
    }

    @RequestMapping(value="/{id}", method = RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("lenguaje") Lenguaje lenguaje, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "/lenguajes/edit.jsp";
        } else {
            lenguajeService.updateLenguaje(lenguaje);
            return "redirect:/lenguajes";
        }
    }

    @RequestMapping(value="/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        lenguajeService.deleteLenguaje(id);
        return "redirect:/lenguajes";
    }


}
