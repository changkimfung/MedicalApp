package Medical.domain;

import java.util.Date;

import Medical.framework.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 系统学生表实体类
 *
 * @author zhengjianfeng
 * @date 2018-12-12
 */
public class Student extends BaseEntity {
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    private String uid;
    /**
     * 学生姓名
     */
    private String name;
    /**
     * 学生ID
     */
    private String stuId;
    /**
     * 性别
     */
    private String sex;
    /**
     * 出生日期
     */
    private Date birthday;
    /**
     * 班级
     */
    private String classes;
    /**
     * 状态
     */
    private String status;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

}
