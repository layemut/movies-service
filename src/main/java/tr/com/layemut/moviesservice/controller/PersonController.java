package tr.com.layemut.moviesservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
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

    @PostMapping("/authenticate")
    public PersonAuthResponse authenticate(@Valid AuthRequest authRequest, Errors errors) {

        logger.info(authRequest.toString());

        Result result = new Result();

        if (errors.hasErrors()) {
            result.setMessage(errors.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.joining(",")));
            result.setCode(400);

            PersonAuthResponse personAuthResponse = new PersonAuthResponse();
            personAuthResponse.setResult(result);

            return personAuthResponse;
        }

        Person person = personRepository.findByUserNameAndPassword(authRequest.getUserName(), authRequest.getPassword());

        result.setCode(400);
        result.setMessage(messages.get("username_password_not_exists"));

        if (person != null) {
            result.setCode(200);
            result.setMessage(messages.get("success"));
        }

        PersonAuthResponse personAuthResponse = new PersonAuthResponse();
        personAuthResponse.setPerson(person);
        personAuthResponse.setResult(result);

        return personAuthResponse;
    }

    @PostMapping("create")
    public PersonCreateResponse create(@Valid Person personRequest, Errors errors) {

        PersonCreateResponse personCreateResponse = new PersonCreateResponse();
        Result result = new Result();

        if (errors.hasErrors()) {
            result.setMessage(errors.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.joining(",")));
            result.setCode(400);

            personCreateResponse.setResult(result);

            return personCreateResponse;
        }

        Person duplicatePerson = personRepository.findByUserName(personRequest.getUserName());

        if (duplicatePerson != null) {
            result.setCode(404);
            result.setMessage(messages.get("username_taken"));
            personCreateResponse.setResult(result);
            return personCreateResponse;
        }

        Person createdPerson = personRepository.insert(personRequest);

        personCreateResponse.setResult(new Result(messages.get("success"), 200));
        personCreateResponse.setPerson(createdPerson);

        return personCreateResponse;
    }
}
