package entity;

import enums.GenderEnum;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Teacher {

    @Id
    @GeneratedValue
    private Integer id;
    private String teacherName;
    private Integer age;
    private GenderEnum gender;
    private Date createTime;
    private Date modifyTime;

    public Teacher() {
    }

    public Teacher(Integer id, String teacherName, Integer age, String strGender) {
        this.id = id;
        this.teacherName = teacherName;
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

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
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
        return "Teacher{" +
                "id=" + id +
                ", teacherName='" + teacherName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                '}';
    }
}
