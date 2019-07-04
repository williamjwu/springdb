package io.williamwu.springdb.web;

import io.williamwu.springdb.model.Schedule;
import io.williamwu.springdb.model.Student;
import io.williamwu.springdb.model.Subject;
import io.williamwu.springdb.model.Teacher;
import io.williamwu.springdb.service.BridgeService;
import io.williamwu.springdb.service.dbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
public class SubjectController {

    @Autowired
    private dbService<Subject> subjectService;

    @Autowired
    private dbService<Schedule> scheduleService;

    @Autowired
    private BridgeService bridgeService;

    @PostMapping(value = "/subject/insert")
    public int insert(@RequestParam(name = "subject_name") String name,
                      @RequestParam(name = "subject_day") String day,
                      @RequestParam(name = "subject_period") String period) {
        return subjectService.insert(new Subject(null, name, day, period));
    }

    @GetMapping(value = "/subject")
    public List<Subject> getAll() {
        return subjectService.getAll();
    }

    @GetMapping(value = "/subject/{id}")
    public List<Subject> get(@PathVariable Integer id) {
        Subject subject = new Subject();
        subject.setId(id);
        return subjectService.get(subject);
    }

    @GetMapping(value = "/subject/getTeachers")
    public List<Teacher> getTeachers(@RequestParam(name = "subject_name") String name) {
        return bridgeService.subjectFindTeachers(name);
    }

    // TODO
    @GetMapping(value = "/subject/getStudents")
    public List<Student> getStudents(@RequestParam(name = "subject_name") String name) {
        return null;
    }

    @PostMapping(value = "/subject/addTeacher")
    public int addTeacher(@RequestParam(name = "id") Integer id,
                          @RequestParam(name = "teacher_id") Integer teacherId) {
        Subject subject = new Subject();
        subject.setId(id);
        subject.setTeacherId(teacherId);
        return subjectService.update(subject);
    }

    @PostMapping(value = "/subject/rmTeacher")
    public int rmTeacher(@RequestParam(name = "id") Integer id) {
        Subject subject = new Subject();
        subject.setId(id);
        return subjectService.update(subject);
    }

    @PostMapping(value = "/subject/addStudent")
    public int addStudent(@RequestParam(name = "student_id") Integer studentId,
                          @RequestParam(name = "subject_id") Integer subjectId) {
        return scheduleService.insert(new Schedule(null, studentId, subjectId));
    }

    @PostMapping(value = "/subject/rmStudent")
    public int rmStudent(@RequestParam(name = "student_id") Integer studentId,
                         @RequestParam(name = "subject_id") Integer subjectId) {
        return scheduleService.delete(new Schedule(null, studentId, subjectId));
    }

    @PostMapping(value = "/subject/update")
    public int update(@RequestParam(name = "id") Integer id,
                      @RequestParam(name = "subject_name", required = false) String newName,
                      @RequestParam(name = "subject_day", required = false) String newDay,
                      @RequestParam(name = "subject_period", required = false) String newPeriod) {
        return subjectService.update(new Subject(id, newName, newDay, newPeriod));
    }

    @DeleteMapping(value = "/subject/delete")
    public int delete(@RequestParam(name="id") Integer id) {
        Subject subject = new Subject();
        subject.setId(id);
        return subjectService.delete(subject);
    }

}