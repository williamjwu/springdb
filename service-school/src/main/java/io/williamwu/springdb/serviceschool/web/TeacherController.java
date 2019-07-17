package io.williamwu.springdb.serviceschool.web;

import entity.Student;
import entity.Subject;
import entity.Teacher;
import io.williamwu.springdb.serviceschool.service.BridgeService;
import io.williamwu.springdb.serviceschool.service.dbService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping(value = "/teacher/insert")
    public int insert(@RequestParam(name = "teacher_name") String name,
                      @RequestParam(name = "teacher_age") Integer age,
                      @RequestParam(name = "teacher_gender") String gender) {
        return teacherService.insert(new Teacher(null, name, age, gender));
    }

    @GetMapping(value = "/teacher")
    public List<Teacher> getAll() {
        return teacherService.getAll();
    }

    @GetMapping(value = "/teacher/{id}")
    public List<Teacher> get(@PathVariable Integer id) {
        return teacherService.get(new Teacher(id, null, null, null));
    }

    @GetMapping(value = "/teacher/getSubjects")
    public List<Subject> teacherGetSubjects(@RequestParam(name = "teacher_name") String name) {
        return bridgeService.teacherGetSubjects(name);
    }

    @GetMapping(value = "/teacher/getStudents")
    public List<Student> teacherGetStudents(@RequestParam(name = "teacher_name") String name) {
        RestTemplate restTemplate = new RestTemplate();
        List<Integer> studentIdCollection = bridgeService.teacherGetStudents(name);
        List<Student> studentList = new LinkedList<>();
        for (Integer i : studentIdCollection) {
            final String url = "http://localhost:9082/" + i;
            studentList.addAll(restTemplate.getForObject(url, List.class));
        }
        return studentList;
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