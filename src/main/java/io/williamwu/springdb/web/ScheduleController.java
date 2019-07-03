package io.williamwu.springdb.web;

import io.williamwu.springdb.model.Schedule;
import io.williamwu.springdb.service.dbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ScheduleController {

    @Autowired
    private dbService<Schedule> service;

    @GetMapping(value = "/schedule/getAll")
    public List<Schedule> getAll() {
        return service.getAll();
    }

    @GetMapping(value = "/schedule/get")
    public Schedule get(@RequestParam(name = "id") Integer id) {
        return service.get(id);
    }

    @PostMapping(value = "/schedule/insert")
    public int insert(@RequestParam(name = "student_id") Integer studentId,
                      @RequestParam(name = "subject_id") Integer subjectId) {
        return service.insert(new Schedule(null, studentId, subjectId));
    }

    @PostMapping(value = "/schedule/update")
    public int update(@RequestParam(name = "id") Integer id,
                      @RequestParam(name = "student_id", required = false) Integer studentId,
                      @RequestParam(name = "subject_id", required = false) Integer subjectId) {
        return service.update(new Schedule(id, studentId, subjectId));
    }

    @DeleteMapping(value = "/schedule/delete")
    public int delete(@RequestParam(name="id") Integer id) {
        return service.delete(id);
    }

}