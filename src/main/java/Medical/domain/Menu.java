package Medical.domain;

import Medical.framework.domain.BaseEntity;

/**
 * pre_role_menu的实体类
 * @author zjf
 * @date  2019/01/16
 *
 */
public class Menu extends BaseEntity {
    //主键
    private String uid;
    //角色种类Id
    private String roleId;
    //菜单名称
    private String name;
    //菜单路径
    private String path;
    //状态（0停用，1为开启）
    private String status;
    //父菜单
    private String parId;


    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getParId() {
        return parId;
    }

    public void setParId(String parId) {
        this.parId = parId;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
