package io.williamwu.springdb;

import io.williamwu.springdb.student.Student;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@RestController
public class MainController {

    @RequestMapping("/")
    public String index() {
        return "This is the landing page (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧";
    }

}