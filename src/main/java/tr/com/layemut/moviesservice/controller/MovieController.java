package tr.com.layemut.moviesservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tr.com.layemut.moviesservice.config.Messages;
import tr.com.layemut.moviesservice.entity.Movie;
import tr.com.layemut.moviesservice.repository.MovieRepository;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private MovieRepository movieRepository;
    private Messages messages;

    @Autowired
    public MovieController(MovieRepository movieRepository, Messages messages) {
        this.movieRepository = movieRepository;
        this.messages = messages;
    }

    @GetMapping
    public ResponseEntity<Boolean> save(Movie movie) {
        movie.setRunTime(messages.get("sample"));
        movieRepository.save(movie);
        return ResponseEntity.ok().build();
    }
}
