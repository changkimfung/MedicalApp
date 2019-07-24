package Medical.service;

import Medical.domain.ProblemItem;
import Medical.framework.Util.StringUtils;
import Medical.framework.page.PageUtil;
import Medical.framework.page.TableDataInfo;
import Medical.mapper.ProblemItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * 业务逻辑实现层
 * @author  zjf
 * @DATE    2019/01/14
 */

@Service
public class ProblemItemServiceimpl implements ProblemItemService {

    @Autowired
    private ProblemItemMapper problemItemmapper;

    /**
     * 分页查询
     * @param problemItem
     * @return
     */

    @Override
    public TableDataInfo selectProblemItemListPage(ProblemItem problemItem) {

        PageUtil.startPage(problemItem);
        List<ProblemItem> list =problemItemmapper.selectProblemItemList(problemItem);
        return PageUtil.getDataTable(list);
    }

    @Override
    public Integer deleteProblemItem(String[] ids) {
        int rows=problemItemmapper.deleteProblemItem(ids);
        return rows;
    }

    @Override
    public ProblemItem selectProblemItemById(String uid) {
        ProblemItem problemItem =problemItemmapper.selectProblemItemById(uid);
        return problemItem;
    }

    @Override
    public Integer save(ProblemItem problemItem) {
        String proId=problemItem.getUid();
        int rows=0;
        if (StringUtils.isNotEmpty(proId)){
            rows=problemItemmapper.updateProblemItem(problemItem);
        }
        else{
            Date date =new Date();
            long a =date.getTime();
            String a1="010"+String.valueOf(a);
            problemItem.setUid(a1);
            rows=problemItemmapper.insertProblemItem(problemItem);
        }
        return rows;
    }


}
