package com.henrry.authentication.controllers;

import com.henrry.authentication.models.User;
import com.henrry.authentication.services.UserService;
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

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registerForm(@ModelAttribute("user") User user) {
        return "users/registrationPage.jsp";
    }
    @GetMapping("/login")
    public String login() {
        return "users/loginPage.jsp";
    }

    @PostMapping("/registration")
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        if(result.hasErrors()) {
            return "users/registrationPage.jsp";
        } else {
            User u = userService.registerUser(user);
            session.setAttribute("idUser", u.getId());
            return "redirect:/home";
        }
        //si el resultado tiene errores, retornar a la página de registro (no se preocupe por las validaciones por ahora)
        //si no, guarde el usuario en la base de datos, guarde el id del usuario en el objeto Session y redirija a /home
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
        boolean isAuthenticated = userService.authenticateUser(email, password);
        if(isAuthenticated) {
            User user = userService.findByEmail(email);
            session.setAttribute("idUser", user.getId());
            return "redirect:/home";
        } else {
            String error = "Datos Incorrectos!";
            model.addAttribute("error", error);
            return "users/loginPage.jsp";
        }
    }

    @GetMapping("/home")
    public String home(HttpSession session, Model model) {
        Long idUser = (Long) session.getAttribute("idUser");
        User user = userService.findUserById(idUser);
        model.addAttribute("user", user);
        return "users/homePage.jsp";
        //Obtener el usuario desde session, guardarlo en el modelo y retornar a la página principal
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
        // invalidar la sesión
        // redireccionar a la página de inicio de sesión.
    }
}
