import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Homework {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // ========================== Q1 - first-last element is same ==========================
        System.out.println("========================== Q1- first-last element ==========================");
//        ArrayList<Integer> array = new ArrayList<Integer>();
//        array.add(50);
//        array.add(-20);
//        array.add(0);
//        array.add(30);
//        array.add(60);
//        array.add(10);

        int[] arr = {50,-20,0,30,60,10};
        int firstNum = arr[0];
        if(arr[0] == arr[arr.length-1]) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

// ========================== Q2 - three largest numbers ==========================

        // NOT DONE !! //
        System.out.println("========================== Q2 ========================== ");
//        ArrayList<Integer> arrayList = new ArrayList<Integer>();
//        arrayList.add(1);
//        arrayList.add(4);
//        arrayList.add(17);
//        arrayList.add(7);
//        arrayList.add(25);
//        arrayList.add(3);
//        arrayList.add(100);
//        int firstLarge = arrayList.get(0);
//        int secondLarge = arrayList.get(1);
//        int thirdLarge = arrayList.get(2);
//        for (int i = 0; i < arrayList.size(); i++) {
//            if(arrayList.get(i) > firstLarge) {
//                firstLarge = arrayList.get(i);
//            }
//            if((arrayList.get(i) > secondLarge) && (secondLarge < firstLarge)) {
//                secondLarge = arrayList.get(i);
//            }
//        }
//        System.out.println(firstLarge);
//        System.out.println(secondLarge);


// ========================== Q3 - number greater then average ==========================
//        System.out.println("========================== Q3 ==========================");
//        int average = 0;
//        int sum = 0;
//        int length = arrayList.size();
//        for (int i = 0; i < arrayList.size(); i++) {
//            sum+= arrayList.get(i);
//            average = sum / length;
//        }
//        System.out.println("average number is : " + average);
//        System.out.print("numbers that are greater than " + average + " are: ");
//        for (int i = 0; i < arrayList.size(); i++) {
//            if(arrayList.get(i) > average)
//                System.out.print(arrayList.get(i) + " ");
//        }
// ========================== Q4 - largest value between first and last element ==========================
        System.out.println("========================== Q4 ==========================");
//
//        ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
//        arrayList2.add(20);
//        arrayList2.add(30);
//        arrayList2.add(40);
//        arrayList2.add(50);
//        arrayList2.add(60);
//        // arrayList2 = {20,30,40,50,60}
//        int largestElement = arrayList2.get(0); // first element
//        System.out.println(largestElement);
//        for (int i = 0; i < arrayList2.size(); i++) {
//            if(largestElement < arrayList2.get(i)) {
//                largestElement = arrayList2.get(i);
//            }
//        }
//        System.out.println("Largest element in the array: " + largestElement);
// ========================== Q5 - swap element ==========================
        System.out.println("========================== Q5 ==========================");
//        int firstElement = arrayList2.get(0);
//        int lastElement = arrayList2.get(arrayList2.size()-1);
//        int temp;
//        System.out.println("first Element " + firstElement);
//        System.out.println("last Element " + lastElement);
//
//        temp = firstElement;
//        firstElement = lastElement;
//        lastElement = temp;
//        System.out.println("After swap");
//        System.out.println("first Element " + firstElement);
//        System.out.println("last Element " + lastElement);

// ========================== Q6 - longest word ==========================
        System.out.println("========================== Q6 ==========================");
//        ArrayList<String> listString = new ArrayList<String>();
//        listString.add("cat");
//        listString.add("dog");
//        listString.add("red");
//        listString.add("is");
//        listString.add("am");
//        // { "cat", "dog", "red", "is", "am" }
//        int longestWord = listString.get(0).length();
//
//        for (int i = 0; i < listString.size(); i++) {
////            System.out.println(listString.get(i).length());
//            if(listString.get(i).length() > longestWord) {
//                longestWord = listString.get(i).length();
//            }
//        }
//        System.out.println("longestWord : " + longestWord);
//
//        for (int i = 0; i < listString.size(); i++) {
//            if(longestWord == listString.get(i).length()) {
//                System.out.println(listString.get(i));
//            }
//        }

// ========================== Q7 - three largest numbers ==========================
        // NOT DONE
//        System.out.println("========================== Q7 ==========================");
//        System.out.println("** Welcome to the menu of array **");
//        // a. Accept elements of an array
//        // b. Display elements of an array
//        // c. Search the element within array
//        // d. Sort the array
//        System.out.println("a. Enter the size of the array you want." +
//                "\nb. Display the array." +
//                "\nc. Enter the element you want to find in the array." +
//                "\nd. Sort the array.");
//        System.out.println("Choose from a-d >> ");
//        String userInput = input.nextLine();
//        int sizeOfArray = 0;
//        int[] array = new int[sizeOfArray];
//        if(userInput.equals("a")) {
//            System.out.print("Please enter the size of array you want: ");
////            sizeOfArray = input.nextInt();
//            sizeOfArray = 6;
//            for (int i = 0; i <= sizeOfArray; i++) {
//                System.out.print("Insert an element: ");
////                int inputElement = input.nextInt();
//                array[i] = input.nextInt();
//            }
//        }
////        if(userInput.equals("b")) {
////
////        }
////        if(userInput.equals("c")) {
////
////        }
////        if(userInput.equals("d")) {
////
////        }
//        System.out.println("Size of array :" + sizeOfArray);
//        System.out.println(Arrays.toString(array));

// ========================== Q8 - three largest numbers ==========================
        System.out.println("========================== Q8 ==========================");
//        System.out.print("Enter the size of an array: ");
//        int arrayLength = input.nextInt();
////        ArrayList<Integer> occurrencesList = new ArrayList<Integer>();
//        int[] occurrencesArray = new int[arrayLength];
////        int[] occurrencesArray = {1,1,2,2,3,5};
//
//        // inset element inside of array by user
//        for (int i = 0; i < arrayLength; i++) {
//            occurrencesArray[i] = input.nextInt();
//        }
//        System.out.println(Arrays.toString(occurrencesArray));
//        int count = 0;
//        // another for loop to check duplicate numbers
//        for (int i = 0; i < arrayLength; i++) {
//            if(occurrencesArray[i] == occurrencesArray[i+1]) {
//                count++;
//            }
//        }
//        System.out.println(count);
// ========================== Q9 - three largest numbers ==========================
        int[] oddEvenArray = {2,3,40,1,5,9,4,10,7};

        int oddSize = 0;
        int evenSize = 0;
        for (int i = 0; i < oddEvenArray.length; i++) {
            if(oddEvenArray[i] % 2 == 0) {
                evenSize++;
            } else {
                oddSize++;
            }
        }

        int[] oddArray = new int[oddSize];
        int[] evenArray = new int[evenSize];
        int length = oddSize + evenSize;
        int[] newArray = new int[length];

        int e = 0, o = 0;
        for (int i = 0; i < oddEvenArray.length; i++) {
            if(oddEvenArray[i] % 2 == 0) {
                evenArray[e++] = oddEvenArray[i];
            } else {
                oddArray[o++] = oddEvenArray[i];
            }
        }

        int position=0;
        for (int element: oddArray) {
            newArray[position] = element;
            position++;
        }
        for (int element: evenArray) {
            newArray[position] = element;
            position++;
        }
        System.out.println(Arrays.toString(newArray));

// ========================== Q10 - Equality of two arrays =========================


//        int[] arr1 = {1,2,3,4,5};
//        int[] arr2 = {1,2,3,4,5};
//        boolean arraysAreEqual = true;
//
//        if(arr1.length == arr2.length) {
//            for (int i = 0; i < arr1.length; i++) {
//                if(arr1[i] != arr2[i]) {
//                    arraysAreEqual = false;
//                }
//            }
//        } else {
//            System.out.println("Arrays have different length");
//        }
//
//        if(arraysAreEqual) {
//            System.out.println("Arrays are Equal");
//        } else {
//            System.out.println("Array are not Equal");
//        }

    }
}
