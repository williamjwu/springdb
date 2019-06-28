package io.williamwu.springdb.controller;

import io.williamwu.springdb.Enums;
import io.williamwu.springdb.Student;
import io.williamwu.springdb.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping(value = "/student/getStudent")
    public List<Student> get(@RequestParam(name = "stu_name", required = false) String name) {
        if (name == null) {
            return service.get();
        }
        return service.get(name);
    }

    @PostMapping(value = "/student/addStudent")
    public int add(@RequestParam(name = "stu_name", required = true) String name,
                          @RequestParam(name = "stu_age", required = true) Integer age,
                          @RequestParam(name = "stu_gender", required = true) String gender) {
        Enums.Gender enumGender;
        try {
            enumGender = Enums.Gender.valueOf(gender.toUpperCase());
        } catch (Exception ex) {
            enumGender = Enums.Gender.UNKNOWN;
        }
        return service.add(new Student(null, name, age, enumGender));
    }

    @PostMapping(value = "/student/updateStudent")
    public int update(@RequestParam(name = "stu_name", required = true) String currName,
                             @RequestParam(name = "new_name", required = false) String newName,
                             @RequestParam(name = "new_age", required = false) Integer newAge,
                             @RequestParam(name = "new_gender", required = false) String newGender) {
        return service.update(currName, newName, newAge, newGender);
    }

    @DeleteMapping(value = "/student/rmStudent")
    public int rm(@RequestParam(name="stu_name", required = true) String name) {
        if (name == null) {
            return 0;
        }
        return service.rm(name);
    }

}
