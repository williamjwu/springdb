package io.williamwu.springdb.serviceschool.service;

import io.williamwu.springdb.serviceschool.mapper.TeacherMapper;
import entity.Teacher;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class TeacherService implements dbService<Teacher> {

    @Resource
    private TeacherMapper mapper;

    public List<Teacher> getAll() {
        return mapper.getAll();
    }

    public List<Teacher> get(Teacher teacher) {
        return mapper.get(teacher);
    }

    public int insert(Teacher teacher) {
        return mapper.insert(teacher);
    }

    public int update(Teacher teacher) {
        return mapper.update(teacher);
    }

    public int delete(Teacher teacher) {
        return mapper.delete(teacher);
    }

}