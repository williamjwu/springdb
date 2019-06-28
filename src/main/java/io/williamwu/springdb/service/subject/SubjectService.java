package io.williamwu.springdb.service.subject;

import io.williamwu.springdb.Subject;
import io.williamwu.springdb.dao.SubjectDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SubjectService {

    @Autowired
    private SubjectDAO dao;

    public List<Subject> getSubject() {
        return dao.getSubject();
    }

    public List<Subject> getSpecSubject(String name) {
        return dao.getSpecSubject(name);
    }

    public int addSubject(Subject subject) {
        return dao.addSubject(subject);
    }

    public int updateSubject(String currName, String newName, String newDay, String newPeriod, Integer newTeacherId) {
        return dao.updateSubject(currName, newName, newDay, newPeriod, newTeacherId);
    }

    public int rmSubject(String name) {
        return dao.rmSubject(name);
    }
}