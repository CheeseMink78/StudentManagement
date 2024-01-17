package controller;

import View.Menu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Predicate;
import model.Student;
import model.StudentList;

public class StudentController extends Menu {

    public static String[] choices = {"Create", "Find and sort", "Update/Delete", "Report", "Quit"};
    private StudentList studentL = new StudentList();

    public StudentController() {
        super("Student Management:", choices);
    }

    public void createStudent() {
        Predicate<String> validCourse = p -> p.matches("Java") || p.matches("C/C++") || p.matches(".Net");
        int count = 0;
        boolean flag = true;
        while (flag) {
            while (count <= 3) {
                String studentName, semester, courseName;
                int id;
                id = Input.getInt("id");
                studentName = Input.getString("student name");
                semester = Input.getString("semester");
                do {
                    courseName = Input.getString("course name");
                } while (!validCourse.test(courseName));
                if (studentL.addStudent(new Student(studentName, semester, courseName, id))) {
                    count++;
                    System.out.println("Sucessful.");
                } else {
                    System.out.println("Student already exist.");
                }
break;
            }
            System.out.println("Do you want to continue(Y/N)");
            String sign = Input.getNextString();
            if (!sign.matches("Y")) {
                flag = false;
            }
        }
    }

    public void findAndSort() {
        String input = Input.getString("name");
        ArrayList<Student> searchList = studentL.search(p -> p.getStudentName().contains(input));
        if (searchList == null) {
            System.out.println("Not found.");
        } else {
            Collections.sort(searchList, (Student o1, Student o2) -> o1.getStudentName().compareTo(o2.getStudentName()));
            for (Student st : searchList) {
                System.out.println(st);
            }
        }
    }

    public void printReport() {
        for (Student st : studentL.getListStudent()) {
            System.out.println(st.getStudentName() + "|" + st.getCourseName() + "|" + st.totalCourse);
        }
    }

    public void updateOrDelete() {
        Predicate<String> validCourse = p -> p.matches("Java") || p.matches("C/C++") || p.matches(".Net");
        int flag = Input.getInt("update(0) or delete(1)");
        String studentName, semester, courseName;
        int id;
        id = Input.getInt("id");
        studentName = Input.getString("student name");
        semester = Input.getString("semester");
        do {
            courseName = Input.getString("course name");
        } while (!validCourse.test(courseName));
        Student stu = new Student(studentName, semester, courseName, id);
        if (flag == 0) {
            studentL.updateStudent(id);
        } else if (flag == 1) {
            studentL.deleleStudent(id);
        }
    }

    @Override
    public void execute(int ch) {
        switch (ch) {
            case 1:
                createStudent();
                break;
            case 2:
                findAndSort();
                break;
            case 3:
                updateOrDelete();
                break;
            case 4:
                printReport();
                break;
            case 5:
                exitMenu();
            default:
                break;
        }
    }

}
