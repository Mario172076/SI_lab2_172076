import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SILab2Test {

    private User user = null;
    private User user1 = new User("Mario123", "Test123", "mario@hotmail.com");
    private List<String> createList(String... elems) {
        return new ArrayList<>(Arrays.asList(elems));
    }

    @Test
    void testEveryPath() {

        RuntimeException ex;

        //user null
        // 1 14 15
        ex = assertThrows(RuntimeException.class, () -> new SILab2().function(user1,(createList("Mario1","Laboratoriska2"))));
        assertTrue(ex.getMessage().contains("User null"));
        // user ne  e null ama password i username se null
        // 1 2 14 15
        ex = assertThrows(RuntimeException.class, () -> new SILab2().function(user1,(createList(null, null))));
        assertTrue(ex.getMessage().contains("Password nad username are null"));
        //user ne e null, username i password ne se null ama password e < 8
        // 1 2 3 14 15
        ex = assertThrows(RuntimeException.class, () -> new SILab2().function(user1,(createList("Mario", "doritos"))));
        assertTrue(ex.getMessage().contains("Password.length() < 8"));
        //password bez digit bez upper bez special
        // 1 2 3 4.1 4.2 5 7 9 11 4.3 4.2 12 14 15
        ex = assertThrows(RuntimeException.class, () -> new SILab2().function(user1,(createList("Mario1", "password"))));
        assertTrue(ex.getMessage().contains("Password without digit,upper or special"));
        //password so digit bez upper bez special
        // 1 2 3 4.1 4.2 5 6 7 9 11 4.2 12 14 15
        ex = assertThrows(RuntimeException.class, () -> new SILab2().function(user1,(createList("Mario1", "password1"))));
        assertTrue(ex.getMessage().contains("Password wit digit, without upper or special"));
        //passowrd bez digit so upper bez sepcial
        // 1 2 3 4.1 4.2 5 7 8 9 11 4.2 12 14 15
        ex = assertThrows(RuntimeException.class, () -> new SILab2().function(user1,(createList("Mario1", "Password"))));
        assertTrue(ex.getMessage().contains("Password without digit or special, with upper"));
        //password bez digit bez upper so special
        // 1 2 3 4.1 4.2 5 7 9 10 11 4.2 12 14 15
        ex = assertThrows(RuntimeException.class, () -> new SILab2().function(user1,(createList("Mario1", "password"))));
        assertTrue(ex.getMessage().contains("Password without digit or upper, with special"));
        //password so digit so upper bez special
        // 1 2 3 4.1 4.2 5 6 7 8 9 11 4.2 12 14 15
        ex = assertThrows(RuntimeException.class, () -> new SILab2().function(user1,(createList("Mario1", "Password1"))));
        assertTrue(ex.getMessage().contains("Password with digit and upper, without special"));
        //password so digit bez upper so special
        // 1 2 3 4.1 4.2 5 6 7 9 10 11 4.2 12 14 15
        ex = assertThrows(RuntimeException.class, () -> new SILab2().function(user1,(createList("Mario1", "password1."))));
        assertTrue(ex.getMessage().contains("Password with digit and special, without upper"));
        //password bez digit so upper so special
        // 1 2 3 4.1 4.2 5 7 8 9 10 11 4.2 12 14 15
        ex = assertThrows(RuntimeException.class, () -> new SILab2().function(user1,(createList("Mario1", "Password."))));
        assertTrue(ex.getMessage().contains("Password with upper and special, without digit"));
        //dobar password
        // 1 2 3 4.1 4.2 5 6 7 8 9 10 11 4.2 12 13 15
        assertTrue(new SILab2().function(user1,createList("Mario1","Password1.")));

    }


    @Test
    public void multipleCondition(){

        RuntimeException ex;
        //1.Slucaj koga username != null no pw == null
        ex = assertThrows(RuntimeException.class, () -> new SILab2().function(user1,(createList("Mario1",null))));
        assertTrue(ex.getMessage().contains("Username is good, password is null"));
        //2.Slucaj koga username == null no pw != null
        ex = assertThrows(RuntimeException.class, () -> new SILab2().function(user1,(createList(null,"Password"))));
        assertTrue(ex.getMessage().contains("Username is null, password is good"));
        //3.Slucaj koga username == null i pw == null
        ex = assertThrows(RuntimeException.class, () -> new SILab2().function(user1,(createList(null,null))));
        assertTrue(ex.getMessage().contains("Password and username are both null"));
        //4.Slucaj koga username != null no password.length < 8
        ex = assertThrows(RuntimeException.class, () -> new SILab2().function(user1,(createList("Mario1","PW"))));
        assertTrue(ex.getMessage().contains("Username is good but password.length < 8"));
        //5.Slucaj koga username == null a password.length >=8
        ex = assertThrows(RuntimeException.class, () -> new SILab2().function(user1,(createList(null,"Password"))));
        assertTrue(ex.getMessage().contains("Password.length is >=8 but username is null"));
        //6.Slucaj koga username == null i password < 8
        ex = assertThrows(RuntimeException.class, () -> new SILab2().function(user1,(createList(null, "PW"))));
        assertTrue(ex.getMessage().contains("Username is null and password.length < 8"));
        //7.Slucaj koga password e bez digit bez upper bez special
        ex = assertThrows(RuntimeException.class, () -> new SILab2().function(user1,(createList("Mario1","password"))));
        assertTrue(ex.getMessage().contains("Password has no digit, upper or special"));
        //8.Slucaj koga password e so digit bez upper bez special.
        ex = assertThrows(RuntimeException.class, () -> new SILab2().function(user1,(createList("Mario1","password1"))));
        assertTrue(ex.getMessage().contains("Password has digit but no upper or special"));
        //9.Slucaj koga password e bez digit so upper bez special.
        ex = assertThrows(RuntimeException.class, () -> new SILab2().function(user1,(createList("Mario1","Password"))));
        assertTrue(ex.getMessage().contains("Password has upper, but no digit or special"));
        //10.Slucaj koga password bez digit bez upper so special
        ex = assertThrows(RuntimeException.class, () -> new SILab2().function(user1,(createList("Mario1","password."))));
        assertTrue(ex.getMessage().contains("Password has special, but no upper or digit"));
        //11.Slucaj koga password so digit so upper bez special
        ex = assertThrows(RuntimeException.class, () -> new SILab2().function(user1,(createList("Mario1","Password1"))));
        assertTrue(ex.getMessage().contains("Password has digit and upper, but no special"));
        //12.Slucaj koga password so digit bez upper so special
        ex = assertThrows(RuntimeException.class, () -> new SILab2().function(user1,(createList("Mario1","password1."))));
        assertTrue(ex.getMessage().contains("Password has digit and special but not upper"));
        //13.Slucaj koga password bez digit so upper so special
        ex = assertThrows(RuntimeException.class, () -> new SILab2().function(user1,(createList("Mario1","Password."))));
        assertTrue(ex.getMessage().contains("Password has upper and special, but not digit"));
        //14.Slucaj koga koga imame dobar password
        assertTrue(new SILab2().function(user1,createList("Mario1","Password1.")));


    }


}
