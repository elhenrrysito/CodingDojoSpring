package com.henrry.contador.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class ResetController {

    @RequestMapping("/reset")
    public String resetContador(HttpSession session) {
        session.removeAttribute("counter");
        return "resetCounter.jsp";
    }
}
