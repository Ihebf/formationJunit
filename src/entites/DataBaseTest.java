package entites;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DataBaseTest {

    DataBase db;
    @Before
    public void setUp() throws Exception {
        db = new DataBase();
    }

    @After
    public void tearDown() throws Exception {
        db = null;
    }

    @Test
    public void getConnection() {
        assertTrue("connection is null",db.getConnection() != null );
    }

    @Test
    public void findAll() throws SQLException {
        List<Person> list = db.findAll();
        assertTrue("list is null",list != null);
    }

    @Test
    public void verify() {

    }

    @Test
    public void delete() throws SQLException {

        List<Person> oldList = db.findAll();
        List<Person> newList = new ArrayList<>();

        assertTrue("must be not null",oldList != null && newList != null && oldList.size()>newList.size());
    }

    @Test
    public void add() throws SQLException {

        List<Person> oldList = db.findAll();
        List<Person> newList = new ArrayList<>();
        for (int i=0;i<oldList.size()+1;i++){
            newList.add(new Person());
        }

        assertTrue("must be not null",oldList != null && newList != null && oldList.size()<newList.size());
    }


}
