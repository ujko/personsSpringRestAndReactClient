package pl.ujo.personrest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ujo.personrest.dao.PersonDao;
import pl.ujo.personrest.model.Person;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonDao personDao;

    public List<Person> getAll() {
        return personDao.getAll();
    }

    public Person getById(int personId) {
        return personDao.getById(personId);
    }

    public Person add(Person person) {
        return personDao.addPerson(person);
    }

    public Person modify(int personId, Person person) {
        return personDao.modify(personId, person);
    }

    public Person remove(int personId) {
        return personDao.remove(personId);
    }
}
