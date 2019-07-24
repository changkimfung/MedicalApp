package Medical.domain;

import Medical.framework.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 系统医生信息表实体类
 *
 * @author zhengjianfeng
 * @date 2018-12-12
 */
public class Doctor extends BaseEntity {

    /**
     * 主键
     */
    private String uid;
    /**
     * 名称
     */
    private String name;
    /**
     * 工号
     */
    private String code;
    /**
     * 年龄
     */
    private String age;
    /**
     * 工龄
     */
    private String EmploymentYear;
    /**
     * 性别
     */
    private String sex;

    /**
     * 入职日期
     */
    private Date EntryDate;
    /**
     * 个人简介
     */
    private String introduction;


    private String status;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public Date getEntryDate() {
        return EntryDate;
    }

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public void setEntryDate(Date entryDate) {
        EntryDate = entryDate;
    }

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmploymentYear() {
        return EmploymentYear;
    }

    public void setEmploymentYear(String employmentYear) {
        EmploymentYear = employmentYear;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }


}
