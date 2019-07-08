package io.williamwu.springdb.service;

import io.williamwu.springdb.entity.Student;
import io.williamwu.springdb.entity.Subject;
import io.williamwu.springdb.entity.Teacher;
import io.williamwu.springdb.mapper.BridgeMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class BridgeService {

    @Resource
    private BridgeMapper mapper;

    public List<Student> subjectFindStudents(String name) {
        return mapper.subjectFindStudents(name);
    }

    public List<Teacher> subjectFindTeachers(String name) {
        return mapper.subjectFindTeachers(name);
    }

    public List<Subject> studentFindSubjects(String name) {
        return mapper.studentFindSubjects(name);
    }

    public List<Student> teacherFindStudents(String name) {
        return mapper.teacherFindStudents(name);
    }

    public List<Subject> teacherFindSubjects(String name) {
        return mapper.teacherFindSubjects(name);
    }
}
