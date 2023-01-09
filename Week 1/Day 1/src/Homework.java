import java.util.Scanner;

public class Homework {
    public static void main(String[] args) {
        // Q1. Arithmetic Operations
        Scanner input = new Scanner(System.in);
        int firstNumber;
        int secondNumber;
        System.out.println("Q1. Arithmetic operations");
        System.out.print("Enter first number: ");
        firstNumber = input.nextInt();
        System.out.print("Enter second number: ");
        secondNumber = input.nextInt();

        System.out.println(firstNumber + secondNumber);
        System.out.println(firstNumber - secondNumber);
        System.out.println(firstNumber * secondNumber);
        System.out.println(firstNumber / secondNumber);
        System.out.println(firstNumber % secondNumber);
// ======================================================================================== //
//        // Q2. String methods
        System.out.println("Q2. lower case the string");
        String text = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG.";
        System.out.println(text.toLowerCase());

// ======================================================================================== //

        // Q3. String reverse  -- for tomorrow 1/10/2023
//        System.out.println("Q3. Reverse the String");
//        String text2 = "The quick brown fox";

// ======================================================================================== //
        // Q4. Check is even or not
        System.out.println("Q4. check the even number");
        System.out.print("Enter any number to check if the number is even or not: ");
        int checkEven = input.nextInt();
        if(checkEven % 2 == 0) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
// ======================================================================================== //
        // Q5. check role
        String role;
        System.out.print("Q5. check the role\n Enter your role: ");
        role = input.nextLine();

        if(role.equals("Admin") || role.equals("admin")) {
            System.out.println("welcome admin");
        } else if(role.equals("superuser")) {
            System.out.println("welcome superuser");
        } else {
            System.out.println("welcome user");
        }
// ======================================================================================== //
    // Q6. check if the sums of two integers are == third integer
        int num1, num2, num3;
        System.out.println("Q6. check the sum of two numbers");
        System.out.println("Enter first number: ");
        num1 = input.nextInt();
        System.out.println("Enter second number: ");
        num2 = input.nextInt();
        System.out.println("Enter third number: ");
        num3 = input.nextInt();

        if(num1 + num2 == num3) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
// ======================================================================================== //
    // Q7. the greatest number
        int n1, n2, n3;
        System.out.println("Q7. check the greatest number\nEnter first number: \" ");
        n1 = input.nextInt();
        System.out.print("Enter second number: ");
        n2 = input.nextInt();
        System.out.print("Enter third number: ");
        n3 = input.nextInt();

        if((n1 > n2) && (n1 > n3)) {
            System.out.println("The greatest number: " + n1);
        } else if ((n2 > n1) && (n2 > n3)) {
            System.out.println("The greatest number: " + n2);
        } else {
            System.out.println("The greatest number: " + n3);
        }

// ======================================================================================== //
        // Q8. number of weekday
        // using switch case
        System.out.println("Q8. Weekday number. \nEnter a number from 1-7 to display the day");
        int weekdayNumber = input.nextInt();
        switch (weekdayNumber) {
            case 1:
                System.out.println("Sunday");
                break;
            case 2:
                System.out.println("Monday");
                break;
            case 3:
                System.out.println("Tuesday");
                break;
            case 4:
                System.out.println("Wednesday");
                break;
            case 5:
                System.out.println("Thursday");
                break;
            case 6:
                System.out.println("Friday");
                break;
            case 7:
                System.out.println("Saturday");
                break;
            default:
                System.out.println("Please enter between 1-7");
        }
    }
}
