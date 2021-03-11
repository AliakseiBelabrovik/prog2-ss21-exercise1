import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {


    /**
     * This function checks whether the password String fulfills all the conditions:
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
        try { //if String is null - we expect
            //?= Lookahead assertion
            //?! Negative lookahead
        /*
        \\S - no whitespace characters
        (?=.*[a-z]) - lowercase letters
        (?=.*[A-Z]) - uppercase letters
        (?=.*[0-9]) - numbers
        (?=.*[()#$?!%/@]) - specific characters
        .{8,25} - between 8 and 25
         */

            Pattern pattern = Pattern.compile("(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])" +
                    "(?=.*[()#$?!%/@])[\\S&&[\\w[()#$?!%/@]]]{8,25}");
            Matcher matcher = pattern.matcher(password);
            if (matcher.matches()) { //if matches - check for additional conditions
                char[] charArray = password.toCharArray();
                int[] intArray = new int[charArray.length];
            /*
            for (int i = 0; i < intArray.length; i++) {
                intArray[i] = charArray[i];
            }
            Arrays.sort(intArray);

             */
                //Arrays.sort(charArray);
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
        } catch (NullPointerException exception){
            System.out.println("The password can not be null!");
            return false;
        } catch (RuntimeException exception) {
            System.out.println("Runtime expection");
            return false;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please insert the password: ");
        String password = scanner.nextLine();
        System.out.println(password);
        System.out.println(checkPassword(password));
    }
}
