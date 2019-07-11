package io.williamwu.springdb.servicestudent.mapper;

import io.williamwu.springdb.servicestudent.entity.Student;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import java.util.List;
import static org.apache.ibatis.type.JdbcType.VARCHAR;
import static org.apache.ibatis.type.JdbcType.TIMESTAMP;
import static org.apache.ibatis.type.JdbcType.INTEGER;

public interface BridgeMapper {

    @Select("SELECT stu.* FROM subject sbj " +
            "JOIN schedule skd ON sbj.id = skd.subject_id " +
            "JOIN student stu ON skd.student_id = stu.id " +
            "WHERE sbj.subject_name = #{name}")
    @Results(value = {
            @Result(property = "id", column = "id", jdbcType = INTEGER),
            @Result(property = "studentName", column = "student_name", jdbcType = VARCHAR),
            @Result(property = "age", column = "student_age", jdbcType = INTEGER),
            @Result(property = "gender", column = "student_gender", jdbcType = VARCHAR),
            @Result(property = "createTime", column = "create_time", jdbcType = TIMESTAMP),
            @Result(property = "modifyTime", column = "modify_time", jdbcType = TIMESTAMP)
    })
    List<Student> subjectGetStudents(String name);

    @Select("SELECT stu.* FROM teacher tch " +
            "JOIN schedule skd ON skd.teacher_id = tch.id " +
            "JOIN student stu ON skd.student_id = stu.id " +
            "WHERE tch.teacher_name = #{name}")
    @Results(value = {
            @Result(property = "id", column = "id", jdbcType = INTEGER),
            @Result(property = "studentName", column = "student_name", jdbcType = VARCHAR),
            @Result(property = "age", column = "student_age", jdbcType = INTEGER),
            @Result(property = "gender", column = "student_gender", jdbcType = VARCHAR),
            @Result(property = "createTime", column = "create_time", jdbcType = TIMESTAMP),
            @Result(property = "modifyTime", column = "modify_time", jdbcType = TIMESTAMP)
    })
    List<Student> teacherGetStudents(String name);

}