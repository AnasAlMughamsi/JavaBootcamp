import java.util.Scanner;

public class PasswordChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter your password: ");
        String password = scanner.next();

        if (checkPassword(password))
            System.out.println("Your Password is valid");
        else
            System.out.println("Your Password is not valid");

    }

    public static boolean checkPassword(String password) {
//        if (checkNumberOfCharacters(password) && checkLettersAndDigits(password))
//            return true;
//        else
//            return false;
        return checkPasswordLength(password) && checkLettersAndDigits(password);
    }

    public static boolean checkPasswordLength(String password) {
//        if (password.length() >= 10) {
//            return true;
//        } else {
//            return false;
//        }
        return password.length() >= 10;
    }

    public static boolean checkLettersAndDigits(String password) {

        boolean flag = true; // password always correct
        int counterNumbers = 0;
        for (int i = 0; i < password.length(); i++) {
            int character = password.charAt(i);
            // numbers
            if (character >= 48 && character <= 57) {
                counterNumbers++;
            } else if (character >= 65 && character <= 90 || character >= 97 && character <= 122) {
                continue;
            } else {
                flag = false;
                break;
            }
        }

        if (!(counterNumbers >= 2)) {
            System.out.println("Your password must at least has 2 numbers");
            flag = false;
        }
        return flag;
    }
}

