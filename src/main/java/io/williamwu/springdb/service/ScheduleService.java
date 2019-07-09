package io.williamwu.springdb.service;

import io.williamwu.springdb.entity.Subject;
import io.williamwu.springdb.mapper.ScheduleMapper;
import io.williamwu.springdb.entity.Schedule;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ScheduleService implements dbService<Schedule> {

    @Resource
    private ScheduleMapper mapper;

    @Resource
    private SubjectService subjectService;

    public List<Schedule> getAll() {
        return mapper.getAll();
    }

    public List<Schedule> get(Schedule schedule) {
        return mapper.get(schedule);
    }

    public int insert(Schedule schedule) {
        try {
            Subject subject = subjectService
                    .get(new Subject(schedule.getSubjectId(), null, null, null))
                    .get(0);
            if (subject.getTeacherId() == null) {
                System.out.println("Link a teacher before adding a student to class!");
                return -1;
            }
            schedule.setTeacherId(subject.getTeacherId());
            return mapper.insert(schedule) + mapper.updateTeacherId(schedule);
        } catch (Exception ex) {
            System.out.println("Subject is not found!");
            return -1;
        }
    }

    public int update(Schedule schedule) {
        return mapper.update(schedule);
    }

    public int delete(Schedule schedule) {
        return mapper.delete(schedule);
    }

    public int updateTeacherId(Schedule schedule) {
        return mapper.updateTeacherId(schedule);
    }

}
