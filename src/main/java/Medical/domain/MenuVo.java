package Medical.domain;

import Medical.framework.domain.BaseEntity;

import java.util.List;

/**
 * 父系菜单实体类
 * @DATE 2019/01/23
 * @AUTHOR ZJF
 */
public class MenuVo extends BaseEntity {

        /**主键*/
        private String uid;
        /**名称*/
        private String name;
        /**编码*/
        private String code;
        /**路径*/
        private String path;
        /**状态*/
        private String status;
        /**子菜单列表*/
        private List<Menu> menulist;

        public List<Menu> getMenulist() {
            return menulist;
        }

        public void setMenulist(List<Menu> menulist) {
            this.menulist = menulist;
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
