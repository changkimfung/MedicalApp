package Medical.controller;

import Medical.framework.Util.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import Medical.domain.Doctor;
import Medical.framework.domain.AjaxResult;
import Medical.framework.domain.BaseController;
import Medical.framework.page.TableDataInfo;
import Medical.service.DoctorService;
/**
 * 业务操作层
 * @author zjf
 * @date 2019/1/3
 *
 */


@Api("校医管理")
@Controller
@RequestMapping("/Doctor")
public class DoctorController extends BaseController {

  @Autowired
  private DoctorService doctorservice;


  /**
   	* 分页查询
   * @param pageSize
   * @param pageNum
   * @param orderByColumn
   * @param isAsc
   * @param searchValue
   * @return
   */
  @ApiOperation("校医用户查询")
  @GetMapping("/list")
  @ResponseBody
  public AjaxResult list(Integer pageSize,Integer pageNum,String orderByColumn, String isAsc, String searchValue) {
	   Doctor doctor=new Doctor();
	  doctor.setIsAsc(isAsc);
	  doctor.setPageNum(pageNum);
	  doctor.setPageSize(pageSize);
	  doctor.setSearchValue(searchValue);
	  doctor.setOrderByColumn(orderByColumn);
	  TableDataInfo list=new TableDataInfo();
	  list=doctorservice.selectDoctorListPage(doctor);
	  
  return success("",list);
  }

  
  /**
   * 修改
   * @param uid
   * @return
   */
  @ApiOperation("校医用户查询")
  @GetMapping("/edit/{uid}")
  @ResponseBody
  public  Doctor edit(@PathVariable("uid") String uid) {
	  Doctor doctor=doctorservice.selectDoctorById(uid);
	  return doctor;
  }
 
  
  /**
   * 删除
   * @param uid
   * @return
   */

  @ApiOperation("校医用户删除")
  @PostMapping("/remove")
  @ResponseBody
  public AjaxResult remove(String uid) {
      String[] ids =null;
      if (StringUtils.isNotEmpty(uid)){
          ids=uid.split(",");
      }
	  int Rows=doctorservice.deleteDoctorByIds(ids);
	  if(Rows>0) {
	    	return success();
	    }
		return error();
  }
  
  
  /**
   * 保存
   * @param doctor
   * @return
   */

  @ApiOperation("校医用户保存")
  @PostMapping("/save")
  @ResponseBody
  public AjaxResult save(Doctor doctor) {
	  int Affectrows=0;
	  Affectrows=doctorservice.save(doctor);
	  if (Affectrows>0) {
			 return success();}
		return error();
	  
  }
}
