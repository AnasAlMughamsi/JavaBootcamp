import java.util.Scanner;

public class PasswordChecker {
    public class Main {

        public static Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {


            System.out.println("Please enter your password: ");
            String password = scanner.next();

            if (checkPassword(password))
                System.out.println("Your Password is valid");
            else
                System.out.println("Your Password is not valid");

        }

        public static boolean checkPassword(String password) {

            if (checknumberOfCharacters(password) && checklettersAndDigits(password))
                return true;
            else
                return false;
        }

        public static boolean checknumberOfCharacters(String password) {
            if (password.length() >= 10) {
                return true;
            } else {
                return false;
            }
        }

        public static boolean checklettersAndDigits(String password) {

            boolean flag = true;
            int counterNumbbers = 0;
//        password.matches("[a-z][A-Z][0-9}")
            for (int i = 0; i < password.length(); i++) {
                int character = password.charAt(i);
                // numbers
                if (character >= 48 && character <= 57) {
                    counterNumbbers++;
                } else if (character >= 65 && character <= 90 || character >= 97 && character <= 122) {
                    continue;
                } else {
                    flag = false;
                    break;
                }
            }

            if (!(counterNumbbers >= 2)) {
                flag = false;
            }
            return flag;
        }
    }
}
