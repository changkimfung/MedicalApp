package Medical.service;

import Medical.domain.InsuranceHandle;
import Medical.framework.Util.StringUtils;
import Medical.framework.page.PageUtil;
import Medical.framework.page.TableDataInfo;
import Medical.mapper.InjuryHandleMapper;
import Medical.mapper.InsuranceHandleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 *
 * 业务逻辑实现层
 * @author zjf
 * @date   2019/01/14
 *
 */
@Service
public class InsuranceHandleServiceimpl implements InsuranceHandleService {

    @Autowired
        private InsuranceHandleMapper insuranceHandleMapper;


    /**
     * 分页
     * @param insuranceHandle
     * @return
     */
    @Override
    public TableDataInfo selectInsuranceHandleListPage(InsuranceHandle insuranceHandle) {
        PageUtil.startPage(insuranceHandle);
        List<InsuranceHandle> list =insuranceHandleMapper.selectInsuranceHandleList(insuranceHandle);
         return PageUtil.getDataTable(list);
    }

    /**
     * 按uid查询
     * @param uid
     * @return
     */
    @Override
    public InsuranceHandle selectInsuranceHandleById(String  uid) {

        return insuranceHandleMapper.selectInsuranceHandleById(uid);
    }

    /**
     * 按照ids批量删除
     * @param ids
     * @return
     */

    @Override
    public Integer deleteInsuranceHandle(String[] ids) {

        return insuranceHandleMapper.deleteInsuranceHandle(ids);
    }

    /**
     * 保存
     * @param insuranceHandle
     * @return
     */
    @Override
    public Integer save(InsuranceHandle insuranceHandle) {
      String id=insuranceHandle.getUid();
      int rows=0;
      if (StringUtils.isNotNull(id)){
          rows=insuranceHandleMapper.updateInsuranceHandle(insuranceHandle);
      }
      else {
          Date date =new Date();
          long a =date.getTime();
          String a1="010"+String.valueOf(a);
          insuranceHandle.setUid(a1);
          insuranceHandle.setStatus("0");
          rows=insuranceHandleMapper.insertInsuranceHandle(insuranceHandle);
      }
        return rows;
    }
}
