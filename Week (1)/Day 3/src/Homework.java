import java.util.Scanner;

public class Homework {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
// =================================== Q-1 ===================================
        System.out.println("==================== Q1 - division ====================");
        for (int i = 0; i <= 100; i++) {
            if ((i % 3 == 0) && (i % 5 == 0)) {
                System.out.println(i + " FizzBuzz");
            } else if(i % 3 == 0) {
                System.out.println( i + " Fizz");
            } else if (i % 5 == 0) {
                System.out.println(i + " Buzz");
            }
        }

// =================================== Q-2 ===================================
        System.out.println("==================== Q2 - reverse String ====================");

        String text = "The quick brown fox";
        String reverseText = "";
        for (int i = text.length()-1; i >= 0; i--) {
            reverseText += text.toCharArray()[i];
        }
        System.out.println(reverseText);

// =================================== Q-3 ===================================
        System.out.println("==================== Q3 - multiplication ====================");

        System.out.print("Enter a number to check its multiplication: ");
        int num = input.nextInt();
        for (int i=1; i <= 10; i++) {
            System.out.println(num * i);
        }
// =================================== Q-4 ===================================
        System.out.println("==================== Q4 - factorial ====================");
        System.out.print("Enter any number to find the factorial of it: ");
        int fac = input.nextInt();

        for (int i = fac-1; i > 0; i--) {
            fac =  fac * i;
        }
        System.out.println("factorial: " + fac);

// =================================== Q-5 ===================================
        int base, power;
        int square = 1;
        System.out.println("==================== Q5 - power ====================");
        System.out.print("Enter the base: ");
        base = input.nextInt();
        System.out.print("Enter the power: ");
        power = input.nextInt();
        for (int i = 1; i <= power; i++) {
            square *= base;
        }
        System.out.println("power = " + square);

// =================================== Q-6 ===================================
        int sumOfEven = 0;
        int sumOfOdd = 0;
        int setNum;
        System.out.println("==================== Q6 - Even/Odd ====================");
        System.out.print("Enter a number: ");
        setNum = input.nextInt();
        for (int i = 0; i < setNum; i++) {
            if(i % 2 == 0) {
                sumOfEven += i;
            } else if (i % 1 == 0) {
                sumOfOdd += i;
            }
        }

        System.out.println("Even: " + sumOfOdd);
        System.out.println("Odd: " + sumOfEven);
// =================================== Q-7 =================================== //

        // NOT DONE
        System.out.println("==================== Q7 - prime number ====================");
        System.out.print("Enter any number to check if it is a prime or not: ");
        int primeNum = input.nextInt();
        boolean isPrime = true;
        for (int i = 2; i <= primeNum / 2; i++) {
            if(primeNum % i == 0) {
                isPrime = false;
                break;
            }
        }
        if(isPrime) {
            System.out.println(primeNum + " is prime number");
        } else {
            System.out.println(primeNum + " is not prime number");
        }
// =================================== Q-8 =================================== //

        int rangeOfNumbers;
        int numberInput;
        int positives = 0, negatives = 0, zeros = 0;
        System.out.println("==================== Q8 ====================");
        System.out.print("Enter range of numbers: ");
        rangeOfNumbers = input.nextInt();
        System.out.print("Enter a number to check how many p/n/z numbers you have ");
        for (int i = 0; i < rangeOfNumbers; i++) {
            numberInput = input.nextInt();
            if(numberInput == 0) {
                zeros++;
            } else if (numberInput > 0) {
                positives++;
            } else {
                negatives++;
            }
        }
        System.out.println("You have " + positives + " positives numbers");
        System.out.println("You have " + zeros + " zeros numbers");
        System.out.println("You have " + negatives + " negatives numbers");


// =================================== Q-9 =================================== //
        System.out.println("==================== Q9 ====================");
        int weeks = 4;
        int days = 7;

        for (int i = 1; i <= weeks; i++) {
            System.out.println("Week " + i);
            for (int j = 1; j <= days; j++) {
                System.out.println("Day " + j);
            }
        }

// =================================== Q-10 ===================================
        System.out.println("==================== Q10 - palindrome word ====================");
        String word;
        String palindrome = "";
        System.out.print("Enter a word to check if it is palindrome word: ");
        word = input.nextLine();
        for (int i = word.length()-1; i >= 0; i--) {
            palindrome += word.toCharArray()[i];
        }
        if(word.equals(palindrome)) {
            System.out.println("The word is palindrome - Correct");
        } else {
            System.out.println("NOT palindrome");
        }
    }
}
