import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * GitHub URL: https://github.com/AliakseiBelabrovik/prog2-ss21-exercise1.git
 * This class contains the methods for checking the contents of the string passed
 * to the respective method. At the beginning there is one method per prerequisite
 * (e.g. one method for numbers, one method for special characters, one method for null object, etc).
 * After that there is one big method "checkPassword" which checks all prerequisites at the same time
 * and returns true only if all prerequisites are fulfilled at the same time.
 *
 */



public class App {


    /**
     * This methods checks whether the parameter is null. If yes, it returns false.
     * @param password String parameter that must be checked
     * @return Returns true only if String parameter is not null
     */
    public static boolean checkNullObject(String password) {
        try {
            boolean check = password.equals(null);
        } catch (NullPointerException exception) {
            System.out.println("The password can not be null!");
            return false;
        }
        return true;
    }

    /**
     *  This method checks if there is at least one allowed specific character ()#$?!%/@ and there is
     *  no other specific characters
     * @param password String parameter that must be checked
     * @return Returns true only if at least one allowed specific character and no other specific characters
     */
    public static boolean checkSpecificCharacters(String password) {
        Pattern pattern = Pattern.compile(
                "^(?=.*[()#$?!%/@])[\\S&&[\\w[()#$?!%/@]]]{0,}$");
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    /**
     * This method checks whether the String contains at least one number
     * @param password String parameter that must be checked
     * @return Returns true only if the condition is fulfilled
     */
    public static boolean checkNumbers(String password) {
        Pattern pattern = Pattern.compile("^(?=.*[0-9]).{0,}$");
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    /**
     * This method checks the conditions that the String must contain at least one
     * uppdercase letter and one lowercase letter
     * @param password String parameter that must be checked
     * @return Returns true only if the condition is fulfilled
     */
    public static boolean checkUpperCaseAndLowerCaseCharacters(String password) {
        Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z]).{0,}$");
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    /**
     * This method checks whether the length conditions is fulfilled
     * @param password String parameter that must be checked
     * @return Returns true only if length of the String is between 8 and 25, otherwise false
     */
    public static boolean checkTheLength(String password) {
        if (password.length() < 8 || password.length() > 25) {
            return false;
        }
        return true;
    }

    /**
     * This method checks whether there are more than 2 consecutive Numbers in a row (e.g. 123 or 456)
     * @param password String parameter that must be checked
     * @return Returns true only if no 3 consecutive numbers, otherwise false
     */
    public static boolean checkConsecutiveNumbers(String password) {
        char[] charArray = password.toCharArray();
        int[] intArray = new int[charArray.length];
        for (int i = 0; i < intArray.length - 3; i++) {
            if (charArray[i] >= 48 && charArray[i] <= 57) { //if a number 0-9
                if ((charArray[i] == charArray[i + 1]) && (charArray[i + 1] == charArray[i + 2])
                        && (charArray[i + 2] == charArray[i + 3])) {
                    System.out.println("Es darf nicht eine Zahl öfters als 3-mal hintereinander kommen " +
                            "z.B. 1111 ist nicht erlaubt");
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * This method checks whether there are more than 3 same numbers in a row (e.g. 1111)
     * @param password String parameter that must be checked
     * @return Returns true only if maximum 3 same numbers in a row, otherwise false
     */
    public static boolean checkFourNumbersInARow(String password) {
        char[] charArray = password.toCharArray();
        int[] intArray = new int[charArray.length];
        for (int i = 0; i < intArray.length - 2; i++) {
            if (charArray[i] >= 48 && charArray[i] <= 57) { //if a number 0-9
                if ((charArray[i] == charArray[i + 1] - 1) && (charArray[i + 1] == charArray[i + 2] - 1)) {
                    System.out.println("Wenn Zahlen enthalten sind dürfen nicht mehr als zwei Zahlen fortlaufend sein z.B. " +
                            "123 oder 456 sind nicht erlaubt.");
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * This method checks whether the password String fulfills all the conditions:
     * 1. the minimum and maximum length of 8 and 25 characters respectively
     * 2. at least one uppercase and lowercase character
     * 3. at least one number
     * 4. only the following specific characters are allowed: ()#$?!%/@
     * The above mentioned conditions are checked with regex
     * 6. 7. Additional conditions such as consecutive numbers and maximum 3 numbers in a row
     * are checked with the help of char arrays and for loops, using ASCII values
     *
     * @param password String parameter that must be checked for different conditions
     * @return Returns true only if all the conditions are fulfilled, otherwise or if a
     * NullPointerException or a RunTimeException is thrown returns false
     */
    public static boolean checkPassword(String password) {

        //if String is null or any RunTimeException is thrown -> catch it and return false
        try {

            Pattern pattern = Pattern.compile("(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])" +
                    "(?=.*[()#$?!%/@])[\\S&&[\\w[()#$?!%/@]]]{8,25}");
            Matcher matcher = pattern.matcher(password);
            if (matcher.matches()) { //if matches - check for additional conditions
                char[] charArray = password.toCharArray();
                int[] intArray = new int[charArray.length];

                //check for more than 3 same numbers in a row
                for (int i = 0; i < intArray.length - 3; i++) {
                    if (charArray[i] >= 48 && charArray[i] <= 57) { //if a number 0-9
                        if ((charArray[i] == charArray[i + 1]) && (charArray[i + 1] == charArray[i + 2])
                                && (charArray[i + 2] == charArray[i + 3])) {
                            System.out.println("Es darf nicht eine Zahl öfters als 3-mal hintereinander kommen " +
                                    "z.B. 1111 ist nicht erlaubt");
                            return false;
                        }
                    }
                }
                //check for consecutive numbers
                for (int i = 0; i < intArray.length - 2; i++) {
                    if (charArray[i] >= 48 && charArray[i] <= 57) { //if a number 0-9
                        if ((charArray[i] == charArray[i + 1] - 1) && (charArray[i + 1] == charArray[i + 2] - 1)) {
                            System.out.println("Wenn Zahlen enthalten sind dürfen nicht mehr als zwei Zahlen fortlaufend sein z.B. " +
                                    "123 oder 456 sind nicht erlaubt.");
                            return false;
                        }
                    }
                }
                //return true only if all the conditions are fulfilled at the same time
                return true;


            }
            //catch NullPointerException and return false
        } catch (NullPointerException exception){
            System.out.println("The password can not be null!");
            return false;
            //catch RunTimeException and return false
        } catch (RuntimeException exception) {
            System.out.println("Runtime expection");
            return false;
        }
        //return else false
        return false;
    }
}
