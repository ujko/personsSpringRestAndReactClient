package pl.ujo.personrest.restService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.ujo.personrest.model.Person;
import pl.ujo.personrest.service.PersonService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class PersonRest {

    @Autowired
    PersonService personService;


    @GetMapping("all")
    public List<Person> getAll() {
        return personService.getAll();
    }

    @GetMapping("/person")
    public Person getByPersonId(@RequestParam("id") int personId) {
        return personService.getById(personId);
    }
}
