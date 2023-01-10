import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
//        System.out.println("Enter your name: ");
//        String fullName = input.nextLine();
//        System.out.println("Name: " + fullName);

        // String methods
//        String company = "Tuwaiq Academy";
//        System.out.println("check Tuwaiq: "+company.toUpperCase());
//        System.out.println(company.equals("Test"));

        // conditions

        String role;
        System.out.print("Enter your role: ");
        role = input.nextLine();

        if(role.equals("Admin")) {
            System.out.println("Hello Admin");
        } else {
            System.out.println("Hello");
        }


        System.out.print("Enter your grade: ");
        int grade = input.nextInt();

        if(grade <= 100 && grade >= 90) {
            System.out.println("A");
        } else if (grade <= 89 && grade >= 80) {
            System.out.println("B");
        } else if (grade <= 79 && grade >= 70) {
            System.out.println("C");
        } else if (grade <= 69 && grade >= 60) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }


        // switch case

        int number;
        System.out.print("Enter 1 to check your balance");
        System.out.print("Enter 2 to show your user name");
        System.out.println("Enter 3 to call customer service");
        number = input.nextInt();

        switch (number) {
            case 1:
                System.out.println("Your balance is 100,000");
                break;
            case 2:
                System.out.println("Your user name is Anas");
                break;
            case 3:
                System.out.println("Calling customer service...");
                break;
        }
    }
}