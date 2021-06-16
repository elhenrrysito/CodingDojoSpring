package com.henrry.lookify.controllers;

import com.henrry.lookify.models.Song;
import com.henrry.lookify.services.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {
    private final SongService songService;

    public HomeController(SongService songService) {
        this.songService = songService;
    }

    @RequestMapping("/")
    public String home() {
        return "index.jsp";
    }

    @RequestMapping("/dashboard")
    public String dashboard(@ModelAttribute("song") Song song, Model model) {
        List<Song> songs = songService.allSongs();
        model.addAttribute("songs", songs);
        return "dashboard.jsp";
    }
}
