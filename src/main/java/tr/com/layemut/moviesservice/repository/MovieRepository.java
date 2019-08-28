package tr.com.layemut.moviesservice.repository;

import org.springframework.data.repository.CrudRepository;

import tr.com.layemut.moviesservice.entity.Movie;

public interface MovieRepository extends CrudRepository<Movie, Long> {

}
