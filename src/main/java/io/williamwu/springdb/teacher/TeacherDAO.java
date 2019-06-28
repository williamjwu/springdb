package io.williamwu.springdb.teacher;

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

    public int updateTeacher(String currName, String newName, Integer newAge, String newGender) {
        int counter = 0;
        currName = "\"" + currName + "\"";
        if (newAge != null) {
            counter += jdbc.update("UPDATE teacher SET teacher_age = " + newAge +
                    ", modify_time = now() WHERE teacher_name = " + currName);
        }
        if (newGender != null) {
            Enums.Gender gender;
            try {
                gender = Enums.Gender.valueOf(newGender.toUpperCase());
            } catch (Exception ex) {
                gender = Enums.Gender.UNKNOWN;
            }
            newGender = "\"" + gender.toString()+ "\"";
            counter += jdbc.update("UPDATE teacher SET teacher_gender = " + newGender +
                    ", modify_time = now() WHERE teacher_name = " + currName);
        }
        // update name MUST be at the bottom as it overrides the current student name
        if (newName != null) {
            newName = "\"" + newName + "\"";
            counter += jdbc.update("UPDATE teacher SET teacher_name = " + newName +
                    ", modify_time = now() WHERE teacher_name = " + currName);
        }
        return counter;
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
            // if gender is not male or female, it will be assigned as unknown
            Enums.Gender enumGender;
            try {
                enumGender = Enums.Gender.valueOf(rs.getString("teacher_gender").toUpperCase());
            } catch (Exception ex) {
                enumGender = Enums.Gender.UNKNOWN;
            }
            Teacher teacher = new Teacher(rs.getInt("teacher_id"), rs.getString("teacher_name"),
                    rs.getInt("teacher_age"), enumGender);
            if (rs.getTimestamp("create_time") != null) {
                teacher.setCreateTime(new Date(rs.getTimestamp("create_time").getTime()));
            }
            if (rs.getTimestamp("modify_time") != null) {
                teacher.setModifyTime(new Date(rs.getTimestamp("modify_time").getTime()));
            }
            return teacher;
        }
    }

}