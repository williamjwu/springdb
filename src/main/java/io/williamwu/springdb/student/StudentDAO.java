package io.williamwu.springdb.student;

import io.williamwu.springdb.Enums;
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

    public List<Student> getStudent() {
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

    public int addStudent(Student student) {
        try {
            String SQL = "INSERT INTO student (create_time, student_name, student_age, student_gender) VALUES (now(), ?, ?, ?)";
            return jdbc.update(SQL, student.getStudentName(), student.getAge(), student.getGender().toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    @SuppressWarnings("Duplicates")
    public int updateStudent(String currName, String newName, Integer newAge, String newGender) {
        int counter = 0;
        currName = "\"" + currName + "\"";
        if (newAge != null) {
            counter += jdbc.update("UPDATE student SET student_age = " + newAge +
                    ", modify_time = now() WHERE student_name = " + currName);
        }
        if (newGender != null) {
            newGender = newGender.toUpperCase();
            if (!newGender.equals("MALE") && !newGender.equals("FEMALE")) {
                newGender = "UNKNOWN";
            }
            newGender = "\"" + newGender + "\"";
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

    public int rmStudent(String name) {
        try {
            name = "\"" + name + "\"";
            String SQL = "DELETE FROM student WHERE student_name = " + name;
            return jdbc.update(SQL);
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    @SuppressWarnings("Duplicates")
    private class StudentMapper implements RowMapper<Student> {
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            String gender = (rs.getString("student_gender").toUpperCase());
            // if gender is not male or female, it will be assigned as unknown
            if (!gender.equals(Enums.Gender.MALE.toString()) && !gender.equals(Enums.Gender.FEMALE.toString())) {
                gender = "UNKNOWN";
            }
            Enums.Gender enumGender = Enums.Gender.valueOf(gender);
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
