package Medical.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import Medical.framework.domain.BaseEntity;

/**
 * 学生看病登记挂号表实体类
 *
 * @author zhengjianfeng
 * @date 2018-12-12
 */
public class Registration extends BaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    private String uid;
    /**
     * 学生姓名
     */
    private String stuName;
    /**
     * 学号
     */
    private String stuId;
    /**
     * 医生工号
     */
    private String docName;
    /**
     * 挂号日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date ResDate;
    /**
     * 病情
     */
    private String illness;
    /**
     * 出生年月
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date birthday;
    private String status;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getstuId() {
        return stuId;
    }

    public void setstuId(String stuId) {
        this.stuId = stuId;
    }

    public Date getResDate() {
        return ResDate;
    }

    public void setResDate(Date resDate) {
        ResDate = resDate;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }


    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
