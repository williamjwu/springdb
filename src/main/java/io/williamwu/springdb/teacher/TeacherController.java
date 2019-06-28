package io.williamwu.springdb.teacher;

import io.williamwu.springdb.Enums;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping(value = "/teacher/getTeacher")
    public List<Teacher> getTeacher(@RequestParam(name = "teach_name", required = false) String name) {
        if (name == null) {
            return teacherService.getTeacher();
        }
        return teacherService.getSpecTeacher(name);
    }

    @PostMapping(value = "/teacher/addTeacher")
    public int addTeacher(@RequestParam(name = "teach_name", required = true) String name,
                          @RequestParam(name = "teach_age", required = true) Integer age,
                          @RequestParam(name = "teach_gender", required = true) String gender) {
        gender = gender.toUpperCase();
        if (!gender.equals(Enums.Gender.MALE.toString()) && !gender.equals(Enums.Gender.FEMALE.toString())) {
            gender = "UNKNOWN";
        }
        Enums.Gender enumGender = Enums.Gender.valueOf(gender);
        return teacherService.addTeacher(new Teacher(null, name, age, enumGender));
    }

    @PostMapping(value = "/teacher/updateTeacher")
    public int updateTeacher(@RequestParam(name = "teach_name", required = true) String currName,
                             @RequestParam(name = "new_name", required = false) String newName,
                             @RequestParam(name = "new_age", required = false) Integer newAge,
                             @RequestParam(name = "new_gender", required = false) String newGender) {
        return teacherService.updateTeacher(currName, newName, newAge, newGender);
    }

    @DeleteMapping(value = "/teacher/rmTeacher")
    public int rmTeacher(@RequestParam(name="teach_name", required = true) String name) {
        if (name == null) {
            return 0;
        }
        return teacherService.rmTeacher(name);
    }

}