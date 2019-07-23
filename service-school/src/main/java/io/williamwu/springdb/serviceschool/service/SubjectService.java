package io.williamwu.springdb.serviceschool.service;

import entity.Schedule;
import entity.Subject;
import io.williamwu.springdb.serviceschool.dao.SubjectMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SubjectService implements DBService<Subject> {

    @Resource
    private SubjectMapper mapper;

    @Resource
    private ScheduleService scheduleService;

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

    public int updateTeacherId(Subject subject) {
        Schedule schedule = new Schedule();
        schedule.setSubjectId(subject.getId());
        if (!scheduleService.get(schedule).isEmpty() && subject.getTeacherId() == null) {
            System.out.println("Cannot remove a teacher. Remove all student from the class before removing the course teacher");
            return -1;
        }
        schedule.setTeacherId(subject.getTeacherId());
        return mapper.updateTeacherId(subject) + scheduleService.updateTeacherId(schedule);
    }

}