package Medical.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import Medical.domain.Registration;

/**
 * 数据访问层
 * @author zjf
 * @date   2019/1/3
 */

@Mapper
public interface RegistrationMapper {

	/**
	 * 分页查询
	 * @param registration
	 * @return
	 */
	public List<Registration> selectRegistrationListPage(Registration registration);
	
	/**
	 * 根据uid删除
	 * @param uid
	 * @return
	 */
	public Integer deleteRegistrationById(String uid);
	
	
	/**
	 * 根据ids批量删除
	 * @param ids
	 * @return
	 */
	public Integer deleteRegistrationByIds(String[] ids);

	/**
	 * 新增
	 * @param registration
	 * @return
	 */
	public Integer insertRegistration(Registration registration);

	/**
	 * 更新
	 * @param registration
	 * @return
	 */
	public Integer updateRegistration(Registration registration);

	/**
	 * 根据ID搜索
	 * @param uid
	 * @return
	 */
	public Registration selectRegistrationById(String uid);
}
