package Medical.service;

import java.util.List;

import Medical.domain.Registration;
import Medical.framework.page.TableDataInfo;

/**
 * 业务逻辑层
 * @author zjf
 * @date  2019/1/3
 *
 */
public interface RegistrationService {

	/**
	 * 分页查询
	 * @param registration
	 * @return
	 */
	public TableDataInfo selectRegistrationListPage(Registration registration);

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
	public Integer deleteRegistrationByIds(String ids);

	/**
	 * 保存
	 * @param registration
	 * @return
	 */
	public Integer save(Registration registration);

	/**
	 * 按uid查询
	 * @param uid
	 * @return
	 */
	public Registration selectRegistrationById(String uid);
}

