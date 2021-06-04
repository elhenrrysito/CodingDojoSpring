package com.henrry.cadenas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CadenasApplication {

    public static void main(String[] args) {
        SpringApplication.run(CadenasApplication.class, args);
    }

    @RequestMapping("/")
    public String saludarCliente() {
        return "Hola cliente! ¿Cómo te encuentras? Espero estés teniendo un excelente día";
    }

    @RequestMapping("/random")
    public String buenMensajeSpring() {
        return "Spring Boot es genial! Es súper fácil de usar";
    }

}
