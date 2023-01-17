import java.util.Scanner;

public class TeacherPartTime extends Teacher {
    public TeacherPartTime(String firstName, String lastName, String email, String phoneNumber, double salary) {
        super(firstName, lastName, email, phoneNumber, salary);
    }


    @Override
    public void setSalary(double salary) {

//        Scanner input = new Scanner(System.in);

        int hours = 151;
        double paidByHour = salary;
        if(hours >= 150) {
         paidByHour = 50;
        } else {
            paidByHour = 30;
        }
        double totalSalary = hours * paidByHour;
        System.out.println("Part time salary: " + totalSalary);
        super.setSalary(totalSalary);
    }
}
