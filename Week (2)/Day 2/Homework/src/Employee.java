public class Employee {

    private String id;
    private String name;
    private double salary;

    public Employee(String id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    public Employee() {

    }
    public double getAnnualSalary() {
        double totalSalary = 0;
        if(salary > 0 ) {
            totalSalary = salary * 12;
        } else {
            System.out.print("employee does not have salary yet...");
        }
        return totalSalary;
    }

    public double raisedSalary(double percent) {
        if(salary == 0) {
            System.out.println("Employee must have salary to be raised!");
        }
        double newSalary = 0;
        double raised = (double) salary * (percent / 100 );
        newSalary = salary + raised;
        return newSalary;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

}
