package Medical.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import Medical.domain.Student;
import Medical.framework.domain.AjaxResult;
import Medical.framework.domain.BaseController;
import Medical.framework.page.PageUtil;
import Medical.framework.page.TableDataInfo;
import Medical.service.StudentService;
import Medical.framework.*;

/**
 *   学生表 基本操作
 * @author zhengjianfeng
 * @date 2018-12-13
 */
@Api("学生用户维护")
@Controller
@RequestMapping("/Student")
public class StudentController extends BaseController{

	@Autowired
	private StudentService studentservice;
	
	/**
	 * 查询所有学生信息
	 * 
	 */
	@ApiOperation("学生列表查询")
	@GetMapping("/list")
	@ResponseBody
	public AjaxResult list(Integer pageNum, Integer pageSize, String orderByColumn, String isAsc,String searchValue){
		Student student =new Student();
		student.setIsAsc(isAsc);
		student.setOrderByColumn(orderByColumn);
		student.setPageNum(pageNum);
		student.setPageSize(pageSize);
		student.setSearchValue(searchValue);
	    TableDataInfo list =new TableDataInfo();
	     list=studentservice.selectUserList(student);
	    
		
		return success("",list);
		  
	}
	 /**
	  * 删除学生信息
	  *
	  */
	  @ApiOperation("学生删除")
	  @PostMapping("/remove")
	  @ResponseBody
	  public AjaxResult remove(String uid)
	  {
		  //影响的行数
		  int rows =studentservice.deleteStudentByIds(uid);
		  if(rows>0) {
			  return success();
		  }
		  return error();
				  
	  }

	  /**
	   * 修改学生信息
	   *
	   */

	  @ApiOperation("学生删除")
	  @GetMapping("/edit/{uid}")
	  @ResponseBody
	  public Student edit(@PathVariable("uid") String uid) {
		  Student student=studentservice.selectStudentListById(uid);
		  return student;
	  }
	  
	  /**
	   * 保存学生信息
	   */
	  @ApiOperation("学生保存")
	  @PostMapping("/save")
	  @ResponseBody
	  public AjaxResult save( Student student) {
		int Affectrows=studentservice.saveStudent(student);
		if (Affectrows>0) {
			 return success();}
		return error();
	  }
}
