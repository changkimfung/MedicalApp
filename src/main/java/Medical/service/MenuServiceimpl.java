package Medical.service;

import Medical.domain.Menu;
import Medical.domain.MenuVo;
import Medical.domain.ParentMenu;

import Medical.mapper.MenuMapper;
import Medical.mapper.ParentMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单管理业务逻辑层实现
 * @author zjf
 * @date 2019/01/16
 */
@Service
public class MenuServiceimpl  implements  MenuService {

    @Autowired
    private MenuMapper  menuMapper;
    @Autowired
    private ParentMenuMapper parentMenuMapper;

//    @Override
//    public List<Menu> selectMenuByUsername(String username) {
//        return menuMapper.selectMenuByUsername(username);
//    }

    @Override
    public List<MenuVo> selectMenuByUsername(String username) {
        ParentMenu pm=new ParentMenu();

        List<MenuVo> list2 =new ArrayList<>();
        List<ParentMenu> list =parentMenuMapper.select(pm);
        for(int i=0;i<list.size();i++){
          String b=list.get(i).getUid();
            MenuVo A=new MenuVo();
          List<Menu> m =menuMapper.selectMenuByUsername(username,b);
          A.setUid(list.get(i).getUid());
          A.setCode(list.get(i).getCode());
          A.setName(list.get(i).getName());
          A.setPath(list.get(i).getPath());
          A.setStatus(list.get(i).getStatus());
          A.setMenulist(m);

            list2.add(A);


        }

        return list2;
    }
}
