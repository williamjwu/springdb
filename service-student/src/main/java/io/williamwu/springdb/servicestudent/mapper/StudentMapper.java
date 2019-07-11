package io.williamwu.springdb.servicestudent.mapper;

import io.williamwu.springdb.servicestudent.entity.Student;

import java.util.List;

public interface StudentMapper {

    List<Student> getAll();

    List<Student> get(Student student);

    int insert(Student student);

    int update(Student student);

    int delete(Student student);

}