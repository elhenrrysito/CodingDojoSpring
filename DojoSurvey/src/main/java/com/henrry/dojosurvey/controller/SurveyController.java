package com.henrry.dojosurvey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SurveyController {
    @RequestMapping(value="/result", method = RequestMethod.POST)
    public String resultSurvey(@RequestParam(value="name") String name,
                               @RequestParam(value="dojo_location") String dojoLocation,
                               @RequestParam(value = "favorite_language") String favoriteLanguage,
                               @RequestParam(value = "comment") String comment, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("dojo_location", dojoLocation);
        model.addAttribute("favorite_language", favoriteLanguage);
        model.addAttribute("comment", comment);
        if(favoriteLanguage.equals("Java")) {
            return "specialPage.jsp";
        } else {
            return "resultSurvey.jsp";
        }
    }
}
