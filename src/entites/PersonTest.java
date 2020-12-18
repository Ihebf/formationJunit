package entites;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {

    Person person;
    @Before
    public void setUp() throws Exception {
        person = new Person(1,new Address("rue1","ville","1"),"nom",9);
    }

    @After
    public void tearDown() throws Exception {
        person = null;
    }

    @Test
    public void getMatricule() {
        assertTrue("matricule>=1",person.getMatricule()>=1);
    }

    @Test
    public void getAddress() {
        assertTrue("address is null",person.getAddress() != null);
    }

    @Test
    public void getNom() {
        assertTrue("name is null",person.getNom() != null);

    }

    @Test
    public void getAge() {
        assertTrue("age mush higher or equal than 10 and less than 100",person.getAge()>=10
                && person.getAge()<=99);
    }
}
