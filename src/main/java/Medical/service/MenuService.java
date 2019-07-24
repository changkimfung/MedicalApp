package Medical.service;

import Medical.domain.Menu;
import Medical.domain.MenuVo;
import Medical.domain.ParentMenu;


import java.util.List;

/**
 * 业务逻辑层
 * @author  zjf
 * @date    2019/01/16
 */
public interface MenuService {
    /**
     * 菜单项查询
     * @param username
     * @return
     */
    public List<MenuVo> selectMenuByUsername(String username);

}
