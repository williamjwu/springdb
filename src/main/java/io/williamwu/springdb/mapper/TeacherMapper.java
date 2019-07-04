package io.williamwu.springdb.mapper;

import io.williamwu.springdb.entity.Teacher;
import java.util.List;

public interface TeacherMapper {

    List<Teacher> getAll();

    List<Teacher> get(Teacher teacher);

    int insert(Teacher teacher);

    int update(Teacher teacher);

    int delete(Teacher teacher);

}