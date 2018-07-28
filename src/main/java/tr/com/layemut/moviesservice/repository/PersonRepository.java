package tr.com.layemut.moviesservice.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tr.com.layemut.moviesservice.entity.Person;

@RepositoryRestResource(collectionResourceRel = "person", path = "person")
public interface PersonRepository extends MongoRepository<Person, ObjectId> {

    Person findByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password);

    Person findByUserName(@Param("userName") String userName);
}
