package Medical.controller;

import Medical.domain.Menu;
import Medical.domain.MenuVo;
import Medical.domain.ParentMenu;

import Medical.framework.domain.BaseEntity;
import Medical.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 菜单管理业务操作控制器
 * @date    2019/01/16
 * @author  zjf
 */

@Api("菜单功能接口")
@RequestMapping("/Menu")
@RestController
public class MenuController extends BaseEntity
{
    @Autowired
    private MenuService menuService;

    @ApiOperation("菜单列表")
    @GetMapping("/list")
    public  Map<String,Object> MenuList(String username){
        Map<String,Object> map =new HashMap<>();
        List<MenuVo>  a=menuService.selectMenuByUsername(username);
        String code="0";
        map.put("code",code);
        map.put("list",a);
        return map;
    }
//
//    @GetMapping("/list1")
//    public Map<String,Object> list(String username){
//        return null;
//    }

}
