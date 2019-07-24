package Medical.mapper;

import java.util.List;

import Medical.domain.Registration;
import org.apache.ibatis.annotations.Mapper;

import Medical.domain.Doctor;
import org.apache.ibatis.annotations.Param;

/**
 * 系统医生信息表实体类
 * @author zhengjianfeng
 * @date 2018-12-18
 */
@Mapper
public interface DoctorMapper {

	/**
	 * 查询
	 * @param doctor
	 * @return
	 */
	public List<Doctor> selectDoctorList(Doctor doctor);
	
	/**
	 * 分页查询
	 * @param doctor
	 * @return
	 */
	public List<Doctor> selectDoctorListPage(Doctor doctor);

	/**
	 * 根据uid查找
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
     * 更新
     * @param doctor
     * @return
     */
    public Integer updateDoctor(Doctor doctor);
    /**
     * 新增
     * @param doctor
     * @return
     */
    public Integer insertDoctor(Doctor doctor);

	/**
	 * 根据uid搜索
	 * @param uid
	 * @return
	 */
	//public Registration selectRegistrationById(@Param(value = "uid") String uid);
}
