import org.junit.jupiter.api.*;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * GitHub URL: https://github.com/AliakseiBelabrovik/prog2-ss21-exercise1.git
 * Test class for testing the checkPassword method in App.java that returns a boolean value
 * The class contains a static char variable to generate a random specific character and test for this
 */
public class AppTest {

    //static variable for generating specific character to test
    static char specificCharacter;


    /**
     * Prints "Testing the application" at the beginning
     * Generates a random specific character (one of ()#$?!%/@) to use in test 7 and 8 for testing
     * for specific characters
     */
    @BeforeAll
    public static void init() {
        System.out.println("Testing the application");

        Random random = new Random();
        while (true) {
            int valueOfChar = random.nextInt(64 - 33 + 1) + 33;
            if (valueOfChar == 33 || (valueOfChar >= 35 && valueOfChar <= 37) || valueOfChar == 40 || valueOfChar == 41
                    || valueOfChar == 47 || valueOfChar == 63 || valueOfChar == 64) {
                specificCharacter = (char) valueOfChar;
                break;
            }
        }
        // Special characters a. ASCII value (- 40 ) - 41 # - 35 $ -36 ? -63 ! - 33 % - 37 / -47 @ - 64
    }


    /**
     * Prints "Finished testing the application" at the end
     */
    @AfterAll
    public static void finish() {
        System.out.println("Finished testing the application");
    }

    @Test
    @DisplayName("1: Test for correct password.")
    void testForCorrectPassword() {
        assertTrue(App.checkPassword("/@Pasd111%!"), "The password @Pasd111%! is an allowed password. " +
                "Check the method again.");
    }

    @Test
    @DisplayName("2: Testing the maximum length of 25 characters")
    void testForMaximumLength() {
        assertFalse(App.checkPassword("Password1@TestingMustBeAtLeast25"), "The length of the password " +
                "must be maximum of 25 characters. The method must return false."); //method must return false,
        // because input is 32 characters long
    }

    @Test //method must return false, because input is 7 characters long
    @DisplayName("3: Testing the minimum length of 8 characters")
    void testForMinimumLength() {
        assertFalse(App.checkPassword("Passw1@"), "The length of the password must be minimum of " +
                "8 characters. The method must return false.");
    }

    @Test //must return false, since there are not lowercase letters
    @DisplayName("4: Testing the password contains both small letters.")
    void testForSmallLetters() {
        assertFalse(App.checkPassword("PASSWORD111!"), "The password must contain at least one lowercase " +
                "letter. The method must return false.");
    }


    @Test
    @DisplayName("5: Testing the password contains both small and big letters")
    void testForBigLetters() {
        assertFalse(App.checkPassword("password111@"), "The password must contain at least one capital " +
                "letter. The method must return false.");
    }

    @Test
    @DisplayName("6: Testing the password contains at least one number")
    void testForNumber() {
        assertFalse(App.checkPassword("ThePassword%"), "The password must contain at least one number. " +
                "The method must return false.");
    }


    @Test // Special characters a. ASCII value (- 40 ) - 41 # - 35 $ -36 ? -63 ! - 33 % - 37 / -47 @ - 64
    @DisplayName("7: Testing for not allowed special characters")
    void testForSpecialCharacters() {
        assertFalse(App.checkPassword("Pasd111:" + specificCharacter), "The method must return false if " +
                "not allowed specific characters are used." + specificCharacter);
    }
    @Test
    @DisplayName("8: Testing for special characters")
    void testForSpecialCharacters_Scenario2() {
        assertTrue(App.checkPassword("()$?!%/Pas!w@ord1#" + specificCharacter), "The method must allow the " +
                "following specific characters: ()#$?!%/@");
    }

    @Test
    @DisplayName("9: Testing white spaces")
    void testForWhiteSpaces() {
        assertFalse(App.checkPassword("()$?!% /Pas!w@ord1#"), "The method must return false, because " +
                "no whitespaces are allowed");
    }


    @Test
    @DisplayName("10: Testing for 3 consecutive numbers 1")
    void testForConsecutiveNumbers_Scenario1() {
        assertFalse(App.checkPassword("678Testing!"), "The method must return false.");
    }


    @Test
    @DisplayName("11: Testing for 3 consecutive numbers 2")
    void testForConsecutiveNumbers_Scenario2() {
        assertTrue(App.checkPassword("134@abcKPass"));
    }

    @Test
    @DisplayName("12: Testing for four numbers in a row 1")
    void testForMaxThreeNumbers_Scenario1() {
        assertFalse(App.checkPassword("1111Pass%ord"));
    }

    @Test
    @DisplayName("13: Testing for four numbers in a row 2")
    void testForMaxThreeNumbers_Scenario2() {
        assertTrue(App.checkPassword("111AAAA%%%%aaaa"));
    }

    @Test
    @DisplayName("14: Test for NullPointerException")
    void testForNullPointerException() {
        assertFalse(App.checkPassword(null), "NullObjectNotAllowed");
    }

    @Test
    @DisplayName("15: Test for correct Password 2")
    void testForCorrectPassword_Scenario2() {
        assertTrue(App.checkPassword("AbC777XXX%%%/"));
    }


}
