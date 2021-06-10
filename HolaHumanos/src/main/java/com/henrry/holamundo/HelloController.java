package com.henrry.holamundo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String hola(@RequestParam(value = "name", required = false, defaultValue = "Humano") String nombre, @RequestParam(value = "lastname", required = false, defaultValue="Humanoide") String apellido) {
        return "Hola " + nombre + " " + apellido + ", Bievenido a SpringBoot";
    }

}
