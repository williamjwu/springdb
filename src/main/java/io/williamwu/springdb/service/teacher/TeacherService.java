package io.williamwu.springdb.service.teacher;

import io.williamwu.springdb.Teacher;
import io.williamwu.springdb.dao.TeacherDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TeacherService implements io.williamwu.springdb.service.Service<Teacher> {

    @Autowired
    private TeacherDAO dao;

    public List<Teacher> get() {
        return dao.get();
    }

    public List<Teacher> get(String name) {
        return dao.get(name);
    }

    public int add(Teacher teacher) {
        return dao.add(teacher);
    }

    public int update(String currName, String newName, Integer newAge, String newGender) {
        return dao.update(currName, newName, newAge, newGender);
    }

    public int rm(String name) {
        return dao.rm(name);
    }
}