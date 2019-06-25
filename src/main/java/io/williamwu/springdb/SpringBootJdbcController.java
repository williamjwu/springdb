package io.williamwu.springdb;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringBootJdbcController {
    @Autowired
    JdbcTemplate jdbc;

    @RequestMapping("/insert")
    public String index() {
        jdbc.execute("insert into students(create_time, student_name, student_age)values(now(), 'William', 19)");
        return "data inserted Successfully";
    }
}