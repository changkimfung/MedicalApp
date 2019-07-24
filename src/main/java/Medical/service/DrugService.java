package Medical.service;

import Medical.domain.Drug;
import Medical.framework.page.TableDataInfo;

/**
 * 业务逻辑层
 * @AUTHOR zjf
 * @date 2019/01/14
 */
public interface DrugService {
    /**
     * 分页查询
     * @param drug
     * @return
     */
    public TableDataInfo selectDrugPage(Drug drug);

    /**
     * 根据Uid来查询
     * @param uid
     * @return
     */
    public Drug selectDrugById(String uid);

    /**
     * 删除Drug
     * @param ids
     * @return
     */
    public Integer deleteDrug(String[] ids);

    /**
     * 保存Drug功能
     * @param drug
     * @return
     */
    public Integer save(Drug drug);
}
