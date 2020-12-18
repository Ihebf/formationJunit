package entites;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class AddressTest {

    Address address;
    @Before
    public void setUp() throws Exception {
        address = new Address("rue1","Tunis","22");
    }

    @After
    public void tearDown() throws Exception {
        address = null;
    }

    @Test
    public void getRue() {
        assertTrue("rue null",address.getRue() != null);
    }

    @Test
    public void getVille() {
        String[] villes = {"Tunis","France","USA"};
        assertFalse("ville exception",
                !Arrays.stream(villes).anyMatch(v ->v.toLowerCase().equals(address.getVille().toLowerCase())));
    }


    @Test
    public void getNum() {
        assertTrue("num should be integer",this.isInteger(address.getNum()));
    }

    public boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }
        return true;
    }
}
