package io.williamwu.springdb.teacher;

import io.williamwu.springdb.Enums;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TeacherDAO {

    @Autowired
    private JdbcTemplate jdbc;

    public List<Teacher> getTeacher() {
        String SQL = "SELECT * FROM teacher";
        return jdbc.query(SQL, new TeacherDAO.TeacherMapper());
    }

    public List<Teacher> getSpecTeacher(String name) {
        try {
            name = "\"" + name + "\"";
            String SQL = "SELECT * FROM teacher WHERE teacher_name = " + name;
            return jdbc.query(SQL, new TeacherDAO.TeacherMapper());
        } catch (Exception ex) {
            return null;
        }
    }

    public int addTeacher(Teacher teacher) {
        try {
            String SQL = "INSERT INTO teacher (create_time, teacher_name, teacher_age, teacher_gender) VALUES (now(), ?, ?, ?)";
            return jdbc.update(SQL, teacher.getTeacherName(), teacher.getAge(), teacher.getGender().toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    public int rmTeacher(String name) {
        try {
            name = "\"" + name + "\"";
            String SQL = "DELETE FROM teacher WHERE teacher_name = " + name;
            return jdbc.update(SQL);
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    private class TeacherMapper implements RowMapper<Teacher> {
        public Teacher mapRow(ResultSet rs, int rowNum) throws SQLException {
            String gender = (rs.getString("teacher_gender").toUpperCase());
            // if gender is not male or female, it will be assigned as unknown
            if (!gender.equals(Enums.Gender.MALE.toString()) && !gender.equals(Enums.Gender.FEMALE.toString())) {
                gender = "UNKNOWN";
            }
            Enums.Gender enumGender = Enums.Gender.valueOf(gender);
            return new Teacher(rs.getInt("teacher_id"), rs.getString("teacher_name"),
                    rs.getInt("teacher_age"), enumGender);
        }
    }

}