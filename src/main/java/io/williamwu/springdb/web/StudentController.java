package io.williamwu.springdb.web;

import io.williamwu.springdb.entity.Student;
import io.williamwu.springdb.entity.Subject;
import io.williamwu.springdb.service.BridgeService;
import io.williamwu.springdb.service.dbService;
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

    @GetMapping(value = "/student")
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @GetMapping(value = "/student/{id}")
    public List<Student> get(@PathVariable Integer id) {
        Student student = new Student();
        student.setId(id);
        return studentService.get(student);
    }

    @GetMapping(value = "/student/getSubjects")
    public List<Subject> getSubjects(@RequestParam(name = "student_name") String name) {
        return bridgeService.studentFindSubjects(name);
    }

    @PostMapping(value = "/student/update")
    public int update(@RequestParam(name = "id") Integer id,
                      @RequestParam(name = "student_name", required = false) String newName,
                      @RequestParam(name = "student_age", required = false) Integer newAge,
                      @RequestParam(name = "student_gender", required = false) String newGender) {
        return studentService.update(new Student(id, newName, newAge, newGender));
    }

    @DeleteMapping(value = "/student/delete")
    public int delete(@RequestParam(name="id") Integer id) {
        Student student = new Student();
        student.setId(id);
        return studentService.delete(student);
    }

}
