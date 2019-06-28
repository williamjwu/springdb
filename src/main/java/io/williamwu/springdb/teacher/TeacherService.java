package io.williamwu.springdb.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherDAO dao;

    public List<Teacher> getTeacher() {
        return dao.getTeacher();
    }

    public List<Teacher> getSpecTeacher(String name) {
        return dao.getSpecTeacher(name);
    }

    public int addTeacher(Teacher teacher) {
        return dao.addTeacher(teacher);
    }

    public int rmTeacher(String name) {
        return dao.rmTeacher(name);
    }
}