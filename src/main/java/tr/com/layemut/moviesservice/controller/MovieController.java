package tr.com.layemut.moviesservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import tr.com.layemut.moviesservice.config.Messages;
import tr.com.layemut.moviesservice.repository.MovieRepository;

@Slf4j
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
    public ResponseEntity<Boolean> save() {
        log.info("save called");
        return ResponseEntity.ok().build();
    }
}
