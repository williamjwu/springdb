package io.williamwu.springdb.serviceschool.web;

import entity.*;
import io.williamwu.springdb.serviceschool.service.BridgeService;
import io.williamwu.springdb.serviceschool.service.ScheduleService;
import io.williamwu.springdb.serviceschool.service.SubjectService;
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
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private BridgeService bridgeService;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${student.get}")
    private String getStudentURL;

    @PostMapping(value = "/subject/insert")
    public int insert(@RequestParam(name = "subject_name") String name,
                      @RequestParam(name = "subject_day") String day,
                      @RequestParam(name = "subject_period") String period) {
        return subjectService.insert(new Subject(null, name, day, period));
    }

    @GetMapping(value = "/subject", produces = "application/json")
    public List<Subject> getAll() {
        return subjectService.getAll();
    }

    @GetMapping(value = "/subject/{id}", produces = "application/json")
    public List<Subject> get(@PathVariable Integer id) {
        return subjectService.get(new Subject(id, null, null, null));
    }

    @GetMapping(value = "/subject/getPopulation", produces = "application/json")
    public StudentTeacher subjectGetPopulation(@RequestParam(name = "subject_name") String name) {
        List<Integer> studentIdCollection = bridgeService.subjectGetStudents(name);
        HttpEntity<List<Integer>> entity = new HttpEntity<>(studentIdCollection, new HttpHeaders());
        ResponseEntity<List> response = restTemplate.postForEntity(getStudentURL, entity, List.class);
        if (response == null) {
            return null;
        }
        return new StudentTeacher(bridgeService.subjectGetTeachers(name), response.getBody());
    }
    @PostMapping(value = "/studentGetSubjects", produces = "application/json")
    public List<Subject> studentGetSubjects(@RequestBody List<Integer> IdList) {
        return bridgeService.studentGetSubjects(IdList);
    }

    @PostMapping(value = "/subject/addTeacher")
    public int addTeacher(@RequestParam(name = "subject_id") Integer subjectId,
                          @RequestParam(name = "teacher_id") Integer teacherId) {
        Subject subject = new Subject(subjectId, null, null, null);
        subject.setTeacherId(teacherId);
        return subjectService.updateTeacherId(subject);
    }

    @PostMapping(value = "/subject/rmTeacher")
    public int rmTeacher(@RequestParam(name = "subject_id") Integer subjectId) {
        return subjectService.updateTeacherId(new Subject(subjectId, null, null, null));
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
    public int update(@RequestParam(name = "subject_id") Integer id,
                      @RequestParam(name = "subject_name", required = false) String newName,
                      @RequestParam(name = "subject_day", required = false) String newDay,
                      @RequestParam(name = "subject_period", required = false) String newPeriod) {
        return subjectService.update(new Subject(id, newName, newDay, newPeriod));
    }

    @DeleteMapping(value = "/subject/delete")
    public int delete(@RequestParam(name = "subject_id") Integer id) {
        return subjectService.delete(new Subject(id, null, null, null));
    }

}