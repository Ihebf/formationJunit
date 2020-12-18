package entites;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PaysTest {

    private Pays pay;
    private List<Person> personList;

    @Before
    public void setUp() throws Exception {
        personList = new ArrayList<>();
        personList.add(new Person(1,new Address("rue1","ville","1"),"nom",9));
        pay = new Pays("Label",
                personList,
                50);
    }

    @After
    public void tearDown() throws Exception {
        pay = null;
        personList = null;
    }

    @Test
    public void testGetLabel(){
        assertTrue("label must be not null and not empty",pay.getLabel() != null && !pay.getLabel().isEmpty());
    }

    @Test
    public void testGetPersonList(){
        assertTrue("Person list must contain at lease 1 person",pay.getPersonList().get(0)!=null);
    }
    @Test
    public void add() {

    }

    @Test
    public void testDelete() {
        int matricule = 1;
        assertTrue("Person not found",pay.delete(matricule));
    }

    @Test
    public void update() {
        Person person = new Person(1,new Address("rue1","ville","1"),"nom",90);
        assertTrue("Person not found", pay.update(person));
    }
}
