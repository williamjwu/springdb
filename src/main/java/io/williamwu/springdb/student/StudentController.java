package io.williamwu.springdb.student;

import io.williamwu.springdb.Enums;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/student/getStudent")
    public List<Student> getStudent(@RequestParam(name = "stu_name", required = false) String name) {
        if (name == null) {
            return studentService.getStudent();
        }
        return studentService.getSpecStudent(name);

    }

    @PostMapping(value = "/student/addStudent")
    public int addStudent(@RequestParam(name="stu_name", required = true) String name, Integer age, String gender) {
        gender = gender.toUpperCase();
        if (!gender.equals(Enums.Gender.MALE.toString()) && !gender.equals(Enums.Gender.FEMALE.toString())) {
            gender = "UNKNOWN";
        }
        Enums.Gender enumGender = Enums.Gender.valueOf(gender);
        return studentService.addStudent(new Student(null, name, age, enumGender));
    }

    @DeleteMapping(value = "/student/rmStudent")
    public int rmStudent(@RequestParam(name="stu_name", required = true) String name) {
        if (name == null) {
            return 0;
        }
        return studentService.rmStudent(name);
    }

}
