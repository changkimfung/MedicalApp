package Medical.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import Medical.domain.Registration;
import Medical.framework.domain.AjaxResult;
import Medical.framework.domain.BaseController;
import Medical.framework.page.TableDataInfo;
import Medical.service.RegistrationService;

import java.util.List;

/**
 * 业务访问层
 * @author zjf
 * @date   2019/1/3
 */
@Api("患病登记")
@RestController
@RequestMapping("/Registration")
public class RegistrationController  extends BaseController{

	
	@Autowired
	private RegistrationService Registrationservice;

	/**
	 * 分页查询
	 * @param pageSize
	 * @param pageNum
	 * @param isAsc
	 * @param orderByColumn
	 * @param searchValue
	 * @return
	 */
    @ApiOperation("患病登记列表查询")
	@GetMapping("/list")
	public AjaxResult list(Integer pageSize,Integer pageNum,String isAsc,String orderByColumn,String searchValue) {
		Registration res=new Registration();
		res.setOrderByColumn(orderByColumn);
		res.setIsAsc(isAsc);
		res.setSearchValue(searchValue);
		res.setPageSize(pageSize);
		res.setPageNum(pageNum);
		TableDataInfo list=new TableDataInfo();
		list=Registrationservice.selectRegistrationListPage(res);
		
		return success("",list);
		
	}

    @ApiOperation("患病登记删除")
	@PostMapping("/remove")
	public AjaxResult remove(@RequestParam(value = "uid")String uid) {
		int rows=0;
		rows=Registrationservice.deleteRegistrationByIds(uid);
		if(rows>0) {
			return success();
		}
		return error();
	}

	/**
	 * 保存save
	 * @param registration
	 * @return
	 */
    @ApiOperation("患病登记保存")
	@PostMapping("/save")
	public AjaxResult save(Registration registration){

		int rows;
		rows=Registrationservice.save(registration);
		if (rows>0) {
			return  success();

		}
		return error();
	}
    @ApiOperation("患病登记编辑")
	@GetMapping("/edit/{uid}")
	public AjaxResult edit(@PathVariable(value = "uid") String uid){

		 Registration registration =Registrationservice.selectRegistrationById(uid);
		return success("",registration);
	}
	
}
