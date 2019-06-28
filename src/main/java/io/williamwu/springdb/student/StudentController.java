package io.williamwu.springdb.student;

import io.williamwu.springdb.Enums;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping(value = "/student/getStudent")
    public List<Student> getStudent(@RequestParam(name = "stu_name", required = false) String name) {
        if (name == null) {
            return service.getStudent();
        }
        return service.getSpecStudent(name);
    }

    @PostMapping(value = "/student/addStudent")
    public int addStudent(@RequestParam(name = "stu_name", required = true) String name,
                          @RequestParam(name = "stu_age", required = true) Integer age,
                          @RequestParam(name = "stu_gender", required = true) String gender) {
        Enums.Gender enumGender;
        try {
            enumGender = Enums.Gender.valueOf(gender.toUpperCase());
        } catch (Exception ex) {
            enumGender = Enums.Gender.UNKNOWN;
        }
        return service.addStudent(new Student(null, name, age, enumGender));
    }

    @PostMapping(value = "/student/updateStudent")
    public int updateStudent(@RequestParam(name = "stu_name", required = true) String currName,
                             @RequestParam(name = "new_name", required = false) String newName,
                             @RequestParam(name = "new_age", required = false) Integer newAge,
                             @RequestParam(name = "new_gender", required = false) String newGender) {
        return service.updateStudent(currName, newName, newAge, newGender);
    }

    @DeleteMapping(value = "/student/rmStudent")
    public int rmStudent(@RequestParam(name="stu_name", required = true) String name) {
        if (name == null) {
            return 0;
        }
        return service.rmStudent(name);
    }

}
