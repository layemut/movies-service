package tr.com.layemut.moviesservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import tr.com.layemut.moviesservice.entity.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

    Person findByUserNameAndPassword(String userName, String password);

    Person findByUserName(String userName);

    @Transactional
    long deleteByUserName(String userName);
}
