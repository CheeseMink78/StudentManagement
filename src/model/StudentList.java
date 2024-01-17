
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class StudentList {
    private ArrayList<Student> listStudent=new ArrayList<>();

    public StudentList() {
    }

    public ArrayList<Student> getListStudent() {
        return listStudent;
    }
    public boolean addStudent(Student student) { 
        for(Student st:listStudent) {
            if (st.equals(student)) {
                st.totalCourse++;
                return true;
            }
        }
        listStudent.add(student);
        return true;
    }
    public void updateStudent(int id) {
        
    }
    public void deleleStudent(int id) {
            listStudent.removeIf((Student p) -> p.getId()==(id));
    }
    public ArrayList<Student> search(Predicate<Student> p) {
        ArrayList<Student> listSearch = new ArrayList<>();
        for (Student student : listStudent) {
            if (p.test(student)) {
                listSearch.add(student);
            }
        }
        return listSearch;
    }
}
