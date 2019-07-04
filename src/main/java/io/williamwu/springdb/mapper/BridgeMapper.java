package io.williamwu.springdb.mapper;

import io.williamwu.springdb.entity.Student;
import io.williamwu.springdb.entity.Subject;
import io.williamwu.springdb.entity.Teacher;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import java.util.List;
import static org.apache.ibatis.type.JdbcType.VARCHAR;
import static org.apache.ibatis.type.JdbcType.TIMESTAMP;
import static org.apache.ibatis.type.JdbcType.INTEGER;

public interface BridgeMapper {

    @Select("SELECT * FROM springdb.student stu LEFT JOIN springdb.schedule skd " +
            "ON stu.id = skd.student_id " +
            "WHERE skd.subject_id = #{id}")
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

    @Select("SELECT * FROM springdb.subject sbj LEFT JOIN springdb.schedule skd " +
            "ON sbj.id = skd.subject_id " +
            "WHERE skd.student_id = #{id}")
    @Results(value = {
            @Result(property = "id", column = "id", jdbcType = INTEGER),
            @Result(property = "subjectName", column = "subject_name", jdbcType = VARCHAR),
            @Result(property = "teacherId", column = "teacher_id", jdbcType = INTEGER),
            @Result(property = "subjectDay", column = "subject_day", jdbcType = VARCHAR),
            @Result(property = "subjectPeriod", column = "subject_period", jdbcType = VARCHAR),
            @Result(property = "createTime", column = "create_time", jdbcType = TIMESTAMP),
            @Result(property = "modifyTime", column = "modify_time", jdbcType = TIMESTAMP)
    })
    List<Subject> studentFindSubjects(Student student);

    @Select("SELECT * FROM student WHERE id IN " +
            "(SELECT student_id FROM springdb.schedule skd INNER JOIN springdb.subject sbj ON skd.subject_id = sbj.id " +
            "WHERE sbj.teacher_id = #{id})")
    @Results(value = {
            @Result(property = "id", column = "id", jdbcType = INTEGER),
            @Result(property = "studentName", column = "student_name", jdbcType = VARCHAR),
            @Result(property = "age", column = "student_age", jdbcType = INTEGER),
            @Result(property = "gender", column = "student_gender", jdbcType = VARCHAR),
            @Result(property = "createTime", column = "create_time", jdbcType = TIMESTAMP),
            @Result(property = "modifyTime", column = "modify_time", jdbcType = TIMESTAMP)
    })
    List<Student> teacherFindStudents(Teacher teacher);

    @Select("SELECT * FROM subject WHERE teacher_id = #{id}")
    @Results(value = {
            @Result(property = "id", column = "id", jdbcType = INTEGER),
            @Result(property = "subjectName", column = "subject_name", jdbcType = VARCHAR),
            @Result(property = "teacherId", column = "teacher_id", jdbcType = INTEGER),
            @Result(property = "subjectDay", column = "subject_day", jdbcType = VARCHAR),
            @Result(property = "subjectPeriod", column = "subject_period", jdbcType = VARCHAR),
            @Result(property = "createTime", column = "create_time", jdbcType = TIMESTAMP),
            @Result(property = "modifyTime", column = "modify_time", jdbcType = TIMESTAMP)
    })
    List<Subject> teacherFindSubjects(Teacher teacher);

}