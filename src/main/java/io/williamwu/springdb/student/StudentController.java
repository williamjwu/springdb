package io.williamwu.springdb.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/student/getStudents", method = RequestMethod.GET)
    public List<Student> getStudents(@RequestParam(name = "stu_name", required = false) String name) {
        if (name == null) {
            return studentService.getStudents();
        } else {
            return studentService.getSpecStudent(name);
        }
    }

    @RequestMapping(value = "/student/addStudents", method = RequestMethod.POST)
    public int addStudents(@RequestParam(name="stu_name", required = true) String name) {
        System.out.println("post name: "+name);
        return 1;
    }

}
