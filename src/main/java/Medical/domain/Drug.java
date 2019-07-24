package Medical.domain;

import java.util.Date;

import Medical.framework.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 校园药品表实体类
 *
 * @author zhengjianfeng
 * @date 2018-12-12
 */
public class Drug extends BaseEntity {

    /**
     * 主键
     */
    private String uid;
    /**
     * 药品名
     */
    private String name;
    /**
     * 药物编码
     */
    private String code;

    /**
     * 购买日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date BuyTime;
    /**
     * 购买总数
     */
    private String total;
    /**
     * 库存量
     */
    private String rest;


    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    public Date getBuyTime() {
        return BuyTime;
    }

    public void setBuyTime(Date buyTime) {
        BuyTime = buyTime;
    }

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

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getRest() {
        return rest;
    }

    public void setRest(String rest) {
        this.rest = rest;
    }


}
