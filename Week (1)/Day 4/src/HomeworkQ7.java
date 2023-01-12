import java.util.Arrays;
import java.util.Scanner;

public class HomeworkQ7 {
    public static void main(String[] args) {
// ========================== Q7 - menu  ==========================
        Scanner input = new Scanner(System.in);
        // NOT DONE
        System.out.println("========================== Q7 ==========================");
        System.out.println("** Welcome to the menu of array **");
        int sizeOfArray = 0;
        int[] array = new int[sizeOfArray];

        while (true) {
            System.out.println("a. Create an array." +
                    "\nb. Display the array." +
                    "\nc. Enter the element you want to find in the array." +
                    "\nd. Sort the array." +
                    "\nq. to quit");
            System.out.print("Choose from a-q >> ");
            String selection = input.nextLine();

            switch (selection) {
                case "a":
                    System.out.print("Please enter the size of array you want: ");
                    sizeOfArray = input.nextInt();
                    array = new int[sizeOfArray];
                    for (int i = 0; i < sizeOfArray; i++) {
                        System.out.print("\nInsert an element: ");
                        array[i] = input.nextInt();
                    }
                    break;
                case "b":
                    if(array.length == 0 ) {
                        System.out.println("Array is empty");
                    }
                    System.out.println(Arrays.toString(array));

                    break;
                case "c":
                    System.out.println("Searching for an element in array...");
                    System.out.println("Enter a number you want to search for: ");
                    int numberToSearch = input.nextInt();
                    for (int i = 0; i < array.length; i++) {
                        if(numberToSearch == array[i]) {
                            System.out.println( "number "+ numberToSearch +" is exist in the array");
                            break;
                        } else {
                            System.out.println("the number you enter is not in the array");
                            break;
                        }
                    }
                    break;
                case "d":
                    Arrays.sort(array);
                    System.out.println(Arrays.toString(array));
                    break;
                case "q":
                    System.out.println("Exiting the menu...");
                    System.exit(0);
                    break;
            }
        }

//        if(selection.equals("a")) {
//            System.out.print("Please enter the size of array you want: ");
//            sizeOfArray = input.nextInt();
////            sizeOfArray = 6;
//            array = new int[sizeOfArray];
//            for (int i = 0; i < sizeOfArray; i++) {
//                System.out.print("\nInsert an element: ");
////                int inputElement = input.nextInt();
//                array[i] = input.nextInt();
//            }
//        }
//          display the array
//        if(selection.equals("b")) {
////            if(array.length == 0 ) {
////                System.out.println("Array is empty");
////            }
////            for (int i = 0; i < array.length; i++) {
////                System.out.println(Arrays.toString(array));
////            }
//        }
//        if(selection.equals("c")) {
//            System.out.println("Searching for an element in array...");
//        }
//        if(selection.equals("d")) {
//            Arrays.sort(array);
//            System.out.println(Arrays.toString(array));
//        }
//        System.out.println(Arrays.toString(array));
    }
}
