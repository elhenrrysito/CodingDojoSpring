package com.henrry.ninjagoldgame.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller


public class HomeController {
    @RequestMapping("/")
    public String bienvenida(HttpSession session) {
        if(session.getAttribute("gold") == null) {
            session.setAttribute("gold", 0);
            ArrayList<String> activities = new ArrayList<>();
            session.setAttribute("activities", activities);
        }
        return "index.jsp";
    }
}
