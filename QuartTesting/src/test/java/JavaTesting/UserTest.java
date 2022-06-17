package JavaTesting;

import DomainEntities.User;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserTest {

    @Test
    public void constructUserTest(){
        User usuari = new User("Tomeu","secret");

        assertTrue(usuari != null);

        assertEquals(usuari.getName(),"Tomeu");
        //assertEquals(usuari.getPassword(),"secret");

        assertTrue(usuari.verifyPassword("secret"));
    }
}
