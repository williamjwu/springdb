package io.williamwu.springdb.student;

import io.williamwu.springdb.Enums;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentDAO {

    @Autowired
    private JdbcTemplate jdbc;

    public List<Student> getStudents() {
        String SQL = "SELECT * FROM student";
        return jdbc.query(SQL, new StudentMapper());
    }

    public List<Student> getSpecStudent(String name) {
        try {
            name = "\"" + name + "\"";
            String SQL = "SELECT * FROM student WHERE student_name = " + name;
            return jdbc.query(SQL, new StudentMapper());
        } catch (Exception ex) {
            return null;
        }
    }

    public int addStudents() {

        return 1;
    }

    private class StudentMapper implements RowMapper<Student> {
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            Enums.Gender gender = Enums.Gender.valueOf(rs.getString("student_gender").toUpperCase());
            return new Student(rs.getInt("student_id"), rs.getString("student_name"),
                    rs.getInt("student_age"), gender);
        }
    }

}
