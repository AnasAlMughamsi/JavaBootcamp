public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Anas", "Al-Mughamisi",
                "Anas@gmail.com", "054334025",4,"4.6");


        TeacherFullTime teacherFullTime = new TeacherFullTime("asdf", "asdf",
                "asdfasf","342341234",4133,12);


        System.out.println(teacherFullTime.setSalary(8000));
        System.out.println(teacherFullTime.getSalary());
    }
}