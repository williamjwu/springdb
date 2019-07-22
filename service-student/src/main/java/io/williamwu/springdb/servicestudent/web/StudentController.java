package io.williamwu.springdb.servicestudent.web;

import entity.Student;
import entity.Subject;
import io.williamwu.springdb.servicestudent.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedList;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private DBService<Student> studentService;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${school.stuGetSbj}")
    private String stuGetSbjURL;

    @PostMapping(value = "/insert")
    public int insert(@RequestParam(name = "student_name") String name,
                      @RequestParam(name = "student_age") Integer age,
                      @RequestParam(name = "student_gender") String gender) {
        return studentService.insert(new Student(null, name, age, gender));
    }

    @GetMapping(value = "/", produces = "application/json")
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public List<Student> get(@PathVariable Integer id) {
        return studentService.get(new Student(id, null, null, null));
    }

    @PostMapping(value = "/getBatch", produces = "application/json")
    public List<Student> getBatch(@RequestBody List<Integer> list) {
        return studentService.getBatch(list);
    }

    @GetMapping(value = "/getSubjects", produces = "application/json")
    public List<Subject> studentGetSubjects(@RequestParam(name = "student_name") String name) {
        List<Student> studentCollection = studentService.get(new Student(null, name, null, null));
        List<Integer> studentIdCollection = new LinkedList<>();
        for (Student i : studentCollection) {
            studentIdCollection.add(i.getId());
        }
        HttpEntity<List<Integer>> entity = new HttpEntity<>(studentIdCollection, new HttpHeaders());
        ResponseEntity<List> response = restTemplate.postForEntity(stuGetSbjURL, entity, List.class);
        if (response == null) {
            return null;
        }
        return response.getBody();
    }

    @PostMapping(value = "/update")
    public int update(@RequestParam(name = "student_id") Integer id,
                      @RequestParam(name = "student_name", required = false) String newName,
                      @RequestParam(name = "student_age", required = false) Integer newAge,
                      @RequestParam(name = "student_gender", required = false) String newGender) {
        return studentService.update(new Student(id, newName, newAge, newGender));
    }

    @DeleteMapping(value = "/delete")
    public int delete(@RequestParam(name = "student_id") Integer id) {
        return studentService.delete(new Student(id, null, null, null));
    }

}
