import java.util.Scanner;

public class TeacherPartTime extends Teacher {

    private double paidByHour;

    public TeacherPartTime() {

    }

    public TeacherPartTime(String firstName, String lastName, String email, String phoneNumber, double salary, double paidByHour) {
        super(firstName, lastName, email, phoneNumber, salary);
        this.paidByHour = paidByHour;
    }

    public double setSalary(double salary) {
        int hours = 151;
        if(hours >= 150) {
            salary = 50;
        } else {
            salary = 30;
        }
        salary += hours * salary;
//        setSalary(salary);
        System.out.println("Part time salary: " + salary);
        return salary;
    }
//    @Override
//    public double setSalary(double salary) {
//        int hours = 151;
//        if(hours >= 150) {
//            salary = 50;
//        } else {
//            salary = 30;
//        }
//        salary += hours * salary;
//        System.out.println("Part time salary: " + salary);
//        return salary;
//    }


}
