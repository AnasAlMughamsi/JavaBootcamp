import java.util.Scanner;

public class TeacherPartTime extends Teacher {

    private double paidByHour;
    public TeacherPartTime(String firstName, String lastName, String email, String phoneNumber, double salary, double paidByHour) {
        super(firstName, lastName, email, phoneNumber, salary);
        this.paidByHour = paidByHour;
    }


    @Override
    public double setSalary(double salary) {
//        Scanner input = new Scanner(System.in);
        int hours = 151;
        paidByHour = salary;
        if(hours >= 150) {
         paidByHour = 50;
        } else {
            paidByHour = 30;
        }
        double totalSalary = hours * paidByHour;
        System.out.println("Part time salary: " + totalSalary);
        setSalary(totalSalary);
        return totalSalary;
    }

    @Override
    public double getSalary() {
        return super.getSalary();
    }
}
