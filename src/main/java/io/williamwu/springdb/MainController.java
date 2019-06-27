package io.williamwu.springdb;

import io.williamwu.springdb.student.Student;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private JdbcTemplate jdbc;

    @RequestMapping("/")
    public String greeting() {
        return "This is the landing page (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧";
    }

    @RequestMapping("/insert")
    public String insert() {
        String SQL = "INSERT INTO student (create_time, student_name, student_age) VALUES (now(), ?, ?)";
        jdbc.update(SQL, "william", 19);
        return "Created Record";
    }

}