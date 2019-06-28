package io.williamwu.springdb.dao;

import io.williamwu.springdb.Enums;
import io.williamwu.springdb.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Repository
public class SubjectDAO {
    @Autowired
    private JdbcTemplate jdbc;

    public List<Subject> getSubject() {
        String SQL = "SELECT * FROM subject";
        return jdbc.query(SQL, new SubjectDAO.SubjectMapper());
    }

    public List<Subject> getSpecSubject(String name) {
        try {
            name = "\"" + name + "\"";
            String SQL = "SELECT * FROM subject WHERE subject_name = " + name;
            return jdbc.query(SQL, new SubjectDAO.SubjectMapper());
        } catch (Exception ex) {
            return null;
        }
    }

    public int addSubject(Subject subject) {
        try {
            String SQL = "INSERT INTO subject (create_time, subject_name, subject_day, subject_period) VALUES (now(), ?, ?, ?)";
            return jdbc.update(SQL, subject.getSubjectName(), subject.getClassDay().toString()
                    , subject.getClassPeriod().toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    public int updateSubject(String currName, String newName, String newDay, String newPeriod, Integer newTeacherId) {
        int counter = 0;
        currName = "\"" + currName + "\"";
        if (newDay != null) {
            Enums.Day day;
            try {
                day = Enums.Day.valueOf(newDay.toUpperCase());
            } catch (Exception ex) {
                day = Enums.Day.UNKNOWN;
            }
            newDay = "\"" + day.toString()+ "\"";
            counter += jdbc.update("UPDATE subject SET subject_day = " + newDay +
                    ", modify_time = now() WHERE subject_name = " + currName);
        }
        if (newPeriod != null) {
            Enums.Period period;
            try {
                period = Enums.Period.valueOf(newPeriod.toUpperCase());
            } catch (Exception ex) {
                period = Enums.Period.UNKNOWN;
            }
            newPeriod = "\"" + period.toString()+ "\"";
            counter += jdbc.update("UPDATE subject SET subject_period = " + newPeriod +
                    ", modify_time = now() WHERE subject_name = " + currName);
        }
        if (newTeacherId != null) {
            counter += jdbc.update("UPDATE subject SET teacher_id = " + newTeacherId +
                    ", modify_time = now() WHERE subject_name = " + currName);
        }
        // update name MUST be at the bottom as it overrides the current student name
        if (newName != null) {
            newName = "\"" + newName + "\"";
            counter += jdbc.update("UPDATE subject SET subject_name = " + newName +
                    ", modify_time = now() WHERE subject_name = " + currName);
        }
        return counter;
    }

    public int rmSubject(String name) {
        try {
            name = "\"" + name + "\"";
            String SQL = "DELETE FROM subject WHERE subject_name = " + name;
            return jdbc.update(SQL);
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    private class SubjectMapper implements RowMapper<Subject> {
        public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {

            Enums.Day enumDay;
            try {
                enumDay = Enums.Day.valueOf(rs.getString("subject_day").toUpperCase());
            } catch (Exception ex) {
                enumDay = Enums.Day.UNKNOWN;
            }

            Enums.Period enumPeriod;
            try {
                enumPeriod = Enums.Period.valueOf(rs.getString("subject_period").toUpperCase());
            } catch (Exception ex) {
                enumPeriod = Enums.Period.UNKNOWN;
            }

            Subject subject = new Subject(rs.getInt("subject_id"), rs.getString("subject_name"),
                    enumDay, enumPeriod);
            if (rs.getTimestamp("create_time") != null) {
                subject.setCreateTime(new Date(rs.getTimestamp("create_time").getTime()));
            }
            if (rs.getTimestamp("modify_time") != null) {
                subject.setModifyTime(new Date(rs.getTimestamp("modify_time").getTime()));
            }
            if (rs.getInt("teacher_id") != 0) {
                subject.setTeacherId(rs.getInt("teacher_id"));
            }
            return subject;
        }
    }
}