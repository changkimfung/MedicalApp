package Medical.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import Medical.framework.domain.BaseEntity;

/**
 * 系统用户表实体类
 *
 * @author zhengjianfeng
 * @date 2018-12-12
 */
@JsonInclude(value = Include.NON_EMPTY)
public class User extends BaseEntity {

    /**
     * 主键
     */
    private String uid;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 用户权限类别
     */
    private String userType;


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
