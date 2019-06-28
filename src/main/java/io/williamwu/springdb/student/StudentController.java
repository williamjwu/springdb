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
    public int addStudent(@RequestParam(name = "stu_name", required = true) String name,
                          @RequestParam(name = "stu_age", required = true) Integer age,
                          @RequestParam(name = "stu_gender", required = true) String gender) {
        gender = gender.toUpperCase();
        if (!gender.equals(Enums.Gender.MALE.toString()) && !gender.equals(Enums.Gender.FEMALE.toString())) {
            gender = "UNKNOWN";
        }
        Enums.Gender enumGender = Enums.Gender.valueOf(gender);
        return studentService.addStudent(new Student(null, name, age, enumGender));
    }

    @PostMapping(value = "/student/updateStudent")
    public int updateStudent(@RequestParam(name = "stu_name", required = true) String currName,
                             @RequestParam(name = "new_name", required = false) String newName,
                             @RequestParam(name = "new_age", required = false) Integer newAge,
                             @RequestParam(name = "new_gender", required = false) String newGender) {
        return studentService.updateStudent(currName, newName, newAge, newGender);
    }

    @DeleteMapping(value = "/student/rmStudent")
    public int rmStudent(@RequestParam(name="stu_name", required = true) String name) {
        if (name == null) {
            return 0;
        }
        return studentService.rmStudent(name);
    }

}
