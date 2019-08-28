package tr.com.layemut.moviesservice.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tr.com.layemut.moviesservice.entity.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

    Person findByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password);

    Person findByUserName(@Param("userName") String userName);

    Long deleteByUserName(@Param("userName") String userName);
}
