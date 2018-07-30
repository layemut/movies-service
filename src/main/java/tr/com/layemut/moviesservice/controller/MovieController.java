package tr.com.layemut.moviesservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.layemut.moviesservice.config.Messages;
import tr.com.layemut.moviesservice.repository.MovieRepository;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private static final Logger logger = LoggerFactory.getLogger(MovieController.class);
    private MovieRepository movieRepository;
    private Messages messages;

    @Autowired
    public MovieController(MovieRepository movieRepository, Messages messages) {
        this.movieRepository = movieRepository;
        this.messages = messages;
    }

    @GetMapping
    public ResponseEntity save() {
        return ResponseEntity.ok().build();
    }
}
