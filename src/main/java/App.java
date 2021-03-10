import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {

    public static boolean checkPassword(String password) {

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
        Pattern pattern = Pattern.compile("(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[()#$?!%/@])[\\S&&[\\w[()#$?!%/@]]]{8,25}");
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();



    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please insert the password: ");
        String password = scanner.nextLine();
        System.out.println(password);
        System.out.println(checkPassword(password));
    }
}
