package Medical.service;

import Medical.domain.ProblemItem;
import Medical.framework.page.TableDataInfo;

import java.util.List;

/**
 * 业务逻辑层
 * @author zjf
 * @date   2019/01/14
 */
public interface ProblemItemService {

    /**
     * 分页查询
     * @param problemItem
     * @return
     */
    public TableDataInfo selectProblemItemListPage(ProblemItem problemItem);

    /**
     * 删除
     * @param ids
     * @return
     */
    public Integer deleteProblemItem(String[] ids);

    /**
     * 根据UID查询
     * @param uid
     * @return
     */
    public ProblemItem selectProblemItemById(String uid);

    /**
     * 保存
     * @param problemItem
     * @return
     */
    public Integer  save(ProblemItem problemItem);
}
