package io.williamwu.springdb.student;

import io.williamwu.springdb.Enums;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Repository
public class StudentDAO {

    @Autowired
    JdbcTemplate jdbc;

    public List<Student> getStudents() {
        return Arrays.asList(
                new Student(1, "william", 19, Enums.Gender.MALE)
        );
    }

}
