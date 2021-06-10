package com.henrry.mostrarfecha.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "index.jsp";
    }

    @RequestMapping("/date")
    public String dateTemplate(Model model) {
        SimpleDateFormat formato = new SimpleDateFormat("EEEE, dd MMMM yyyy", Locale.ENGLISH);
        Date dateToday = new Date();
        String today = formato.format(dateToday);
        model.addAttribute("date", today);
        return "date.jsp";
    }
    @RequestMapping("/time")
    public String timeTemplate(Model model) {
        SimpleDateFormat formato = new SimpleDateFormat("hh:mm a");
        Date time = new Date();
        String timeToday = formato.format(time);
        model.addAttribute("time", timeToday);
        return "time.jsp";
    }


}
