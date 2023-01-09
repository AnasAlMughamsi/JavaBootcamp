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


    }
}