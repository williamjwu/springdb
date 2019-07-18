package io.williamwu.springdb.servicestudent.web;

import entity.Student;
import entity.Subject;
import io.williamwu.springdb.servicestudent.service.dbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.LinkedList;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private dbService<Student> studentService;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping(value = "/insert")
    public int insert(@RequestParam(name = "student_name") String name,
                      @RequestParam(name = "student_age") Integer age,
                      @RequestParam(name = "student_gender") String gender) {
        return studentService.insert(new Student(null, name, age, gender));
    }

    @GetMapping(value = "/")
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @GetMapping(value = "/{id}")
    public List<Student> get(@PathVariable Integer id) {
        return studentService.get(new Student(id, null, null, null));
    }

    @GetMapping(value = "/getSubjects")
    public List<Subject> studentGetSubjects(@RequestParam(name = "student_name") String name) {
        List<Student> studentCollection = studentService.get(new Student(null, name, null, null));
        List<Subject> subjectList = new LinkedList<>();
        for (Student i : studentCollection) {
            final String url = "http://service-school/studentGetSubjects/" + i.getId();
            subjectList.addAll(restTemplate.getForObject(url, List.class));
        }
        return subjectList;
    }

    @PostMapping(value = "/update")
    public int update(@RequestParam(name = "student_id") Integer id,
                      @RequestParam(name = "student_name", required = false) String newName,
                      @RequestParam(name = "student_age", required = false) Integer newAge,
                      @RequestParam(name = "student_gender", required = false) String newGender) {
        return studentService.update(new Student(id, newName, newAge, newGender));
    }

    @DeleteMapping(value = "/delete")
    public int delete(@RequestParam(name="student_id") Integer id) {
        return studentService.delete(new Student(id, null, null, null));
    }

}
