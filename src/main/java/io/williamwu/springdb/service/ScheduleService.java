package io.williamwu.springdb.service;

import io.williamwu.springdb.mapper.ScheduleMapper;
import io.williamwu.springdb.entity.Schedule;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class ScheduleService implements dbService<Schedule> {

    @Resource
    private ScheduleMapper mapper;

    public List<Schedule> getAll() {
        return mapper.getAll();
    }

    public List<Schedule> get(Schedule schedule) {
        return mapper.get(schedule);
    }

    public int insert(Schedule schedule) {
        return mapper.insert(schedule);
    }

    public int update(Schedule schedule) {
        return mapper.update(schedule);
    }

    public int delete(Schedule schedule) {
        return mapper.delete(schedule);
    }

}
