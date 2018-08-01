package tr.com.layemut.moviesservice.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import tr.com.layemut.moviesservice.entity.Person;

public interface PersonRepository extends MongoRepository<Person, ObjectId> {

    Person findByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password);

    Person findByUserName(@Param("userName") String userName);

    @Query(value = "{userName : ?0}", delete = true)
    Long deleteByUserName(@Param("userName") String userName);
}
