package com.henrry.lenguajes.controllers;

import com.henrry.lenguajes.models.Lenguaje;
import com.henrry.lenguajes.services.LenguajeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LenguajeApi {
    private final LenguajeService lenguajeService;

    public LenguajeApi(LenguajeService lenguajeService) {
        this.lenguajeService = lenguajeService;
    }

    @RequestMapping("/api/lenguajes")
    public List<Lenguaje> index() {
        return lenguajeService.allLenguajes();
    }

    @RequestMapping(value="/api/lenguajes", method= RequestMethod.POST)
    public Lenguaje create(@RequestParam("name") String name,
                           @RequestParam("creator") String creator,
                           @RequestParam("currentVersion") String currentVersion) {
        Lenguaje lenguaje = new Lenguaje(name, creator, currentVersion);
        return lenguajeService.createLenguaje(lenguaje);
    }

    @RequestMapping("/api/lenguajes/{id}")
    public Lenguaje show(@PathVariable("id") Long id) {
        Lenguaje lenguaje = lenguajeService.findLenguaje(id);
        return lenguaje;
    }

    @RequestMapping(value="/api/lenguajes/{id}", method = RequestMethod.PUT)
    public Lenguaje update(@PathVariable("id") Long id,
                           @RequestParam("name") String name,
                           @RequestParam("creator") String creator,
                           @RequestParam("currentVersion") String currentVersion) {
        Lenguaje lenguaje = lenguajeService.findLenguaje(id);
        lenguaje.setName(name);
        lenguaje.setCreator(creator);
        lenguaje.setCurrentVersion(currentVersion);

        return lenguajeService.updateLenguaje(lenguaje);
    }
}
