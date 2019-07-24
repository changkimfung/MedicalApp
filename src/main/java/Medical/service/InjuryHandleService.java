package Medical.service;

import Medical.domain.InjuryHandle;
import Medical.framework.page.TableDataInfo;

import java.util.List;

/**
 * 业务逻辑层
 * @author  zjf
 * @date    2019/01/14
 */
public interface InjuryHandleService {

    /**
     * 分页查询
     * @param InjuryHandle
     * @return
     */
    public TableDataInfo selectInjuryHandleListPage(InjuryHandle InjuryHandle);

    /**
     * 根据uid查询
     * @param uid
     * @return
     */
    public InjuryHandle selectInjuryHandleById(String uid);

    /**
     * 根据ids 删除
     * @param ids
     * @return
     */
    public Integer  deleteInjuryHandleByIds(String[] ids);

    /**
     *  保存
     * @param InjuryHandle
     * @return
     */
    public Integer  save(InjuryHandle InjuryHandle);
}
