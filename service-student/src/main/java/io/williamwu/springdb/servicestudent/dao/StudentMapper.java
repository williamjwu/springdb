package io.williamwu.springdb.servicestudent.dao;

import entity.Student;

import java.util.List;

public interface StudentMapper {

    List<Student> getAll();

    List<Student> get(Student student);

    List<Student> getBatch(List<Integer> studentIdList);

    int insert(Student student);

    int update(Student student);

    int delete(Student student);

}