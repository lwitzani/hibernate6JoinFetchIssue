package com.example.springboot.persistence;

import com.example.springboot.SpringBootTestApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = SpringBootTestApplication.class)
public class PersonPersistenceTest {

    @Autowired
    PersonRepository personRepository;

    @BeforeEach
    void cleanUp() {
        personRepository.deleteAll();
    }

    @Test
    void shouldJoinFetchTheNestedEntitiesOfLegs() {
        Person person = new Person();
        person.setName("initialName");
        person.getLegs().add(new Leg("left leg", person, new NestedEntity("nested in left leg")));
        Person savedPerson = personRepository.save(person);

        final Person foundPerson = personRepository.findByIdJoinFetchLegsWithNestedEntity(person.getId());
        assertEquals(foundPerson.getId(), savedPerson.getId());
        assertNotNull(person.getLegs());
        assertEquals(1, person.getLegs().size());

        assertDoesNotThrow(() -> foundPerson.getLegs().iterator().next().getNestedEntity().getName());
        assertEquals("nested in left leg", foundPerson.getLegs().iterator().next().getNestedEntity().getName());
    }
}
