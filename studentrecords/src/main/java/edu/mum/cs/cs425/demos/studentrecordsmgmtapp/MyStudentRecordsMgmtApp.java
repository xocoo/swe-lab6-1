package edu.mum.cs.cs425.demos.studentrecordsmgmtapp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
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

        System.out.println("All students:");
        printListOfStudents(students);

        System.out.println("Platinum students:");
        List<Student> studentsPlatinum = getListOfPlatinumAlumniStudents(students);
        for (Student student : studentsPlatinum) {
            System.out.println(student);
        }

        int[] intArray = new int[] { 55, 10, 60, 14, 21, 35 };
        printHelloWorld(intArray);
        System.out.println("Second Max: " + findSecondBiggest(intArray));
    }

    public static void printListOfStudents(List<Student> students) {
        students.stream().sorted(Comparator.comparing(Student::getStudentName)).forEach(System.out::println);
    }

    public static List<Student> getListOfPlatinumAlumniStudents(List<Student> students) {
        List<Student> studentsPlatinum = new ArrayList<>();
        LocalDate platinumYear = LocalDate.now().minusYears(30);
        for (Student student : students) {
            boolean isBefore = student.getDateOfAdmission().isBefore(platinumYear);
            if (isBefore) {
                studentsPlatinum.add(student);
            }
        }
        return studentsPlatinum.stream().sorted(Comparator.comparing(Student::getDateOfAdmission).reversed())
                .collect(Collectors.toList());
    }

    public static void printHelloWorld(int[] intarray) {
        for (int i = 0; i < intarray.length; i++) {
            if (intarray[i] % 5 == 0 && intarray[i] % 7 == 0)
                System.out.println("HelloWorld");
            else if (intarray[i] % 5 == 0)
                System.out.println("Hello");
            else if (intarray[i] % 7 == 0)
                System.out.println("World");

        }
    }

    public static int findSecondBiggest(int[] intArray) {
        int max = intArray[0];
        int secondMax = intArray[0];
        for (int i = 1; i < intArray.length; i++) {
            if (intArray[i] > max) {
                secondMax = max;
                max = intArray[i];
            } else if (intArray[i] > secondMax)
                secondMax = intArray[i];
        }
        return secondMax;
    }
}
