package edu.mum.cs.cs425.demos.studentrecordsmgmtapp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

import edu.mum.cs.cs425.demos.studentrecordsmgmtapp.model.Student;

public class MyStudentRecordsMgmtApp {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<Student>() {
            {
                add(new Student(110001, "Dave", LocalDate.of(1951, 11, 11)));
                add(new Student(110002, "Anna", LocalDate.of(1990, 12, 07)));
                add(new Student(110003, "Erica", LocalDate.of(1974, 01, 31)));
                add(new Student(110004, "Carlos", LocalDate.of(2009, 8, 22)));
                add(new Student(110005, "Bob", LocalDate.of(1990, 03, 05)));
            }
        };

        // printListOfStudents(students);
        List<Student> studentsPlatinum = getListOfPlatinumAlumniStudents(students);
        studentsPlatinum.stream().sorted().forEach(System.out::println);
    }

    public static void printListOfStudents(List<Student> students) {
        students.stream().sorted(Comparator.comparing(Student::getStudentName)).forEach(System.out::println);
    }

    public static List<Student> getListOfPlatinumAlumniStudents(List<Student> students) {
        List<Student> studentsPlatinum = new ArrayList<>();
        for (Student student : students) {
            LocalDate platinumYear = LocalDate.now().minusYears(30);
            boolean isBefore = student.getDateOfAdmission().isBefore(platinumYear);
            if (isBefore) {
                studentsPlatinum.add(student);
            }
        }
        return studentsPlatinum;
    }
}
