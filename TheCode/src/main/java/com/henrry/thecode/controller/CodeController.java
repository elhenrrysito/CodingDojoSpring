package com.henrry.thecode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CodeController {
    @RequestMapping(value = "/code", method = RequestMethod.POST)
    public String ninjaCode(@RequestParam(value = "code") String code, RedirectAttributes redirectAttributes) {
        if(code.equalsIgnoreCase("bushido")) {
            return "code.jsp";
        } else {
            redirectAttributes.addFlashAttribute("error", "You must train harder!");
            return "redirect:/";
        }
    }
}
