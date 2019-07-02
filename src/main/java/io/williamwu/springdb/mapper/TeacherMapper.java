package io.williamwu.springdb.mapper;

import io.williamwu.springdb.model.Teacher;
import java.util.List;

public interface TeacherMapper {

    List<Teacher> getAll();

    Teacher get(Integer id);

    int insert(Teacher teacher);

    int update(Teacher teacher);

    int delete(Integer id);

}