import java.util.*;

public class Question1 {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args)  {
        System.out.println("** Welcome to the menu of array **");
        Integer[] array = {};
        int sizeOfArray = 0;

        while (true) {
            System.out.println("\na. Create an array." +
                    "\nb. Display the array." +
                    "\nc. Enter the element you want to find in the array." +
                    "\nd. Sort the array." +
                    "\nq. to quit\n");
            System.out.print("Choose from a-q >> ");

            String selection = input.next();
            if (selection.equals("a")) {
                try {
//                createArray(array, sizeOfArray);
                    System.out.print("Please enter the size of array you want: ");
                    sizeOfArray = input.nextInt();
                    array = new Integer[sizeOfArray];
                    try {
                        for (int i = 0; i < sizeOfArray; i++) {
                            System.out.print("\nInsert an element: ");
                            array[i] = input.nextInt();
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Sorry, the array only except number of type int");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Please enter just numbers: ");
//                } catch (Exception e) {
//                    System.out.println(e.getMessage());
//                }
                }
            }
            // Display the array
            if(selection.equals("b")) {
                try {
                    displayArray(array);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            // search for element
            if(selection.equals("c")) {
                System.out.println("Enter a number you want to search for: ");
                try {
                    int numberToSearch = input.nextInt();
                    searchElement(array, numberToSearch);
                } catch (Exception e) {
                    System.out.println("Please enter only numbers!");
                }
            }
            if(selection.equals("d")) {
                try {
                    sortArray(array);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            if(selection.equals("q")) {
                System.exit(0);
            }
            input.nextLine();
        }
    }

    public static void createArray(Integer[] array, int sizeOfArray) {

    }
    public static void displayArray(Integer[] array) throws Exception {
        if(array.length == 0 ) {
            throw new Exception("Array is empty");
        }
        System.out.println("The array: " + Arrays.toString(array));
    }

    public static void sortArray(Integer[] array) throws Exception {
        if(array.length == 0) {
            throw new Exception("Array is empty");
        }
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void searchElement(Integer[] array, int numberToCheck) throws Exception {
        List<Integer> myList = new ArrayList<>(Arrays.asList(array));
//        System.out.println(myList);
        if(myList.contains(numberToCheck)) {
            System.out.println("---------------------------------");
            System.out.println("number " + numberToCheck + " is exist in array !");
            System.out.println("---------------------------------");
        } else {
            throw new Exception("Number not found in the array");
        }
    }
}