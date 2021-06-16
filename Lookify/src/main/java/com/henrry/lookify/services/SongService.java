package com.henrry.lookify.services;

import com.henrry.lookify.models.Song;
import com.henrry.lookify.repositories.SongRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {
    private final SongRepository songRepository;

  

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public List<Song> allSongs() {
        return songRepository.findAll();
    }

    public List<Song> allSongsArtist(String artist) {
        return songRepository.findByArtistContaining(artist);
    }

    public List<Song> topTenSongs() {
        return songRepository.findTop10ByOrderByRatingDesc();
    }

    public Song createSong(Song s) {
        return songRepository.save(s);
    }

    public Song findSong(Long id) {
        Optional<Song> optionalSong = songRepository.findById(id);
        if(optionalSong.isPresent()) {
            return optionalSong.get();
        } else {
            return null;
        }
    }

    public Song updateSong(Song song) {
        return songRepository.save(song);
    }

    public void deleteSong(Long id) {
        songRepository.deleteById(id);
    }
}
