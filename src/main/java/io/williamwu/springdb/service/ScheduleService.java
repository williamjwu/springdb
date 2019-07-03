package io.williamwu.springdb.service;

import io.williamwu.springdb.mapper.ScheduleMapper;
import io.williamwu.springdb.model.Schedule;
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

    public Schedule get(Integer id) {
        return mapper.get(id);
    }

    public int insert(Schedule schedule) {
        return mapper.insert(schedule);
    }

    public int update(Schedule schedule) {
        return mapper.update(schedule);
    }

    public int delete(Integer id) {
        return mapper.delete(id);
    }

}
