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


    /**
     * If parameter is not null -> returns true
     */
    @Test
    @DisplayName("1: Test if the parameter is null")
    void testIfParameterIsNull_Scenario1() {
        assertTrue(App.checkNullObject("NotNull"));
    }
    /**
     * Passes null to the method - > the method must return false
     */
    @Test
    @DisplayName("2: Test if the parameter is null")
    void testIfParameterIsNull_Scenario2() {
        assertFalse(App.checkNullObject(null), "The method must return false, since the " +
                "parameter must not be null");
    }

    /**
     * Tests the correct length of the string
     */
    @Test
    @DisplayName("3: Test the length")
    void testTheLength_Scenario1() {
        assertTrue(App.checkTheLength("PasswordIsLongEnough"), "Password must be between 8 and " +
                "25 characters long!");
    }
    /**
     * Passes a string that is shorter than 8 characters
     */
    @Test
    @DisplayName("4: Test the length")
    void testTheLength_Scenario2() {
        assertFalse(App.checkTheLength("Short"), "Password too short");
    }
    /**
     * Passes a string that is longer than 25 characters
     */
    @Test
    @DisplayName("5: Test the length")
    void testTheLength_Scenario3() {
        assertFalse(App.checkTheLength("PasswordIsToooooooooooooooLong"), "Password too long");
    }

    /**
     * Passes only lowercase characters. Must return false.
     */
    @Test
    @DisplayName("6: Test lower and upper characters")
    void testUpperLowerCaseCharacters_Scenario1() {
        assertFalse(App.checkUpperCaseAndLowerCaseCharacters("password12354%:"), "Password must " +
                "contain at least one uppercase character!");
    }

    /**
     * Passes only uppercase characters. Should return false.
     */
    @Test
    @DisplayName("7: Test lower and upper characters")
    void testUpperLowerCaseCharacters_Scenario2() {
        assertFalse(App.checkUpperCaseAndLowerCaseCharacters("PASSWORD123&5"), "Password must " +
                "contain at least one lowercase character!");
    }

    /**
     * Passes no letters. Should return false
     */
    @Test
    @DisplayName("8: Test lower and upper characters")
    void testUpperLowerCaseCharacters_Scenario3() {
        assertFalse(App.checkUpperCaseAndLowerCaseCharacters("5234242341231%%@@@"), "Password must" +
                " contain a least one lowercase and one uppercase character");
    }
    /**
     * Passes both uppercase and lowercase characters. Should return true.
     */
    @Test
    @DisplayName("9: Test lower and upper characters")
    void testUpperLowerCaseCharacters_Scenario4() {
        assertTrue(App.checkUpperCaseAndLowerCaseCharacters("PasswordIsLongEnough"));
    }

    /**
     * Passes a string without numbers. Should return false.
     */
    @Test
    @DisplayName("10: Testing the password contains at least one number")
    void testNumbers_Scenario1() {
        assertFalse(App.checkNumbers("ThePassword%"), "The password must contain at least one number. " +
                "The method must return false.");
    }
    /**
     * Passes a string with only numbers. Should return true.
     */
    @Test
    @DisplayName("11: Testing the password contains at least one number")
    void testNumbers_Scenario2() {
        assertTrue(App.checkNumbers("555555555555555"));
    }

    /**
     * Passes a string with allowed and forbidden special characters. Must return false.
     */
    @Test
    @DisplayName("12: Testing the password contains only allowed special characters")
    void testSpecialCharacters_Scenario1() {
        assertFalse(App.checkSpecificCharacters("():#$?!%/@kA125"), "The password should" +
                " not contain forbidden special characters!");
    }
    /**
     * Passes a string with forbidden special characters. Must return false.
     */
    @Test
    @DisplayName("13: Testing the password contains only allowed special characters")
    void testSpecialCharacters_Scenario2() {
        assertFalse(App.checkSpecificCharacters("Passwo]586"), "The password should" +
                " not contain not allowed special characters and contain at least one ()#$?!%/@!");
    }
    /**
     * Passes a string with allowed special characters. Must return true.
     */
    @Test
    @DisplayName("14: Testing the password contains only allowed special characters")
    void testSpecialCharacters_Scenario3() {
        assertTrue(App.checkSpecificCharacters("ThePassword%"));
    }
    /**
     * Passes a string with four same letters. Must return true, since A is not a number.
     */
    @Test
    @DisplayName("15: Testing the password doesn't contain 4 same numbers in a row")
    void testFourNumbersInARow_Scenario1() {
        assertTrue(App.checkFourNumbersInARow("AAAApasswr%12"));
    }
    /**
     * Passes a string with four same letters. Must return false, since 9999 is not allowed.
     */
    @Test
    @DisplayName("16: Testing the password doesn't contain 4 same numbers in a row")
    void testFourNumbersInARow_Scenario2() {
        assertFalse(App.checkFourNumbersInARow("AAAA9999passwr%12"), "Es darf nicht eine Zahl" +
                " öfters als 3-mal hintereinander kommen z.B. 1111 ist nicht erlaubt");
    }
    /**
     * Passes a string with 3 consecutive numbers. Must return false, since 678 is not allowed.
     */
    @Test
    @DisplayName("17: Testing the password doesn't contain consecutive numbers")
    void testConsecutiveNumbers_Scenario1() {
        assertFalse(App.checkConsecutiveNumbers("AAA678Apasswr%12"));
    }




    /**
     * From now on there are only tests for the big method "checkPassword", which checks all the
     * prerequisites at a time and return true only if all the prerequisites are fulfilled.
     * This method is somehow a sum of all other checking methods
     */
    @Test
    @DisplayName("18: Test for correct password.")
    void testForCorrectPassword() {
        assertTrue(App.checkPassword("/@Pasd111%!"), "The password @Pasd111%! is an allowed password. " +
                "Check the method again.");
    }

    @Test
    @DisplayName("19: Testing the maximum length of 25 characters")
    void testForMaximumLength() {
        assertFalse(App.checkPassword("Password1@TestingMustBeAtLeast25"), "The length of the password " +
                "must be maximum of 25 characters. The method must return false."); //method must return false,
        // because input is 32 characters long
    }

    @Test //method must return false, because input is 7 characters long
    @DisplayName("20: Testing the minimum length of 8 characters")
    void testForMinimumLength() {
        assertFalse(App.checkPassword("Passw1@"), "The length of the password must be minimum of " +
                "8 characters. The method must return false.");
    }

    @Test //must return false, since there are not lowercase letters
    @DisplayName("21: Testing the password contains both small letters.")
    void testForSmallLetters() {
        assertFalse(App.checkPassword("PASSWORD111!"), "The password must contain at least one lowercase " +
                "letter. The method must return false.");
    }


    @Test
    @DisplayName("22: Testing the password contains both small and big letters")
    void testForBigLetters() {
        assertFalse(App.checkPassword("password111@"), "The password must contain at least one capital " +
                "letter. The method must return false.");
    }

    @Test
    @DisplayName("23: Testing the password contains at least one number")
    void testForNumber() {
        assertFalse(App.checkPassword("ThePassword%"), "The password must contain at least one number. " +
                "The method must return false.");
    }


    @Test // Special characters a. ASCII value (- 40 ) - 41 # - 35 $ -36 ? -63 ! - 33 % - 37 / -47 @ - 64
    @DisplayName("24: Testing for not allowed special characters")
    void testForSpecialCharacters() {
        assertFalse(App.checkPassword("Pasd111:" + specificCharacter), "The method must return false if " +
                "not allowed specific characters are used." + specificCharacter);
    }
    @Test
    @DisplayName("25: Testing for special characters")
    void testForSpecialCharacters_Scenario2() {
        assertTrue(App.checkPassword("()$?!%/Pas!w@ord1#" + specificCharacter), "The method must allow the " +
                "following specific characters: ()#$?!%/@");
    }

    @Test
    @DisplayName("26: Testing white spaces")
    void testForWhiteSpaces() {
        assertFalse(App.checkPassword("()$?!% /Pas!w@ord1#"), "The method must return false, because " +
                "no whitespaces are allowed");
    }


    @Test
    @DisplayName("27: Testing for 3 consecutive numbers 1")
    void testForConsecutiveNumbers_Scenario1() {
        assertFalse(App.checkPassword("678Testing!"), "The method must return false.");
    }


    @Test
    @DisplayName("28: Testing for 3 consecutive numbers 2")
    void testForConsecutiveNumbers_Scenario2() {
        assertTrue(App.checkPassword("134@abcKPass"));
    }

    @Test
    @DisplayName("29: Testing for four numbers in a row 1")
    void testForMaxThreeNumbers_Scenario1() {
        assertFalse(App.checkPassword("1111Pass%ord"));
    }

    @Test
    @DisplayName("30: Testing for four numbers in a row 2")
    void testForMaxThreeNumbers_Scenario2() {
        assertTrue(App.checkPassword("111AAAA%%%%aaaa"));
    }

    @Test
    @DisplayName("31: Test for NullPointerException")
    void testForNullPointerException() {
        assertFalse(App.checkPassword(null), "NullObjectNotAllowed");
    }

    @Test
    @DisplayName("32: Test for correct Password 2")
    void testForCorrectPassword_Scenario2() {
        assertTrue(App.checkPassword("AbC777XXX%%%/"));
    }


}
