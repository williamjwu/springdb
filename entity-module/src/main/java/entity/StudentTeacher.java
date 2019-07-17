package entity;

import java.util.List;

public class StudentTeacher {

    private List<Teacher> teacherList;
    private List<Student> studentList;

    public StudentTeacher(List<Teacher> teacherList, List<Student> studentList) {
        this.teacherList = teacherList;
        this.studentList = studentList;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
