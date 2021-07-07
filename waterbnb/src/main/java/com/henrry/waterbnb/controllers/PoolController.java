package com.henrry.waterbnb.controllers;

import com.henrry.waterbnb.models.Pool;
import com.henrry.waterbnb.models.User;
import com.henrry.waterbnb.services.PoolService;
import com.henrry.waterbnb.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class PoolController {
    private final PoolService poolService;
    private final UserService userService;

    public PoolController(PoolService poolService, UserService userService) {
        this.poolService = poolService;
        this.userService = userService;
    }

    @GetMapping("/host/dashboard")
    public String dashboard(@ModelAttribute("pool") Pool pool, Model model, HttpSession session) {
        if(session.getAttribute("userId") == null) {
            return "redirect:/guest/sigin";
        } else {
            User user = userService.findById((Long) session.getAttribute("userId"));
            if(user.getRol() != 2) {
//            List<Pool> allUserPools = poolService.allUserPools(user);
//            model.addAttribute("poolsbnb", allUserPools);
                model.addAttribute("user", user);
                return "dashboard.jsp";
            } else {
                return "redirect:/guest/sigin";
            }
        }
    }

    @PostMapping("/host/dashboard")
    public String addPool(@Valid @ModelAttribute("pool") Pool pool, Model model, HttpSession session, BindingResult result) {
            User host = userService.findById((Long) session.getAttribute("userId"));
//            List<Pool> allUserPools = poolService.allUserPools(host);
            if(result.hasErrors()) {
//                model.addAttribute("poolsbnb", allUserPools);
                model.addAttribute("user", host);
                return "dashboard.jsp";
            } else {
                pool.setHost(host);
                poolService.create(pool);
                return "redirect:/dashboard";
            }
    }

    @GetMapping("/host/pools/{idPool}")
    public String showPool(@ModelAttribute("pool") Pool pool, @PathVariable("idPool") Long idPool, Model model, HttpSession session) {
        User user = userService.findById((Long) session.getAttribute("userId"));
        if(session.getAttribute("userId") == null || user.getRol() == 2) {
            return "redirect:/guest/sigin";
        } else {
            Pool poolEdit = poolService.findById(idPool);
            model.addAttribute("user", user);
            model.addAttribute("poolEdit", poolEdit);
            return "editPool.jsp";
        }
    }

    @PutMapping("/host/pools/{idPool}")
    public String editPool(@Valid @ModelAttribute("pool") Pool pool, @PathVariable("idPool") Long idPool, Model model, HttpSession session, BindingResult result) {
        User user = userService.findById((Long) session.getAttribute("userId"));
        if(session.getAttribute("userId") == null || user.getRol() == 2) {
            Pool poolEdit = poolService.findById(idPool);
            model.addAttribute("poolEdit", poolEdit);
            return "redirect:/guest/sigin";
        } else {
            Pool poolEdit = poolService.findById(idPool);
            model.addAttribute("poolEdit", poolEdit);
            poolEdit.setDescription(pool.getDescription());
            poolEdit.setSize((pool.getSize()));
            poolEdit.setCost(pool.getCost());
            poolService.update(poolEdit);
            return "editPool.jsp";
        }
    }

}
