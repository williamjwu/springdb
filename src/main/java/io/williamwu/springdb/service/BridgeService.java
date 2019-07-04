package io.williamwu.springdb.service;

import io.williamwu.springdb.mapper.BridgeMapper;
import io.williamwu.springdb.entity.Student;
import io.williamwu.springdb.entity.Subject;
import io.williamwu.springdb.entity.Teacher;
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

    @Autowired
    private StudentService studentService;

    public List<Student> subjectFindStudents(String name) {
        List<Student> studentList = new LinkedList<>();
        List<Subject> subjectList = subjectService.get(new Subject(null, name, null, null));
        for (Subject i : subjectList) {
            studentList.addAll(mapper.subjectFindStudents(i));
        }
        return studentList;
    }

    public List<Teacher> subjectFindTeachers(String name) {
        List<Teacher> teacherList = new LinkedList<>();
        List<Subject> subjectList = subjectService.get(new Subject(null, name, null, null));
        for (Subject i : subjectList) {
            teacherList.addAll(mapper.subjectFindTeachers(i));
        }
        return teacherList;
    }

    public List<Subject> studentFindSubjects(String name) {
        List<Subject> subjectList = new LinkedList<>();
        List<Student> studentList = studentService.get(new Student(null, name, null, null));
        for (Student i : studentList) {
            subjectList.addAll(mapper.studentFindSubjects(i));
        }
        return subjectList;
    }

    public List<Student> teacherFindStudents(String name) {
        List<Student> studentList = new LinkedList<>();
        List<Teacher> teacherList = teacherService.get(new Teacher(null, name, null, null));
        for (Teacher i : teacherList) {
            studentList.addAll(mapper.teacherFindStudents(i));
        }
        return studentList;
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
