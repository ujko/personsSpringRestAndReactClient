package pl.ujo.personrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.ujo.personrest.dao.PersonDao;

@Component
public class PersonRestRunner implements CommandLineRunner {

    @Autowired
    PersonDao personDao;

    @Override
    public void run(String... args) throws Exception {
//        personDao.getAll().forEach(System.out::println);
    }
}
