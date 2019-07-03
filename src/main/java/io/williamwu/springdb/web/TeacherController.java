package io.williamwu.springdb.web;

import io.williamwu.springdb.model.Teacher;
import io.williamwu.springdb.service.dbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class TeacherController {

    @Autowired
    private dbService<Teacher> service;

    @GetMapping(value = "/teacher/getAll")
    public List<Teacher> getAll() {
        return service.getAll();
    }

    @GetMapping(value = "/teacher/get")
    public Teacher get(@RequestParam(name = "id") Integer id) {
        return service.get(id);
    }

    @PostMapping(value = "/teacher/insert")
    public int insert(@RequestParam(name = "teacher_name") String name,
                      @RequestParam(name = "teacher_age") Integer age,
                      @RequestParam(name = "teacher_gender") String gender) {
        return service.insert(new Teacher(null, name, age, gender));
    }

    @PostMapping(value = "/teacher/update")
    public int update(@RequestParam(name = "id") Integer id,
                      @RequestParam(name = "teacher_name", required = false) String newName,
                      @RequestParam(name = "teacher_age", required = false) Integer newAge,
                      @RequestParam(name = "teacher_gender", required = false) String newGender) {
        return service.update(new Teacher(id, newName, newAge, newGender));
    }

    @DeleteMapping(value = "/teacher/delete")
    public int delete(@RequestParam(name="id") Integer id) {
        return service.delete(id);
    }

}