public class Main {
    public static void main(String[] args) {
        // Methods
        int n1 =3;
        int n2 =5;
        int n3 =2;
        average(n1,n2,n3);
        int smallestNumber = smallest(n1,n2,n3);
        System.out.println("smallest number: " + smallestNumber);
        int largestNumber = largest(n1,n2,n3);
        System.out.println("largest number: " + largestNumber);

    }

    private static int largest(int n1, int n2, int n3) {
        return Math.max(Math.max(n1,n2), n3);
    }

    // two types of method - void / return
    // void method -- return nothing
    // return method -- return a value string/int

    public static void average(int n1, int n2, int n3) {
        double average = (n1+n2+n3) / 3.0;
        System.out.println("average is: " + average);
    }

    public static int smallest(int n1, int n2, int n3) {
        return Math.min(Math.min(n1,n2),n3);
    }
}