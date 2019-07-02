package io.williamwu.springdb.mapper;

import io.williamwu.springdb.model.Subject;
import java.util.List;

public interface SubjectMapper {

    List<Subject> getAll();

    Subject get(Integer id);

    int insert(Subject subject);

    int update(Subject subject);

    int delete(Integer id);

}