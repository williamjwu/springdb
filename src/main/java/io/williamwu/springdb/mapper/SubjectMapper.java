package io.williamwu.springdb.mapper;

import io.williamwu.springdb.entity.Subject;
import java.util.List;

public interface SubjectMapper {

    List<Subject> getAll();

    List<Subject> get(Subject subject);

    int insert(Subject subject);

    int update(Subject subject);

    int delete(Subject subject);

}