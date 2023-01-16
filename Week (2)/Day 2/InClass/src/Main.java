import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int numberOfStudents;
        System.out.print("Enter number of students: ");
        numberOfStudents = input.nextInt();

        // ================================================================= //
        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();
        Student s4 = new Student();

        s1.setFirstName("Anas");
        s1.setLastName("Al-Mughamisi");
        s1.setEmail("Anas@gmail.com");
        s1.setPhoneNumber("0544234231");

        s2.setFirstName("Nasibah");
        s2.setLastName("Al-Harbi");
        s2.setEmail("Nasibah@gmail.com");
        s2.setPhoneNumber("054234231");

        s3.setFirstName("Test");
        s3.setLastName("Al-Test");
        s3.setEmail("Test@gmail.com");
        s3.setPhoneNumber("0504254231");

        s4.setFirstName("Student 4");
        s4.setLastName("last Student 4");
        s4.setEmail("Student4@gmail.com");
        s4.setPhoneNumber("050004231");

        System.out.println("first name: " + s1.getFirstName());
        System.out.println("first name: " + s1.getLastName());
        System.out.println("first name: " + s1.getPhoneNumber());
        System.out.println("first name: " + s1.getEmail());
        System.out.println("-----------------------------------------");
        System.out.println("first name: " + s2.getFirstName());
        System.out.println("first name: " + s2.getLastName());
        System.out.println("first name: " + s2.getEmail());
        System.out.println("first name: " + s2.getPhoneNumber());
        System.out.println("-----------------------------------------");
        System.out.println("first name: " + s3.getFirstName());
        System.out.println("first name: " + s3.getLastName());
        System.out.println("first name: " + s3.getPhoneNumber());
        System.out.println("first name: " + s3.getEmail());

    }
}