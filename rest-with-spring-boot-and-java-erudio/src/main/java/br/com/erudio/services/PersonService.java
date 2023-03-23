package br.com.erudio.services;

import br.com.erudio.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public List<Person> findAll() {

        logger.info("Finding all people.");
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Anderson " + i);
        person.setLasttName("Peretto " + i);
        person.setAddress("Av. Brasil 144 " + i);
        person.setGender("Masculino " + i);

        return person;
    }

    public Person findById(String id) {

        logger.info("Finding one Person.");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Anderson");
        person.setLasttName("Peretto");
        person.setAddress("Av. Brasil 144");
        person.setGender("Masculino");

        return person;
    }
}
