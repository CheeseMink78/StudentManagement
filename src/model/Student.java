
package model;

import java.util.Objects;

public class Student {
    private String studentName, semester, courseName;
    private int id;
    public int totalCourse;
    public Student(String studentName, String semester, String courseName, int id) {
        this.studentName = studentName;
        this.semester = semester;
        this.courseName = courseName;
        this.id = id;
        totalCourse=1;
    }

    public void setTotalCourse(int totalCourse) {
        this.totalCourse = totalCourse;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return studentName + "| " + semester + " | " + courseName;
    }
    public boolean equals(Student st) {
        if (this.id==st.id || this.studentName.matches(st.getStudentName())) {
            return true;
        }
        else
            return false;
        }
    }
