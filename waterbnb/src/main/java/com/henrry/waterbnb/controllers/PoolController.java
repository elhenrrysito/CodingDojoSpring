package com.henrry.waterbnb.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.henrry.waterbnb.models.Pool;
import com.henrry.waterbnb.models.Review;
import com.henrry.waterbnb.models.User;
import com.henrry.waterbnb.services.PoolService;
import com.henrry.waterbnb.services.ReviewService;
import com.henrry.waterbnb.services.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PoolController {
    private final PoolService poolService;
    private final UserService userService;
    private final ReviewService reviewService;


    public PoolController(PoolService poolService, UserService userService, ReviewService reviewService) {
        this.poolService = poolService;
        this.userService = userService;
        this.reviewService = reviewService;
    }

    @GetMapping("/")
    public String home() {
        return "home.jsp";
    }

    @GetMapping("/search")
    public String searchPool(@RequestParam("location") String location, Model model, HttpSession session) {
        List<Pool> poolLocation = poolService.poolByAddress(location);
        Long idUser = (Long) session.getAttribute("userId");
        model.addAttribute("user", idUser);
        model.addAttribute("poolsLocation", poolLocation);
        return "resultLocation.jsp";
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
                return "redirect:/";
            }
        }
    }

    @PostMapping("/host/dashboard")
    public String addPool(@Valid @ModelAttribute("pool") Pool pool, BindingResult result, Model model, HttpSession session) {
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

    @GetMapping("/pools/{idPool}")
    public String showPool(@PathVariable("idPool") Long idPool, Model model, HttpSession session) {
        Pool pool = poolService.findById(idPool);
        Long idUser = (Long) session.getAttribute("userId");
        model.addAttribute("user", idUser);
        model.addAttribute("pool", pool);
        return "showPool.jsp";
    }

    @GetMapping("/pools/{idPool}/review")
    public String poolReview(@PathVariable("idPool") Long idPool, @ModelAttribute("review") Review review, Model model, HttpSession session) {
        if(session.getAttribute("userId") == null) {
            return "redirect:/guest/sigin";
        } else {
            Long idUser = (Long) session.getAttribute("userId");
            User user = userService.findById(idUser);
            Pool pool = poolService.findById(idPool);
            if(user.getId() == pool.getHost().getId()) {
                return "redirect:/host/dashboard";
            } else {
                model.addAttribute("pool", pool);
                return "addReview.jsp";
            }
        }
    }

    @PostMapping("/pools/{idPool}/review")
    public String addReview(@PathVariable("idPool") Long idPool, @Valid @ModelAttribute("review") Review review, BindingResult result,
                            Model model, HttpSession session ) {
        Long idUser = (Long) session.getAttribute("userId");
        Pool pool = poolService.findById(idPool);
        User userReview = userService.findById(idUser);
        if(result.hasErrors()) {
            model.addAttribute("pool", pool);
            return "addReview.jsp";
        } else {
            review.setPool(pool);
            review.setUser(userReview);
            reviewService.create(review);
        }
        
        return "redirect:/pools/" + idPool;
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
    public String editPool(@Valid @ModelAttribute("pool") Pool pool, BindingResult result, 
                            @PathVariable("idPool") Long idPool, @RequestParam("description") String description,
                            Model model, HttpSession session) {
        User user = userService.findById((Long) session.getAttribute("userId"));
        if(session.getAttribute("userId") == null || user.getRol() == 2) {
            return "redirect:/guest/sigin";
        } else {
            Pool poolEdit = poolService.findById(idPool);
            if(result.hasErrors()) {
                model.addAttribute("poolEdit", poolEdit);
                return "editPool.jsp";
            } else {
                model.addAttribute("poolEdit", poolEdit);
                poolEdit.setDescription(description);
                poolEdit.setSize((pool.getSize()));
                poolEdit.setCost(pool.getCost());
                poolService.update(poolEdit);

                return "editPool.jsp";
            }
        }
    }

}
