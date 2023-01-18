public abstract class Teacher extends Person {
    private double salary;


    public Teacher(String firstName, String lastName, String email, String phoneNumber, double salary) {
        super(firstName, lastName, email, phoneNumber);
        this.salary = salary;
    }


    public double getSalary() {
        return salary;
    }

    public abstract double setSalary(double salary);

}
