package io.williamwu.springdb.controller;

import io.williamwu.springdb.model.Subject;
import io.williamwu.springdb.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class SubjectController {

    @Autowired
    private Service<Subject> service;

    @GetMapping(value = "/subject/getAll")
    public List<Subject> getAll() {
        return service.getAll();
    }

    @GetMapping(value = "/subject/get")
    public Subject get(@RequestParam(name = "id") Integer id) {
        return service.get(id);
    }

    @PostMapping(value = "/subject/insert")
    public int insert(@RequestParam(name = "subject_name") String name,
                      @RequestParam(name = "subject_day") String day,
                      @RequestParam(name = "subject_period") String period) {
        return service.insert(new Subject(null, name, day, period));
    }

    @PostMapping(value = "/subject/update")
    public int update(@RequestParam(name = "id") Integer id,
                      @RequestParam(name = "subject_name", required = false) String newName,
                      @RequestParam(name = "subject_day", required = false) String newDay,
                      @RequestParam(name = "subject_period", required = false) String newPeriod,
                      @RequestParam(name = "teacher_id", required = false) Integer newTeacherId) {
        Subject subject = new Subject(id, newName, newDay, newPeriod);
        subject.setTeacherId(newTeacherId);
        return service.update(subject);
    }

    @DeleteMapping(value = "/subject/delete")
    public int delete(@RequestParam(name="id") Integer id) {
        return service.delete(id);
    }
}