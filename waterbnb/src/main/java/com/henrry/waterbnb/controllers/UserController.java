package com.henrry.waterbnb.controllers;

import com.henrry.waterbnb.models.User;
import com.henrry.waterbnb.services.UserService;
import com.henrry.waterbnb.validator.UserValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class UserController {
    private final UserService userService;
    private final UserValidator userValidator;

    public UserController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }

    @GetMapping("/guest/sigin")
    public String registerLogin(@ModelAttribute("user") User user, HttpSession session) {
        if(session.getAttribute("userId") == null) {
            return "users/registrationLogin.jsp";
        } else {
            return "redirect:/host/dashboard";
        }
    }

    @PostMapping("/register")
    public String registerAndLogin(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session, Model model) {
        userValidator.validate(user, result);
        if(result.hasErrors()) {
            return "users/registrationLogin.jsp";
        } else {
            User u = userService.registerUser(user);
            session.setAttribute("userId", u.getId());
            return "redirect:/host/dashboard";
        }
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user,
                        @RequestParam("email") String email,
                        @RequestParam("password") String password, Model model, HttpSession session) {
        boolean isAuthenticated = userService.authenticateUser(email, password);
        if(isAuthenticated) {
            User userLog = userService.findByEmail(email);
            session.setAttribute("userId", userLog.getId());
            return "redirect:/host/dashboard";
        } else {
            String error = "Datos incorrectos";
            model.addAttribute("error", error);
            return "index.jsp";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

}
