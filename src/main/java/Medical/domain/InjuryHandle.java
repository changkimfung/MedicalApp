package Medical.domain;

import Medical.framework.domain.BaseEntity;

/**
 * 伤病申请表实体类
 *
 * @author zhengjianfeng
 * @date 2018-12-12
 */
public class InjuryHandle extends BaseEntity {

    /**
     * 主键
     */
    private String uid;
    /**
     * 姓名
     */
    private String stuName;
    /**
     * 学生ID
     */
    private String stuId;
    /**
     * 学生班级
     */
    private String classes;
    /**
     * 医院
     */
    private String medical;
    /**
     * 病情
     */
    private String illness;
    /**
     * 医生ID
     */
    private String docName;
    /**
     * 状态
     */
    private String status;

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

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getMedical() {
        return medical;
    }

    public void setMedical(String medical) {
        this.medical = medical;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }


}
