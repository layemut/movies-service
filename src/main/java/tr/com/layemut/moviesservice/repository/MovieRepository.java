package tr.com.layemut.moviesservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tr.com.layemut.moviesservice.entity.Movie;

public interface MovieRepository extends MongoRepository<Movie, Long> {

}
