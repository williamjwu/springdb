package io.williamwu.springdb.web;

import io.williamwu.springdb.model.Student;
import io.williamwu.springdb.service.dbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private dbService<Student> service;

    @GetMapping(value = "/student/getAll")
    public List<Student> getAll() {
        return service.getAll();
    }

    @GetMapping(value = "/student/get")
    public Student get(@RequestParam(name = "id") Integer id) {
        return service.get(id);
    }

    @PostMapping(value = "/student/insert")
    public int insert(@RequestParam(name = "student_name") String name,
                      @RequestParam(name = "student_age") Integer age,
                      @RequestParam(name = "student_gender") String gender) {
        return service.insert(new Student(null, name, age, gender));
    }

    @PostMapping(value = "/student/update")
    public int update(@RequestParam(name = "id") Integer id,
                      @RequestParam(name = "student_name", required = false) String newName,
                      @RequestParam(name = "student_age", required = false) Integer newAge,
                      @RequestParam(name = "student_gender", required = false) String newGender) {
        return service.update(new Student(id, newName, newAge, newGender));
    }

    @DeleteMapping(value = "/student/delete")
    public int delete(@RequestParam(name="id") Integer id) {
        return service.delete(id);
    }

}