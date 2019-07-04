package io.williamwu.springdb.service;

import io.williamwu.springdb.mapper.SubjectMapper;
import io.williamwu.springdb.entity.Subject;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class SubjectService implements dbService<Subject> {

    @Resource
    private SubjectMapper mapper;

    public List<Subject> getAll() {
        return mapper.getAll();
    }

    public List<Subject> get(Subject subject) {
        return mapper.get(subject);
    }

    public int insert(Subject subject) {
        return mapper.insert(subject);
    }

    public int update(Subject subject) {
        return mapper.update(subject);
    }

    public int delete(Subject subject) {
        return mapper.delete(subject);
    }

}