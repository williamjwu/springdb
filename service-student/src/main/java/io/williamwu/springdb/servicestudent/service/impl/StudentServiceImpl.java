package io.williamwu.springdb.servicestudent.service.impl;

import entity.Student;
import io.williamwu.springdb.servicestudent.dao.StudentMapper;
import io.williamwu.springdb.servicestudent.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper mapper;

    public List<Student> getAll() {
        return mapper.getAll();
    }

    public List<Student> get(Student student) {
        return mapper.get(student);
    }

    public List<Student> getBatch(List<Integer> studentIdList) {
        return mapper.getBatch(studentIdList);
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
