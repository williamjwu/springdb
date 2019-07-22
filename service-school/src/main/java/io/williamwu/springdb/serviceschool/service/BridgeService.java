package io.williamwu.springdb.serviceschool.service;

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

    // Internal access only
    public List<Teacher> subjectGetTeachers(String name) {
        return mapper.subjectGetTeachers(name);
    }

    public List<Subject> teacherGetSubjects(String name) {
        return mapper.teacherGetSubjects(name);
    }

    // Needs to access student service to get complete info
    public List<Integer> subjectGetStudents(String name) {
        return mapper.subjectGetStudents(name);
    }

    public List<Integer> teacherGetStudents(String name) {
        return mapper.teacherGetStudents(name);
    }

    public List<Subject> studentGetSubjects(List<Integer> list) {
        return mapper.studentGetSubjects(list);
    }
}
