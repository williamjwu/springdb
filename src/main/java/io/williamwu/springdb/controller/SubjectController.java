//package io.williamwu.springdb.controller;
//
//import io.williamwu.springdb.enums.DayEnum;
//import io.williamwu.springdb.enums.PeriodEnum;
//import io.williamwu.springdb.model.Subject;
//import io.williamwu.springdb.service.SubjectService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import java.util.List;
//
//@RestController
//public class SubjectController {
//
//    @Autowired
//    private SubjectService service;
//
//    @GetMapping(value = "/subject/getSubject")
//    public List<Subject> get(@RequestParam(name = "subject_name", required = false) String name) {
//        if (name == null) {
//            return service.getSubject();
//        }
//        return service.getSpecSubject(name);
//    }
//
//    @PostMapping(value = "/subject/addSubject")
//    public int add(@RequestParam(name = "subject_name", required = true) String name,
//                          @RequestParam(name = "subject_day", required = true) String day,
//                          @RequestParam(name = "subject_period", required = true) String period) {
//        DayEnum enumDay;
//        try {
//            enumDay = DayEnum.valueOf(day.toUpperCase());
//        } catch (Exception ex) {
//            enumDay = DayEnum.UNKNOWN;
//        }
//
//        PeriodEnum enumPeriod;
//        try {
//            enumPeriod = PeriodEnum.valueOf(period.toUpperCase());
//        } catch (Exception ex) {
//            enumPeriod = PeriodEnum.UNKNOWN;
//        }
//
//        return service.addSubject(new Subject(null, name, enumDay, enumPeriod));
//    }
//
//    @PostMapping(value = "/subject/updateSubject")
//    public int update(@RequestParam(name = "subject_name", required = true) String currName,
//                             @RequestParam(name = "new_name", required = false) String newName,
//                             @RequestParam(name = "new_day", required = false) String newDay,
//                             @RequestParam(name = "new_period", required = false) String newPeriod,
//                             @RequestParam(name = "new_teacher_id", required = false) Integer newTeacherId) {
//        return service.updateSubject(currName, newName, newDay, newPeriod, newTeacherId);
//    }
//
//    @DeleteMapping(value = "/subject/rmSubject")
//    public int rm(@RequestParam(name="subject_name", required = true) String name) {
//        if (name == null) {
//            return 0;
//        }
//        return service.rmSubject(name);
//    }
//}