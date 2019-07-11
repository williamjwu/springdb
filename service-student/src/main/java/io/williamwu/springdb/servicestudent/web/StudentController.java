package io.williamwu.springdb.servicestudent.web;

import io.williamwu.springdb.servicestudent.entity.Student;
import io.williamwu.springdb.servicestudent.service.BridgeService;
import io.williamwu.springdb.servicestudent.service.dbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private dbService<Student> studentService;

    @Autowired
    private BridgeService bridgeService;

    @PostMapping(value = "/student/insert")
    public int insert(@RequestParam(name = "student_name") String name,
                      @RequestParam(name = "student_age") Integer age,
                      @RequestParam(name = "student_gender") String gender) {
        return studentService.insert(new Student(null, name, age, gender));
    }

    @GetMapping(value = "/student/get")
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @GetMapping(value = "/student/get/{id}")
    public List<Student> get(@PathVariable Integer id) {
        return studentService.get(new Student(id, null, null, null));
    }

    @GetMapping(value = "/subject/getStudents")
    public List<Student> subjectGetStudents(@RequestParam(name = "subject_name") String name) {
        return bridgeService.subjectGetStudents(name);
    }

    @GetMapping(value = "/teacher/getStudents")
    public List<Student> teacherGetStudents(@RequestParam(name = "teacher_name") String name) {
        return bridgeService.teacherGetStudents(name);
    }

    @PostMapping(value = "/student/update")
    public int update(@RequestParam(name = "student_id") Integer id,
                      @RequestParam(name = "student_name", required = false) String newName,
                      @RequestParam(name = "student_age", required = false) Integer newAge,
                      @RequestParam(name = "student_gender", required = false) String newGender) {
        return studentService.update(new Student(id, newName, newAge, newGender));
    }

    @DeleteMapping(value = "/student/delete")
    public int delete(@RequestParam(name="student_id") Integer id) {
        return studentService.delete(new Student(id, null, null, null));
    }

}
