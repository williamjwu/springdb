package io.williamwu.springdb.service;

import io.williamwu.springdb.mapper.StudentMapper;
import io.williamwu.springdb.model.Student;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentService implements dbService<Student> {

    @Resource
    private StudentMapper mapper;

    public List<Student> getAll() {
        return mapper.getAll();
    }

    public List<Student> get(Student student) {
        return mapper.get(student);
    }

    public int insert(Student student) {
        return mapper.insert(student);
    }

    public int update(Student student) {
        return mapper.update(student);
    }

    public int delete(Student student) {
        return mapper.delete(student);
    }

}
