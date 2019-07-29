package io.williamwu.springdb.serviceschool.service;

import entity.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> getAll();

    List<Teacher> get(Teacher obj);

    int insert(Teacher obj);

    int update(Teacher obj);

    int delete(Teacher obj);

}
