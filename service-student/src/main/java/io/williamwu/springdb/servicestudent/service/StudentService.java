package io.williamwu.springdb.servicestudent.service;

import entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAll();

    List<Student> get(Student obj);

    List<Student> getBatch(List<Integer> obj);

    int insert(Student obj);

    int update(Student obj);

    int delete(Student obj);

}