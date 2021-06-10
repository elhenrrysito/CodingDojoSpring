package com.henrry.contador.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class DobleController {

    @RequestMapping("/doble")
    public String doblarContador(HttpSession session) {
        if (session.getAttribute("counter") == null) {
            session.setAttribute("counter", 0);
        }
        Integer count = (Integer) session.getAttribute("counter");
        count+=2;
        session.setAttribute("counter", count);
        return "doble.jsp";
    }
}
