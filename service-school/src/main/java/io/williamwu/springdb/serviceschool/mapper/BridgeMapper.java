package io.williamwu.springdb.serviceschool.mapper;

import io.williamwu.springdb.serviceschool.entity.Subject;
import io.williamwu.springdb.serviceschool.entity.Teacher;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import java.util.List;
import static org.apache.ibatis.type.JdbcType.VARCHAR;
import static org.apache.ibatis.type.JdbcType.TIMESTAMP;
import static org.apache.ibatis.type.JdbcType.INTEGER;

public interface BridgeMapper {

    @Select("SELECT tch.* FROM subject sbj " +
            "JOIN teacher tch ON sbj.teacher_id = tch.id " +
            "WHERE sbj.subject_name = #{name}")
    @Results(value = {
            @Result(property = "id", column = "id", jdbcType = INTEGER),
            @Result(property = "teacherName", column = "teacher_name", jdbcType = VARCHAR),
            @Result(property = "age", column = "teacher_age", jdbcType = INTEGER),
            @Result(property = "gender", column = "teacher_gender", jdbcType = VARCHAR),
            @Result(property = "createTime", column = "create_time", jdbcType = TIMESTAMP),
            @Result(property = "modifyTime", column = "modify_time", jdbcType = TIMESTAMP)
    })
    List<Teacher> subjectGetTeachers(String name);

    @Select("SELECT sbj.* FROM subject sbj " +
            "JOIN schedule skd ON sbj.id = skd.subject_id " +
            "JOIN student stu ON skd.student_id = stu.id " +
            "WHERE stu.student_name = #{name}")
    @Results(value = {
            @Result(property = "id", column = "id", jdbcType = INTEGER),
            @Result(property = "subjectName", column = "subject_name", jdbcType = VARCHAR),
            @Result(property = "subjectDay", column = "subject_day", jdbcType = VARCHAR),
            @Result(property = "subjectPeriod", column = "subject_period", jdbcType = VARCHAR),
            @Result(property = "createTime", column = "create_time", jdbcType = TIMESTAMP),
            @Result(property = "modifyTime", column = "modify_time", jdbcType = TIMESTAMP),
            @Result(property = "teacherId", column = "teacher_id", jdbcType = INTEGER)
    })
    List<Subject> studentGetSubjects(String name);

    @Select("SELECT sbj.* FROM subject sbj " +
            "JOIN teacher tch ON sbj.teacher_id = tch.id " +
            "WHERE tch.teacher_name = #{name}")
    @Results(value = {
            @Result(property = "id", column = "id", jdbcType = INTEGER),
            @Result(property = "subjectName", column = "subject_name", jdbcType = VARCHAR),
            @Result(property = "subjectDay", column = "subject_day", jdbcType = VARCHAR),
            @Result(property = "subjectPeriod", column = "subject_period", jdbcType = VARCHAR),
            @Result(property = "createTime", column = "create_time", jdbcType = TIMESTAMP),
            @Result(property = "modifyTime", column = "modify_time", jdbcType = TIMESTAMP),
            @Result(property = "teacherId", column = "teacher_id", jdbcType = INTEGER)
    })
    List<Subject> teacherGetSubjects(String name);

}