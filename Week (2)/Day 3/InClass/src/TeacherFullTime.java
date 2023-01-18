public class TeacherFullTime extends Teacher {

    private double yearly = 12;


    public TeacherFullTime(String firstName, String lastName, String email,
                           String phoneNumber, double salary, double yearly) {
        super(firstName, lastName, email, phoneNumber, salary);
        this.yearly = yearly;
    }

//    @Override
//    public void setSalary(double salary) {
//        double totalSalary = 0;
//        totalSalary += yearly * salary;
//        setSalary(salary);
//        System.out.println(totalSalary);
//    }


    @Override
    public double setSalary(double salary) {
        return salary * yearly;
    }

    @Override
    public double getSalary() {
        return super.getSalary();
    }
}
