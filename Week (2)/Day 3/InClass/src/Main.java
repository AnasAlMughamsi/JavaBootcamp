public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Anas", "Al-Mughamisi",
                "Anas@gmail.com", "054334025",4,"4.6");

        Teacher teacher1 = new Teacher("teacher1", "the-teacher",
                "teacher@gamil.com","034285821",12000);

//        teacher1.setSalary(12450.0);
//        System.out.println(teacher1.getSalary());



        TeacherFullTime teacherFullTime = new TeacherFullTime("teacherFull", "the-teacher",
                "teacher@gamil.com","034285821",12000, 12, 0.2);

        System.out.print("Salary for teacher full time is (bonus + after one year): ");
        teacherFullTime.setSalary(10000);
        System.out.println(teacherFullTime.getSalary());

        TeacherPartTime teacherPartTime = new TeacherPartTime("teacherPart", "the-teacher",
                "teacher@gamil.com","034285821",12000);
        teacherPartTime.setSalary(0); // value will reset in override
        System.out.println("Salary of teacher part time " + teacherPartTime.getSalary());
    }
}