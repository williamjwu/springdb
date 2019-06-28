package io.williamwu.springdb.service.student;

import io.williamwu.springdb.Student;
import io.williamwu.springdb.dao.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService implements io.williamwu.springdb.service.Service<Student> {

    @Autowired
    private StudentDAO dao;

    public List<Student> get() {
        return dao.get();
    }

    public List<Student> get(String name) {
        return dao.get(name);
    }

    public int add(Student student) {
        return dao.add(student);
    }

    public int update(String currName, String newName, Integer newAge, String newGender) {
        return dao.update(currName, newName, newAge, newGender);
    }

    public int rm(String name) {
        return dao.rm(name);
    }
}
