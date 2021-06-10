package com.henrry.contador.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String contador(HttpSession session) {
        if (session.getAttribute("counter") == null) {
            session.setAttribute("counter", 0);
        }
        Integer count = (Integer) session.getAttribute("counter");
        count++;
        session.setAttribute("counter", count);
        return "index.jsp";
    }

    @RequestMapping("/counter")
    public String contadorIndex() {

        return "counter.jsp";
    }
}
