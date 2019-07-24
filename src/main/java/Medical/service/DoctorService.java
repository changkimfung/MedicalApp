package Medical.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import Medical.domain.Doctor;
import Medical.framework.page.TableDataInfo;

public interface DoctorService {

	/**
	 * 分页查询
	 * @param doctor
	 * @return
	 */
	public TableDataInfo selectDoctorListPage(Doctor doctor);
	
	/**
	 * 根据id查询
	 * @param uid
	 * @return
	 */
	public Doctor selectDoctorById(String uid); 
	
	/**
	 * 根据uid删除
	 * @param uid
	 * @return
	 */
	 public Integer deleteDoctorById(String uid);
    /**
     * 批量删除
     * @param uids
     * @return
     */
	 public Integer deleteDoctorByIds(String[] uids);
	/**
	 * 新增
	 * @param doctor
	 * @return
	 */
	 public Integer insertDoctor(@RequestBody Doctor doctor);
	 /**
	  * 更新
	  * @param doctor
	  * @return
	  */
	 public Integer updateDoctor(@RequestBody Doctor doctor);
	 
	 /**
	  * 保存
	  * @param doctor
	  * @return
	  */
	 public Integer save(@RequestBody Doctor doctor);
}
