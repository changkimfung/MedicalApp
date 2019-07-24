package Medical.service;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Medical.domain.Registration;
import Medical.framework.Util.StringUtils;
import Medical.framework.page.PageUtil;
import Medical.framework.page.TableDataInfo;
import Medical.mapper.RegistrationMapper;
/**
 * 业务逻辑层
 * @author zjf
 * @date 2019/1/3
 *
 */

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private  RegistrationMapper Registrationmapper;
	@Override
	public TableDataInfo selectRegistrationListPage(Registration registration) {
		// TODO 自动生成的方法存根
		PageUtil.startPage(registration);
		List<Registration>list= Registrationmapper.selectRegistrationListPage(registration);
		return PageUtil.getDataTable(list);
	}
	@Override
	public Integer deleteRegistrationById(String uid) {
		// TODO 自动生成的方法存根
		return Registrationmapper.deleteRegistrationById(uid);
	}
	@Override
	public Integer deleteRegistrationByIds(String ids) {
		// TODO 自动生成的方法存根
		return Registrationmapper.deleteRegistrationByIds(StringUtils.toStrArray(ids));
	}

	@Override
	public Integer save(Registration registration) {
		int rows=0;
		String uid= registration.getUid();
		if(StringUtils.isNotNull(uid)){
			rows=Registrationmapper.updateRegistration(registration);

		}
		else{
			Date date =new Date();
			long a =date.getTime();
			String a1="010"+String.valueOf(a);
			registration.setUid(a1);
			registration.setStatus("0");
			rows=Registrationmapper.insertRegistration(registration);

		}

		return rows;
	}

	@Override
	public Registration selectRegistrationById(String uid) {
		return Registrationmapper.selectRegistrationById(uid);
	}

}
