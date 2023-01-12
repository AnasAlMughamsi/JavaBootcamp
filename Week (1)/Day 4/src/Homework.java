import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Homework {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
//        // ========================== Q1 - first-last element is same ==========================
        System.out.println("========================== Q1- first-last element ==========================");

        int[] arr = {50,-20,0,30,60,10};
        int firstNum = arr[0];
        if(arr[0] == arr[arr.length-1]) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

// ========================== Q2 - three largest numbers ==========================


        System.out.println("========================== Q2 ========================== ");

        Integer[] kArray = {1, 4, 17, 7, 25, 3, 100};
        Arrays.sort(kArray, Collections.reverseOrder());
        System.out.println("Enter k number, k will find you the largest elements in array ");
        int k = input.nextInt();
        System.out.print("The largest numbers of the array are: ");
        for (int i = 0; i < k; i++) {
            System.out.print(kArray[i] + " ");
        }
        System.out.println("");

// ========================== Q3 - number greater then average ==========================
        System.out.println("========================== Q3 ==========================");
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(1); arrayList.add(4);
        arrayList.add(17); arrayList.add(7);
        arrayList.add(25); arrayList.add(3);
        arrayList.add(100);
        int average = 0;
        int sum = 0;
        int length = arrayList.size();
        for (int i = 0; i < arrayList.size(); i++) {
            sum+= arrayList.get(i);
            average = sum / length;
        }
        System.out.println("average number is : " + average);
        System.out.print("numbers that are greater than " + average + " are: ");
        for (int i = 0; i < arrayList.size(); i++) {
            if(arrayList.get(i) > average)
                System.out.print(arrayList.get(i) + " ");
        }
        System.out.println("");
// ========================== Q4 - largest value between first and last element ==========================
        System.out.println("========================== Q4 ==========================");

        ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
        arrayList2.add(20);
        arrayList2.add(30);
        arrayList2.add(40);
        arrayList2.add(50);
        arrayList2.add(60);
        // arrayList2 = {20,30,40,50,60}
        int largestElement = arrayList2.get(0); // first element
        for (int i = 0; i < arrayList2.size(); i++) {
            if(largestElement < arrayList2.get(i)) {
                largestElement = arrayList2.get(i);
            }
        }
        System.out.println("Largest element in the array: " + largestElement);
// ========================== Q5 - swap element ==========================
        System.out.println("========================== Q5 ==========================");
        int firstElement = arrayList2.get(0);
        int lastElement = arrayList2.get(arrayList2.size()-1);
        int temp;
        System.out.println("first Element " + firstElement);
        System.out.println("last Element " + lastElement);

        temp = firstElement;
        firstElement = lastElement;
        lastElement = temp;
        System.out.println("After swap");
        System.out.println("first Element " + firstElement);
        System.out.println("last Element " + lastElement);

// ========================== Q6 - longest word ==========================
        System.out.println("========================== Q6 ==========================");
        ArrayList<String> listString = new ArrayList<String>();
        listString.add("cat");
        listString.add("dog");
        listString.add("red");
        listString.add("is");
        listString.add("am");
        // { "cat", "dog", "red", "is", "am" }
        int longestWord = listString.get(0).length();

        for (int i = 0; i < listString.size(); i++) {
//            System.out.println(listString.get(i).length());
            if(listString.get(i).length() > longestWord) {
                longestWord = listString.get(i).length();
            }
        }
        System.out.println("longestWord : " + longestWord);

        for (int i = 0; i < listString.size(); i++) {
            if(longestWord == listString.get(i).length()) {
                System.out.println(listString.get(i));
            }
        }


// ========================== Q8 - occurrences elements ==========================
        // NOT DONE ??
         System.out.println("========================== Q8 ==========================");
//        System.out.print("Enter the size of an array: ");
//        int arrayLength = input.nextInt();
////        ArrayList<Integer> occurrencesList = new ArrayList<Integer>();
//        int[] occurrencesArray = new int[arrayLength];
        int[] occurrencesArray = {1,1,2,2,3,5};
//        Arrays.stream(occurrencesArray)
//                .collect(Collectors.groupingBy(s -> s))
//                        .forEach()
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


// ========================== Q9 - odd/even ==========================
        System.out.println("========================== Q9 ==========================");
        int[] oddEvenArray = {2,3,40,1,5,9,4,10,7};

        int oddSize = 0;
        int evenSize = 0;
        // first in this loop it is just to find how many
        // even/odd number we have, then take is the size of a new two array
        // one as even array [evenSize] and the other as odd array [oddSize]
        for (int i = 0; i < oddEvenArray.length; i++) {
            if(oddEvenArray[i] % 2 == 0) {
                evenSize++;
            } else {
                oddSize++;
            }
        }

        int[] oddArray = new int[oddSize];
        int[] evenArray = new int[evenSize];
        int evLength = oddSize + evenSize;
        int[] newArray = new int[evLength];

        int e = 0, o = 0;
        // create two array even/odd
        // insert even/odd numbers from original array to
        // even array and odd array separately
        for (int i = 0; i < oddEvenArray.length; i++) {
            if(oddEvenArray[i] % 2 == 0) {
                evenArray[e++] = oddEvenArray[i];
            } else {
                oddArray[o++] = oddEvenArray[i];
            }
        }

        int position = 0;
        for (int element: oddArray) {
            newArray[position] = element;
            position++;
        }
        System.out.println("position after for each array - odd: " + position);
        // newArray = {oddArray} ==> {3, 1, 5, 9, 7}
        for (int element: evenArray) {
            newArray[position] = element;
            position++;
        }
        System.out.println(Arrays.toString(newArray));

// ========================== Q10 - Equality of two arrays =========================
        System.out.println("========================== Q10 ==========================");


        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {1,2,3,4,5};
        boolean arraysAreEqual = true;

        if(arr1.length == arr2.length) {
            for (int i = 0; i < arr1.length; i++) {
                if(arr1[i] != arr2[i]) {
                    arraysAreEqual = false;
                }
            }
        } else {
            System.out.println("Arrays have different length");
        }

        if(arraysAreEqual) {
            System.out.println("Arrays are Equal");
        } else {
            System.out.println("Array are not Equal");
        }

    }
}
