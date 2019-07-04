package io.williamwu.springdb.web;

import io.williamwu.springdb.mapper.BridgeMapper;
import io.williamwu.springdb.model.Schedule;
import io.williamwu.springdb.model.Student;
import io.williamwu.springdb.model.Subject;
import io.williamwu.springdb.model.Teacher;
import io.williamwu.springdb.service.BridgeService;
import io.williamwu.springdb.service.dbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

@RestController
public class TeacherController {

    @Autowired
    private dbService<Teacher> teacherService;

    @Autowired
    private dbService<Subject> subjectService;

    @Autowired
    private dbService<Schedule> scheduleService;

    @Autowired
    private dbService<Student> studentService;

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
        Teacher teacher = new Teacher();
        teacher.setId(id);
        return teacherService.get(teacher);
    }

    @GetMapping(value = "teacher/getSubjects")
    public List<Subject> getSubjects(@RequestParam(name = "teacher_name") String name) {
        return bridgeService.teacherFindSubjects(name);
    }

    // TODO
    @GetMapping(value = "teacher/getStudents")
    public List<Student> getStudents(@RequestParam(name = "teacher_name") String name) {
        return null;
    }

    @PostMapping(value = "/teacher/update")
    public int update(@RequestParam(name = "id") Integer id,
                      @RequestParam(name = "teacher_name", required = false) String newName,
                      @RequestParam(name = "teacher_age", required = false) Integer newAge,
                      @RequestParam(name = "teacher_gender", required = false) String newGender) {
        return teacherService.update(new Teacher(id, newName, newAge, newGender));
    }

    @DeleteMapping(value = "/teacher/delete")
    public int delete(@RequestParam(name="id") Integer id) {
        Teacher teacher = new Teacher();
        teacher.setId(id);
        return teacherService.delete(teacher);
    }
}