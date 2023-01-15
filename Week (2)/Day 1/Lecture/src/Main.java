import java.sql.PreparedStatement;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Scanner input = new Scanner(System.in);
        int num1 = input.nextInt();
        int num2 = input.nextInt();

        try {
            division(num1,num2);

        } catch (Exception e) {
            System.out.println("Error !");
        }

        try {
            check(num1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // try - catch
//        try {
//            int num1 = input.nextInt();
//            int num2 = input.nextInt();
//            System.out.println(num1 / num2);
//        } catch (ArithmeticException e) {
//            System.out.println(e.getMessage());
//        }
//        catch (InputMismatchException e) {
//            System.out.println("invalid input, please make sure it is numbers");
//        }
    }

    // throws
    public static int division(int num1, int num2) throws ArithmeticException {
        return num1/num2;
    }

    public static int check(int num) throws Exception {
        if(num <= 0) {
            throw new Exception("Should be bigger then zero");
        }
        return num;
    }
}