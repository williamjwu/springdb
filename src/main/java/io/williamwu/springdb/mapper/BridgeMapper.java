package io.williamwu.springdb.mapper;

import io.williamwu.springdb.model.Student;
import io.williamwu.springdb.model.Subject;
import io.williamwu.springdb.model.Teacher;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import java.util.List;
import static org.apache.ibatis.type.JdbcType.VARCHAR;
import static org.apache.ibatis.type.JdbcType.TIMESTAMP;
import static org.apache.ibatis.type.JdbcType.INTEGER;

public interface BridgeMapper {

    @Select("SELECT student_id FROM schedule WHERE subject_id = #{id}")
    @Results(value = {
            @Result(property = "id", column = "id", jdbcType = INTEGER),
            @Result(property = "studentName", column = "student_name", jdbcType = VARCHAR),
            @Result(property = "age", column = "student_age", jdbcType = INTEGER),
            @Result(property = "gender", column = "student_gender", jdbcType = VARCHAR),
            @Result(property = "createTime", column = "create_time", jdbcType = TIMESTAMP),
            @Result(property = "modifyTime", column = "modify_time", jdbcType = TIMESTAMP)
    })
    List<Student> subjectFindStudents(Subject subject);

    @Select("SELECT * FROM teacher WHERE id = #{teacherId}")
    @Results(value = {
            @Result(property = "id", column = "id", jdbcType = INTEGER),
            @Result(property = "teacherName", column = "teacher_name", jdbcType = VARCHAR),
            @Result(property = "age", column = "teacher_age", jdbcType = INTEGER),
            @Result(property = "gender", column = "teacher_gender", jdbcType = VARCHAR),
            @Result(property = "createTime", column = "create_time", jdbcType = TIMESTAMP),
            @Result(property = "modifyTime", column = "modify_time", jdbcType = TIMESTAMP)
    })
    List<Teacher> subjectFindTeachers(Subject subject);

    @Select("SELECT subject_id FROM schedule WHERE student_id = #{id}")
    @Results(value = {
            @Result(property = "id", column = "id", jdbcType = INTEGER),
            @Result(property = "subjectName", column = "subject_name", jdbcType = VARCHAR),
            @Result(property = "teacherId", column = "subject_teacher_id", jdbcType = INTEGER),
            @Result(property = "subjectDay", column = "subject_day", jdbcType = VARCHAR),
            @Result(property = "subjectPeriod", column = "subject_period", jdbcType = VARCHAR),
            @Result(property = "createTime", column = "create_time", jdbcType = TIMESTAMP),
            @Result(property = "modifyTime", column = "modify_time", jdbcType = TIMESTAMP)
    })
    List<Subject> studentFindSubjects(Student student);

    @Select("SELECT schedule.student_id FROM schedule INNER JOIN " +
            "subject ON subject_id = id WHERE teacher_id = #{id}")
    @Results(value = {
            @Result(property = "id", column = "id", jdbcType = INTEGER),
            @Result(property = "studentName", column = "student_name", jdbcType = VARCHAR),
            @Result(property = "age", column = "student_age", jdbcType = INTEGER),
            @Result(property = "gender", column = "student_gender", jdbcType = VARCHAR),
            @Result(property = "createTime", column = "create_time", jdbcType = TIMESTAMP),
            @Result(property = "modifyTime", column = "modify_time", jdbcType = TIMESTAMP)
    })
    List<Student> teacherFindStudents(Teacher teacher);

    @Select("SELECT * FROM subject WHERE subject_teacher_id = #{id}")
    @Results(value = {
            @Result(property = "id", column = "id", jdbcType = INTEGER),
            @Result(property = "subjectName", column = "subject_name", jdbcType = VARCHAR),
            @Result(property = "teacherId", column = "subject_teacher_id", jdbcType = INTEGER),
            @Result(property = "subjectDay", column = "subject_day", jdbcType = VARCHAR),
            @Result(property = "subjectPeriod", column = "subject_period", jdbcType = VARCHAR),
            @Result(property = "createTime", column = "create_time", jdbcType = TIMESTAMP),
            @Result(property = "modifyTime", column = "modify_time", jdbcType = TIMESTAMP)
    })
    List<Subject> teacherFindSubjects(Teacher teacher);

}