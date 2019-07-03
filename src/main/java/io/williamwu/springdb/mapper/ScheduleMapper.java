package io.williamwu.springdb.mapper;

import io.williamwu.springdb.model.Schedule;
import java.util.List;

public interface ScheduleMapper {

    List<Schedule> getAll();

    Schedule get(Integer id);

    int insert(Schedule schedule);

    int update(Schedule schedule);

    int delete(Integer id);

}
