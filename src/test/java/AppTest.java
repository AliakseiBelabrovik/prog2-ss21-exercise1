import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @BeforeAll
    public static void init() {
        System.out.println("Testing the application");
    }


    @AfterAll
    public static void finish() {
        System.out.println("Finished testing the application");
    }



    //Kennwort muss zwischen 8 und 25 Zeichen
    //muss mindestens 1 klein- und 1 Großbuchstaben haben
    //muss Zahlen enthalten
    //muss eines der Sonderzeichen enthalten


    @Test
    @DisplayName("Testing the maximum length of 25 characters")
    void testForMaximumLength() {
        assertFalse(App.checkPassword("Password1@TestingMustBeAtLeast25"), "The length of the password " +
                "must be maximum of 25 characters."); //test must return false, because input
        //is 32 characters long
    }

    @Test //test must return false, because input is 7 characters long
    @DisplayName("Testing the minimum length of 8 characters")
    void testForMinimumLength() {
        assertFalse(App.checkPassword("Passw1@"), "The length of the password must be minimum of " +
                "8 characters.");
    }

    @Test //must return false, since there are not lowercase letters
    @DisplayName("Testing the password contains both small and big letters")
    void testForSmallLetters() {
        assertFalse(App.checkPassword("PASSWORD111!"), "The password must contain at least one lowercase letter");
    }


    @Test //must return false, since there are not capital letters
    @DisplayName("Testing the password contains both small and big letters")
    void testForBigLetters() {
        assertFalse(App.checkPassword("password111@"), "The password must contain at least one capital letter");
    }

}
