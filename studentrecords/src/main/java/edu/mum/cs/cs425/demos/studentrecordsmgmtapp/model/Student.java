package edu.mum.cs.cs425.demos.studentrecordsmgmtapp.model;

import java.time.LocalDate;

public class Student {
    private int studentId;
    private String studentName;
    private LocalDate dateOfAdmission;

    public Student(int studentId, String studentName, LocalDate dateOfAdmission) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.dateOfAdmission = dateOfAdmission;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public LocalDate getDateOfAdmission() {
        return dateOfAdmission;
    }

    public void setDateOfAdmission(LocalDate dateOfAdmission) {
        this.dateOfAdmission = dateOfAdmission;
    }

    @Override
    public String toString() {
        return "Student [dateOfAdmission=" + dateOfAdmission + ", studentId=" + studentId + ", studentName="
                + studentName + "]";
    }
}
