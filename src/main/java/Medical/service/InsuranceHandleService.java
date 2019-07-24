package Medical.service;

import Medical.domain.InsuranceHandle;
import Medical.framework.page.TableDataInfo;


/**
 * 业务逻辑层
 * @author zjf
 * @date  2019/01/14
 *
 */
public interface InsuranceHandleService {

    /**
     * 分页查询
     * @param insuranceHandle
     * @return
     */
    public TableDataInfo selectInsuranceHandleListPage(InsuranceHandle insuranceHandle);


    /**
     * 按照id查询
     * @param uid
     * @return
     */
    public InsuranceHandle  selectInsuranceHandleById(String  uid);


    /**
     * 根据ids批量删除
     * @param ids
     * @return
     */
    public Integer  deleteInsuranceHandle(String[] ids);

    /**
     * 保存功能
     * @param InsuranceHandle
     * @return
     */
    public Integer save(InsuranceHandle InsuranceHandle);
}
