package lessons.lessons5.Person;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
// Абстракция
abstract class Person {
    private int id;
    private String name;
    private String email;

    public abstract String getRole();
}

// Наследование
class Teacher extends Person {
    private String specialization;

    public Teacher(int id, String name, String email, String specialization) {
        super(id, name, email);
        this.specialization = specialization;
    }

    public String getSpecialization() {return specialization;}

    @Override
    public String getRole() {
        return "Teacher";
    }
}

class Student extends Person {
    private final Map<String, Integer> grades = new HashMap<>();
    private final Map<String, Boolean> attendance = new HashMap<>();

    public Student(int id, String name, String email) {
        super(id, name, email);
    }

    public void addGrade(String courseTitle, int grade) {
        grades.put(courseTitle, grade);
    }

    public void markAttendance(String courseTitle, boolean present) {
        attendance.put(courseTitle, present);
    }

    public Map<String, Integer> getGrades() {return grades;}

    @Override
    public String getRole() {
        return "Student";
    }
}

class Course {
    private final int id;
    private String title;
    private Teacher teacher;
    private final List<Student> students = new ArrayList<>();

    public Course(int id, String title, Teacher teacher) {
        this.id = id;
        this.title = title;
        this.teacher = teacher;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void markAttendance(Student student, boolean present) {
        student.markAttendance(title, present);
    }

    public void addGrade(Student student, int grade) {
        student.addGrade(title, grade);
    }

    public void printStudents() {
        System.out.println("Students in course " + title + ":");
        for (Student s : students) {
            System.out.println("- " + s.getName());
        }
    }
}


