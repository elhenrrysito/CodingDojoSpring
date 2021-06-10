package com.henrry.ninjagoldgame.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

@Controller
public class ProcessController {

    @RequestMapping(value="/gold", method = RequestMethod.POST)
    public String procesoJuego(@RequestParam(value = "option") String option, HttpSession session) {
        Random random = new Random();
        int numeroAleatorio = 0;
        int dineroActual = (Integer) session.getAttribute("gold");
        SimpleDateFormat formato = new SimpleDateFormat("EEEE, dd MMMM yyyy, hh:mm a");
        Date fecha= new Date();
        String fechaHora = formato.format(fecha);
        ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
        switch (option) {
            case "farm":
                numeroAleatorio = random.nextInt(20 - 10) + 10;
                session.setAttribute("gold", dineroActual + numeroAleatorio);
                activities.add("Has entrado a Farm y has ganado " + numeroAleatorio + " gold (" + fechaHora + ")");
                break;
            case "cave":
                numeroAleatorio = random.nextInt(10 - 5) + 5;
                session.setAttribute("gold", dineroActual + numeroAleatorio);
                activities.add("Has entrado a Cave y has ganado " + numeroAleatorio + " gold (" + fechaHora + ")");
                break;
            case "house":
                numeroAleatorio = random.nextInt(5 - 2) + 2;
                session.setAttribute("gold", dineroActual + numeroAleatorio);
                activities.add("Has entrado a House y has ganado " + numeroAleatorio + " gold (" + fechaHora + ")");
                break;
            case "casino":
                numeroAleatorio = random.nextInt(51+51) - 51;

                if(dineroActual > 0) {
                    session.setAttribute("gold", dineroActual + numeroAleatorio);
                    if (numeroAleatorio > 0) {
                        activities.add("Has entrado a Casino y has ganado " + numeroAleatorio + " gold (" + fechaHora + ")");
                    } else {
                        activities.add("Has entrado a Casino y has perdido " + numeroAleatorio + " gold (" + fechaHora + ")");
                    }
                } else {
                    activities.add("Debes tener gold para gastar en el Casino! (" + fechaHora + ")");
                }
                break;
            case "spa":
                numeroAleatorio = random.nextInt(20 - 5) + 5;
                if(dineroActual > 0) {
                    session.setAttribute("gold", dineroActual - numeroAleatorio);
                    activities.add("Has entrado a Spa y has gastado " + numeroAleatorio + " gold (" + fechaHora + ")");
                } else {
                    activities.add("Debes tener gold para gastar en el Spa! (" + fechaHora + ")");
                }
                break;
        }

        return "redirect:/";
    }

    @RequestMapping("/reset")
    public String resetGold(HttpSession session) {
        session.removeAttribute("gold");
        session.removeAttribute("activities");
        return "redirect:/";
    }
}
