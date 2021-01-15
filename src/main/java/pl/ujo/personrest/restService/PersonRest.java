package pl.ujo.personrest.restService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @DeleteMapping("/person/del/{id}")
    public Person deletePerson(@PathVariable("id") int personId) {
        System.out.println("Kasuję person " + personId);
        return personService.remove(personId);
    }
}
