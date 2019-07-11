package io.williamwu.springdb.servicestudent.service;

import io.williamwu.springdb.servicestudent.mapper.StudentMapper;
import io.williamwu.springdb.servicestudent.entity.Student;
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
