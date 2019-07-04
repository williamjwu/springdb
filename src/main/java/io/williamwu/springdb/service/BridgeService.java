package io.williamwu.springdb.service;

import io.williamwu.springdb.mapper.BridgeMapper;
import io.williamwu.springdb.model.Subject;
import io.williamwu.springdb.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

@Service
public class BridgeService {

    @Resource
    private BridgeMapper mapper;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private SubjectService subjectService;

    public List<Teacher> subjectFindTeachers(String name) {
        List<Teacher> teacherList = new LinkedList<>();
        List<Subject> subjectList = subjectService.get(new Subject(null, name, null, null));
        for (Subject i : subjectList) {
            teacherList.addAll(mapper.subjectFindTeachers(i));
        }
        return teacherList;
    }

    public List<Subject> teacherFindSubjects(String name) {
        List<Subject> subjectList = new LinkedList<>();
        List<Teacher> teacherList = teacherService.get(new Teacher(null, name, null, null));
        for (Teacher i : teacherList) {
            subjectList.addAll(mapper.teacherFindSubjects(i));
        }
        return subjectList;
    }
}
