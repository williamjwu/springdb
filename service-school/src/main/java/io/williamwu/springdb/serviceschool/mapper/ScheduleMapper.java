package io.williamwu.springdb.serviceschool.mapper;

import io.williamwu.springdb.serviceschool.entity.Schedule;
import java.util.List;

public interface ScheduleMapper {

    List<Schedule> getAll();

    List<Schedule> get(Schedule schedule);

    int insert(Schedule schedule);

    int update(Schedule schedule);

    int delete(Schedule schedule);

    int updateTeacherId(Schedule schedule);

}
