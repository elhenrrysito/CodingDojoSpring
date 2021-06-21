package com.henrry.lookify.controllers;

import com.henrry.lookify.models.Song;
import com.henrry.lookify.services.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class SongController {
    private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @RequestMapping("/song/new")
    public String formNewSong(@ModelAttribute("song") Song song) {
        return "newSong.jsp";
    }

    // crear songs
    @RequestMapping(value = "/song/new", method = RequestMethod.POST)
    public String add(@Valid @ModelAttribute("song") Song song, BindingResult result) {
        if(result.hasErrors()) {
            return "newSong.jsp";
        } else {
            songService.createSong(song);
            return "redirect:/dashboard";
        }
    }

    @RequestMapping("/search/")
    public String searchByArtist(@RequestParam("artist") String artist, Model model) {
        List<Song> songsArtist = songService.allSongsArtist(artist);
        model.addAttribute("songsArtist", songsArtist);
        return "search.jsp";
    }

    @RequestMapping("/song/{id}")
    public String songInformation(@PathVariable("id") Long id, Model model) {
        Song song = songService.findSong(id);
        model.addAttribute("song", song);
        return "songInformation.jsp";
    }

    @RequestMapping(value="/song/{id}", method= RequestMethod.GET)
    public String showSong(@PathVariable("id") Long id, Model model) {
        Song song = songService.findSong(id);
        model.addAttribute("song", song);
        return "songInformation.jsp";
    }

    @RequestMapping(value="/song/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        songService.deleteSong(id);
        return "redirect:/dashboard";
    }

    @RequestMapping(value="/song/search/topten")
    public String topTenSongs(Model model) {
        List<Song> topTenSongs = songService.topTenSongs();
        model.addAttribute("topTenSongs", topTenSongs);
        return "topTenSongs.jsp";
    }

}
