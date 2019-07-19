package io.williamwu.springdb.serviceschool.web;

import entity.Student;
import entity.Subject;
import entity.Teacher;

import io.williamwu.springdb.serviceschool.service.BridgeService;
import io.williamwu.springdb.serviceschool.service.dbService;
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
public class TeacherController {

    @Autowired
    private dbService<Teacher> teacherService;

    @Autowired
    private BridgeService bridgeService;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${student.get}")
    private String getStudentURL;

    @PostMapping(value = "/teacher/insert")
    public int insert(@RequestParam(name = "teacher_name") String name,
                      @RequestParam(name = "teacher_age") Integer age,
                      @RequestParam(name = "teacher_gender") String gender) {
        return teacherService.insert(new Teacher(null, name, age, gender));
    }

    @GetMapping(value = "/teacher", produces = "application/json")
    public List<Teacher> getAll() {
        return teacherService.getAll();
    }

    @GetMapping(value = "/teacher/{id}", produces = "application/json")
    public List<Teacher> get(@PathVariable Integer id) {
        return teacherService.get(new Teacher(id, null, null, null));
    }

    @GetMapping(value = "/teacher/getSubjects", produces = "application/json")
    public List<Subject> teacherGetSubjects(@RequestParam(name = "teacher_name") String name) {
        return bridgeService.teacherGetSubjects(name);
    }

    @GetMapping(value = "/teacher/getStudents", produces = "application/json")
    public List<Student> teacherGetStudents(@RequestParam(name = "teacher_name") String name) {
        List<Integer> studentIdCollection = bridgeService.teacherGetStudents(name);
        HttpEntity<List<Integer>> entity = new HttpEntity<>(studentIdCollection, new HttpHeaders());
        ResponseEntity<List> response = restTemplate.postForEntity(getStudentURL, entity, List.class);
        if (response == null) {
            return null;
        }
        return response.getBody();
    }

    @PostMapping(value = "/teacher/update")
    public int update(@RequestParam(name = "teacher_id") Integer id,
                      @RequestParam(name = "teacher_name", required = false) String newName,
                      @RequestParam(name = "teacher_age", required = false) Integer newAge,
                      @RequestParam(name = "teacher_gender", required = false) String newGender) {
        return teacherService.update(new Teacher(id, newName, newAge, newGender));
    }

    @DeleteMapping(value = "/teacher/delete")
    public int delete(@RequestParam(name="teacher_id") Integer id) {
        return teacherService.delete(new Teacher(id, null, null, null));
    }
}