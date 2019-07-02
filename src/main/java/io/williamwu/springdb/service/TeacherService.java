package io.williamwu.springdb.service;

import io.williamwu.springdb.mapper.TeacherMapper;
import io.williamwu.springdb.model.Teacher;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class TeacherService implements io.williamwu.springdb.service.Service<Teacher> {

    @Resource
    private TeacherMapper mapper;

    public List<Teacher> getAll() {
        return mapper.getAll();
    }

    public Teacher get(Integer id) {
        return mapper.get(id);
    }

    public int insert(Teacher teacher) {
        return mapper.insert(teacher);
    }

    public int update(Teacher teacher) {
        return mapper.update(teacher);
    }

    public int delete(Integer id) {
        return mapper.delete(id);
    }

}