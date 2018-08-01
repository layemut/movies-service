package tr.com.layemut.moviesservice.controller;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import tr.com.layemut.moviesservice.config.Messages;
import tr.com.layemut.moviesservice.entity.Person;
import tr.com.layemut.moviesservice.entity.Result;
import tr.com.layemut.moviesservice.entity.request.AuthRequest;
import tr.com.layemut.moviesservice.entity.response.PersonAuthResponse;
import tr.com.layemut.moviesservice.entity.response.PersonCreateResponse;
import tr.com.layemut.moviesservice.repository.PersonRepository;

import javax.validation.Valid;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/person")
public class PersonController {

    private static final Logger logger = LoggerFactory.getLogger(PersonController.class);
    private PersonRepository personRepository;
    private Messages messages;

    @Autowired
    public PersonController(PersonRepository personRepository,
                            Messages messages) {
        this.personRepository = personRepository;
        this.messages = messages;
    }

    @PostMapping(value = "/authenticate")
    public ResponseEntity authenticate(@Valid @RequestBody AuthRequest authRequest, Errors errors) {

        logger.info(authRequest.toString());

        PersonAuthResponse personAuthResponse = new PersonAuthResponse();
        Result result = new Result();

        if (errors.hasErrors()) {
            personAuthResponse.setResult(generateResultFromErrors(errors));
            return ResponseEntity.badRequest().body(personAuthResponse);
        }

        Person person = personRepository.findByUserNameAndPassword(authRequest.getUserName(), authRequest.getPassword());

        if (person != null) {
            result.setCode(200);
            result.setMessage(messages.get("success"));
            personAuthResponse.setPerson(person);
            personAuthResponse.setResult(result);

            return ResponseEntity.ok().body(personAuthResponse);
        } else {
            result.setCode(401);
            result.setMessage(messages.get("username_password_not_exists"));

            personAuthResponse.setResult(result);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(personAuthResponse);
        }
    }

    @PostMapping(value = "/create")
    public ResponseEntity create(@Valid @RequestBody Person personRequest, Errors errors) {

        PersonCreateResponse personCreateResponse = new PersonCreateResponse();
        Result result = new Result();

        if (errors.hasErrors()) {
            personCreateResponse.setResult(generateResultFromErrors(errors));

            return ResponseEntity.badRequest().body(personCreateResponse);
        }

        Person duplicatePerson = personRepository.findByUserName(personRequest.getUserName());

        if (duplicatePerson != null) {
            result.setCode(404);
            result.setMessage(messages.get("username_taken"));
            personCreateResponse.setResult(result);
            return ResponseEntity.ok().body(personCreateResponse);
        }

        Person createdPerson = personRepository.insert(personRequest);

        personCreateResponse.setResult(new Result(messages.get("success"), 200));
        personCreateResponse.setPerson(createdPerson);

        return ResponseEntity.ok().body(personCreateResponse);
    }

    @GetMapping("/delete")
    public ResponseEntity delete(@RequestParam("userName") String userName) {

        Long person = personRepository.deleteByUserName(userName);
        Result result = new Result();

        if (person == 1) {
            result.setCode(200);
            result.setMessage(String.format("%s isimli kullanıcı başarı ile silindi.", userName));
        } else {
            result.setCode(404);
            result.setMessage(String.format("%s isimli kullanıcı bulunamadı.", userName));
        }

        return ResponseEntity.status(result.getCode()).body(result);
    }


    private Result generateResultFromErrors(Errors errors) {
        Result result = new Result();
        result.setCode(400);
        result.setMessage(errors.getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining(",")));
        return result;
    }
}
