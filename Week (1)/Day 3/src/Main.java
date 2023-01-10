import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        // while
//        int i = 0;
//        while (i<= 10) {
//            System.out.println(i);
//            i++;
//        }

// =============================== while loop ===============================
        Scanner input = new Scanner(System.in);
//        int sum = 0;
//
//        System.out.print("Enter a number: ");
//        int numberInput = input.nextInt();
//
//        while (numberInput >= 0) {
////            if (numberInput < 0) break;
//            sum += numberInput;
//            System.out.print("Enter another number: ");
//            numberInput = input.nextInt();
//        }
//
//        System.out.println("Sum of numbers is = " + sum);

    // =============================== nested loop ===============================

//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                System.out.print("#");
//            }
//            System.out.println("");
//        }

//        int length, width;
//        System.out.print("Enter the length: ");
//        length = input.nextInt();
//        System.out.print("Enter the width: ");
//        width = input.nextInt();
//
//        for (int i = 0; i < length; i++) {
//            for (int j = 0; j < width; j++) {
//                System.out.print("#");
//            }
//            System.out.println("");
//        }

    // Exercise - create an empty square
        System.out.println("Enter any number to create a shape: ");
//        int shapeLength = input.nextInt();
        int shapeLength = 4;

        for (int i = 0; i < shapeLength; i++) {
            for (int j = 0; j < shapeLength; j++) {
                if ((i == 0) || (j == 0)) {
                    System.out.print("# ");
                } else if (i == (shapeLength-1) || j == (shapeLength-1)) {
                    System.out.print("# ");
                } else  {
                    System.out.print("  ");
                }

            }
            System.out.println("");
        }
    }
}