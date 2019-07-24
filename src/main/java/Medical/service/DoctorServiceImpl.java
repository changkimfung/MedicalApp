package Medical.service;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Medical.domain.Doctor;
import Medical.framework.Util.StringUtils;
import Medical.framework.page.PageUtil;
import Medical.framework.page.TableDataInfo;
import Medical.mapper.DoctorMapper;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorMapper doctormapper;
	
	@Override
	public TableDataInfo selectDoctorListPage(Doctor doctor) {
		// TODO 自动生成的方法存根
		PageUtil.startPage(doctor);
		List<Doctor> list =doctormapper.selectDoctorListPage(doctor);
		
		return PageUtil.getDataTable(list);
	}

	@Override
	public Doctor selectDoctorById(String uid) {
		// TODO 自动生成的方法存根
		return doctormapper.selectDoctorById(uid);
	}

	@Override
	public Integer deleteDoctorById(String uid) {
		// TODO 自动生成的方法存根
		return doctormapper.deleteDoctorById(uid);
	}

	@Override
	public Integer deleteDoctorByIds(String[] uids) {
		// TODO 自动生成的方法存根
		return doctormapper.deleteDoctorByIds(uids);
	}

	@Override
	public Integer insertDoctor(Doctor doctor) {
		// TODO 自动生成的方法存根
		return doctormapper.insertDoctor(doctor);
	}

	@Override
	public Integer updateDoctor(Doctor doctor) {
		// TODO 自动生成的方法存根
		return doctormapper.updateDoctor(doctor);
	}

	@Override
	public Integer save(Doctor doctor) {

		// TODO 自动生成的方法存根
	   String uid=doctor.getUid();
	   int rows=0;
	   if(StringUtils.isNotEmpty(uid)) {
		  rows=doctormapper.updateDoctor(doctor);
	   }
	   else {
		   Date date =new Date();
		   long a =date.getTime();
		   String a1="010"+String.valueOf(a);
	       doctor.setUid(a1);
	       doctor.setStatus("1");
	   rows=doctormapper.insertDoctor(doctor);

	   }
		
		return rows;
	}

}
