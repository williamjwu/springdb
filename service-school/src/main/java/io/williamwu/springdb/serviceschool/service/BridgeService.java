package io.williamwu.springdb.serviceschool.service;

import entity.Student;
import entity.Subject;
import entity.Teacher;
import io.williamwu.springdb.serviceschool.mapper.BridgeMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class BridgeService {

    @Resource
    private BridgeMapper mapper;

    public List<Teacher> subjectGetTeachers(String name) {
        return mapper.subjectGetTeachers(name);
    }

    public List<Subject> teacherGetSubjects(String name) {
        return mapper.teacherGetSubjects(name);
    }

    public List<Student> subjectGetStudents(String name) {
        return mapper.subjectGetStudents(name);
    }

    public List<Student> teacherGetStudents(String name) {
        return mapper.teacherGetStudents(name);
    }
}
