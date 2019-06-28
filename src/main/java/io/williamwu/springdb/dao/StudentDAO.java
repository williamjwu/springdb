package io.williamwu.springdb.dao;

import io.williamwu.springdb.Enums;
import io.williamwu.springdb.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Repository
public class StudentDAO {

    @Autowired
    private JdbcTemplate jdbc;

    public List<Student> get() {
        String SQL = "SELECT * FROM student";
        return jdbc.query(SQL, new StudentMapper());
    }

    public List<Student> get(String name) {
        try {
            name = "\"" + name + "\"";
            String SQL = "SELECT * FROM student WHERE student_name = " + name;
            return jdbc.query(SQL, new StudentMapper());
        } catch (Exception ex) {
            return null;
        }
    }

    public int add(Student student) {
        try {
            String SQL = "INSERT INTO student (create_time, student_name, student_age, student_gender) VALUES (now(), ?, ?, ?)";
            return jdbc.update(SQL, student.getStudentName(), student.getAge(), student.getGender().toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    public int update(String currName, String newName, Integer newAge, String newGender) {
        int counter = 0;
        currName = "\"" + currName + "\"";
        if (newAge != null) {
            counter += jdbc.update("UPDATE student SET student_age = " + newAge +
                    ", modify_time = now() WHERE student_name = " + currName);
        }
        if (newGender != null) {
            Enums.Gender gender;
            try {
                gender = Enums.Gender.valueOf(newGender.toUpperCase());
            } catch (Exception ex) {
                gender = Enums.Gender.UNKNOWN;
            }
            newGender = "\"" + gender.toString()+ "\"";
            counter += jdbc.update("UPDATE student SET student_gender = " + newGender +
                    ", modify_time = now() WHERE student_name = " + currName);
        }
        // update name MUST be at the bottom as it overrides the current student name
        if (newName != null) {
            newName = "\"" + newName + "\"";
            counter += jdbc.update("UPDATE student SET student_name = " + newName +
                    ", modify_time = now() WHERE student_name = " + currName);
        }
        return counter;
    }

    public int rm(String name) {
        try {
            name = "\"" + name + "\"";
            String SQL = "DELETE FROM student WHERE student_name = " + name;
            return jdbc.update(SQL);
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    private class StudentMapper implements RowMapper<Student> {
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            // if gender is not male or female, it will be assigned as unknown
            Enums.Gender enumGender;
            try {
                enumGender = Enums.Gender.valueOf(rs.getString("student_gender").toUpperCase());
            } catch (Exception ex) {
                enumGender = Enums.Gender.UNKNOWN;
            }
            Student student = new Student(rs.getInt("student_id"), rs.getString("student_name"),
                    rs.getInt("student_age"), enumGender);
            if (rs.getTimestamp("create_time") != null) {
                student.setCreateTime(new Date(rs.getTimestamp("create_time").getTime()));
            }
            if (rs.getTimestamp("modify_time") != null) {
                student.setModifyTime(new Date(rs.getTimestamp("modify_time").getTime()));
            }
            return student;
        }
    }

}
