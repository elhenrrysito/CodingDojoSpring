package com.henrry.familiarrouting;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coding")
public class CodingController {

    @RequestMapping("")
    public String helloCodingDojo() {
        return "¡Hola Coding Dojo!";
    }

    @RequestMapping("/python")
    public String pythonDjango() {
        return "¡Python/Django fue increíble!";
    }

    @RequestMapping("/java")
    public String javaBest() {
        return "¡Java/Spring es lo mejor!";
    }

}
