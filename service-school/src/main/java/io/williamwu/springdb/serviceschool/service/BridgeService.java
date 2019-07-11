package io.williamwu.springdb.serviceschool.service;

import io.williamwu.springdb.serviceschool.entity.Subject;
import io.williamwu.springdb.serviceschool.entity.Teacher;
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

    public List<Subject> studentGetSubjects(String name) {
        return mapper.studentGetSubjects(name);
    }

    public List<Subject> teacherGetSubjects(String name) {
        return mapper.teacherGetSubjects(name);
    }
}
