package pl.ujo.personrest.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pl.ujo.personrest.model.Person;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PersonDao {
    @Value("${persons.limit}")
    private int personLimit;

    private Map<Integer, Person> personMap;

    @PostConstruct
    private void init() {
        try {
            getPersons();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getPersons() throws IOException {
        personMap = new HashMap<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        Files
                .lines(Path.of("persons.csv"))
                .map(x -> x.split(","))
                .map(x -> new Person(x[0], x[1], LocalDate.parse(x[2], formatter), Double.parseDouble(x[3])))
                .limit(personLimit)
                .forEach(this::addPerson);
    }

    public List<Person> getAll() {
        return new ArrayList<>(personMap.values());
    }


    public Person addPerson(Person person) {
        person.setId(generateId());
        personMap.put(person.getId(), person);
        return person;
    }

    private int generateId() {
        int maxId = personMap.keySet().stream().mapToInt(x -> x).max().orElse(0);
        return maxId + 1;
    }

    public Person getById(int personId) {
        return personMap.get(personId);
    }

    public Person remove(int personId) {
        return personMap.remove(personId);
    }

    public Person modify(int personId, Person person) {
        person.setId(personId);
        personMap.put(personId, person);
        return person;
    }
}
