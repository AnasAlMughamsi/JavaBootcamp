public class Student extends Person {

    private int level;
    private String gpa;
    public Student(String firstName, String lastName, String email, String phoneNumber, int level, String gpa) {
        super(firstName, lastName, email, phoneNumber);
        this.level = level;
        this.gpa = gpa;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getGpa() {
        return gpa;
    }

    public void setGpa(String gpa) {
        this.gpa = gpa;
    }
}
