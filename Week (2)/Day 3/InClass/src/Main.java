public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Anas", "Al-Mughamisi",
                "Anas@gmail.com", "054334025",4,"4.6");


        TeacherFullTime teacherFullTime = new TeacherFullTime();
        TeacherPartTime teacherPartTime = new TeacherPartTime();

//        System.out.println(teacherFullTime.setSalary(8000));
        System.out.println(teacherPartTime.setSalary(3500));
        System.out.println(teacherFullTime.getSalary());
    }
}