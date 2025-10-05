package lessons.lessons5.Person;

public class Main {
    public static void main(String[] args) {
        Teacher t1 = new Teacher(1, "Dr. Smith", "smith@mail.com", "Math");
        Course mathCourse = new Course(101, "Algebra", t1);

        Student s1 = new Student(1, "Alice", "alice@mail.com");
        Student s2 = new Student(2, "Bob", "bob@mail.com");

        mathCourse.addStudent(s1);
        mathCourse.addStudent(s2);

        mathCourse.markAttendance(s1, true);
        mathCourse.markAttendance(s2, false);

        mathCourse.addGrade(s1, 90);
        mathCourse.addGrade(s2, 75);

        mathCourse.printStudents();
        System.out.println(s1.getName() + " grade in Algebra: " + s1.getGrades().get("Algebra"));
    }
}
