package io.williamwu.springdb.controller;

import io.williamwu.springdb.Enums;
import io.williamwu.springdb.Subject;
import io.williamwu.springdb.service.subject.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class SubjectController {

    @Autowired
    private SubjectService service;

    @GetMapping(value = "/subject/getSubject")
    public List<Subject> get(@RequestParam(name = "sub_name", required = false) String name) {
        if (name == null) {
            return service.getSubject();
        }
        return service.getSpecSubject(name);
    }

    @PostMapping(value = "/subject/addSubject")
    public int add(@RequestParam(name = "sub_name", required = true) String name,
                          @RequestParam(name = "sub_day", required = true) String day,
                          @RequestParam(name = "sub_period", required = true) String period) {
        Enums.Day enumDay;
        try {
            enumDay = Enums.Day.valueOf(day.toUpperCase());
        } catch (Exception ex) {
            enumDay = Enums.Day.UNKNOWN;
        }

        Enums.Period enumPeriod;
        try {
            enumPeriod = Enums.Period.valueOf(period.toUpperCase());
        } catch (Exception ex) {
            enumPeriod = Enums.Period.UNKNOWN;
        }

        return service.addSubject(new Subject(null, name, enumDay, enumPeriod));
    }

    @PostMapping(value = "/subject/updateSubject")
    public int update(@RequestParam(name = "sub_name", required = true) String currName,
                             @RequestParam(name = "new_name", required = false) String newName,
                             @RequestParam(name = "new_day", required = false) String newDay,
                             @RequestParam(name = "new_period", required = false) String newPeriod,
                             @RequestParam(name = "new_teacher_id", required = false) Integer newTeacherId) {
        return service.updateSubject(currName, newName, newDay, newPeriod, newTeacherId);
    }

    @DeleteMapping(value = "/subject/rmSubject")
    public int rm(@RequestParam(name="sub_name", required = true) String name) {
        if (name == null) {
            return 0;
        }
        return service.rmSubject(name);
    }
}