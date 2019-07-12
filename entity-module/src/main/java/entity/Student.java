package entity;

import enums.GenderEnum;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Student {

    @Id
    @GeneratedValue
    private Integer id;
    private String studentName;
    private Integer age;
    private GenderEnum gender;
    private Date createTime;
    private Date modifyTime;

    public Student() {
    }

    public Student(Integer id, String studentName, Integer age, String strGender) {
        this.id = id;
        this.studentName = studentName;
        this.age = age;
        if (strGender != null) {
            try {
                gender = GenderEnum.valueOf(strGender.toUpperCase());
            } catch (Exception ex) {
                gender = GenderEnum.UNKNOWN;
            }
        }

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(String strGender) {
        if (strGender != null) {
            try {
                gender = GenderEnum.valueOf(strGender.toUpperCase());
            } catch (Exception ex) {
                gender = GenderEnum.UNKNOWN;
            }
        }
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                '}';
    }
}
