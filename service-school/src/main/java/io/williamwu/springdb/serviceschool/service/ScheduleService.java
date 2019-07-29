package io.williamwu.springdb.serviceschool.service;

import entity.Schedule;

import java.util.List;

public interface ScheduleService {

    List<Schedule> getAll();

    List<Schedule> get(Schedule obj);

    int insert(Schedule obj);

    int update(Schedule obj);

    int delete(Schedule obj);

    int updateTeacherId(Schedule subject);

}
