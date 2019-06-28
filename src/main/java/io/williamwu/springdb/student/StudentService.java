package io.williamwu.springdb.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentDAO dao;

    public List<Student> getStudent() {
        return dao.getStudent();
    }

    public List<Student> getSpecStudent(String name) {
        return dao.getSpecStudent(name);
    }

    public int addStudent(Student student) {
        return dao.addStudent(student);
    }

    public int updateStudent(String currName, String newName, Integer newAge, String newGender) {
        return dao.updateStudent(currName, newName, newAge, newGender);
    }

    public int rmStudent(String name) {
        return dao.rmStudent(name);
    }
}
