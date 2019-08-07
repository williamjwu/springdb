package io.williamwu.springdb.serviceschool.dao;

import entity.Subject;
import entity.Teacher;

import java.util.List;

public interface BridgeMapper {

    List<Teacher> subjectGetTeachers(String name);

    List<Subject> teacherGetSubjects(String name);

    List<Integer> subjectGetStudents(String name);

    List<Integer> teacherGetStudents(String name);

    List<Subject> studentGetSubjects(List<Integer> list);

}