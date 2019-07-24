package Medical.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import Medical.domain.User;
import Medical.framework.domain.AjaxResult;
import Medical.framework.domain.BaseController;
import Medical.framework.page.TableDataInfo;
import Medical.mapper.UserMapper;
import Medical.service.UserService;

/**
 * 系统用户表实体类  信息操作
 * @author zhengjianfeng
 * @date 2018-12-12
 */

@Api("系统用户维护")
@CrossOrigin(origins = "http://localhost:8080",maxAge = 3600)
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
	
	@Autowired
	private UserService userservice;

	/**
	 * 分页查询
	 * @param isAsc
	 * @param pageNum
	 * @param pageSize
	 * @param searchValue
	 * @param orderByColumn
	 * @return
	 */
	@ApiOperation("系统用户列表查询")
	@GetMapping("/list")
	@ResponseBody
	public AjaxResult list(String isAsc, Integer pageNum,Integer pageSize,String searchValue,String orderByColumn){
	     User user =new User();
	     user.setIsAsc(isAsc);
	     user.setPageNum(pageNum);
	     user.setPageSize(pageSize);
	     user.setSearchValue(searchValue);
	     user.setOrderByColumn(orderByColumn);
	     TableDataInfo list=new TableDataInfo();
	     list=userservice.selectUserListPage(user);
			
	     return success("",list);
	}
    /**
     * 删除
     * @param uid
     * @return
     */
    @ApiOperation("系统用户删除")
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String uid) {
	    int rows=userservice.DelteteUserByIds(uid);
	    if(rows>0) {

	    	return success();
	    }
		return error();
	}
    
	/**
	 * 修改
	 * @param uid
	 * @return
	 */
    @ApiOperation("系统用户修改")
	@GetMapping("/edit/{uid}")
	@ResponseBody
	public User edit(@PathVariable("uid")String uid) {
		User user= userservice.selectUserListById(uid);
		return user;
	}
	/**保存
	 * 
	 * @param user
	 * @return
	 */
    @ApiOperation("系统用户保存")
	@PostMapping("/save")
	@ResponseBody
	public AjaxResult save(User user) {
		int Affectrows =userservice.save(user);
		if(Affectrows>0) {
			return success();
		}
		return error();
	}
}
