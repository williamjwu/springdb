package io.williamwu.springdb.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentDAO dao;

    public List<Student> getStudents() {
        return dao.getStudents();
    }

    public List<Student> getSpecStudent(String name) {
        return dao.getSpecStudent(name);
    }
}
