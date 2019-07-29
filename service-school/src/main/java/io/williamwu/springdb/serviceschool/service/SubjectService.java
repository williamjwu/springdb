package io.williamwu.springdb.serviceschool.service;

import entity.Subject;

import java.util.List;

public interface SubjectService {

    List<Subject> getAll();

    List<Subject> get(Subject obj);

    int insert(Subject obj);

    int update(Subject obj);

    int delete(Subject obj);

    int updateTeacherId(Subject subject);

}
