package io.williamwu.springdb.servicestudent.service;

import io.williamwu.springdb.servicestudent.entity.Student;
import io.williamwu.springdb.servicestudent.mapper.BridgeMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class BridgeService {

    @Resource
    private BridgeMapper mapper;

    public List<Student> subjectGetStudents(String name) {
        return mapper.subjectGetStudents(name);
    }

    public List<Student> teacherGetStudents(String name) {
        return mapper.teacherGetStudents(name);
    }

}
