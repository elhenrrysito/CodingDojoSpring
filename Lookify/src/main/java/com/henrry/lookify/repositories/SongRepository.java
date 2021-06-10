package com.henrry.lookify.repositories;

import com.henrry.lookify.models.Song;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> {
    // Este método recupera todos las canciones de la base de datos
    List<Song> findAll();
    //Este método encuentra una cancion por su nombre
    List<Song> findByTitleContaining(String search);
    //Este método encuentra una cancion por su artista
    List<Song> finByArtistContaining(String search);
    //Este método borra una canción que empieza con un titulo específico
    Long deleteByTitleStartingWith(String search);

}
