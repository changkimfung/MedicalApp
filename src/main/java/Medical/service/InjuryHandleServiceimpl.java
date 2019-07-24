package Medical.service;

import Medical.domain.InjuryHandle;
import Medical.framework.Util.StringUtils;
import Medical.framework.page.PageUtil;
import Medical.framework.page.TableDataInfo;
import Medical.mapper.InjuryHandleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;


/**
 * 业务逻辑层实现类
 * @Author zjf
 * @date   2019/01/14
 */
@Service
public class InjuryHandleServiceimpl implements InjuryHandleService {

        @Autowired
        private InjuryHandleMapper injuryHandleMapper;

    /**
     * 分页查询
     * @param injuryHandle
     * @return
     */
    @Override
    public TableDataInfo selectInjuryHandleListPage(InjuryHandle injuryHandle) {
        PageUtil.startPage(injuryHandle);
        List<InjuryHandle> list =injuryHandleMapper.selectInjuryHandleList(injuryHandle);
        return PageUtil.getDataTable(list);
    }

    /**
     * 按照id查询
     * @param uid
     * @return
     */
    @Override
    public InjuryHandle selectInjuryHandleById(String uid) {
        InjuryHandle list =injuryHandleMapper.selectInjuryHandleById(uid);
        return list;
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @Override
    public Integer deleteInjuryHandleByIds(String[] ids) {
        int rows=injuryHandleMapper.deleteInjuryHandleByIds(ids);
        return rows;
    }

    /**
     * 保存功能
     * @param injuryHandle
     * @return
     */
    @Override
    public Integer save(InjuryHandle injuryHandle) {
        String id=injuryHandle.getUid();
        int rows =0;
        if (StringUtils.isNotNull(id)){
            rows=injuryHandleMapper.updateInjuryHandle(injuryHandle);

        }
        else{
            Date date =new Date();
            long a =date.getTime();
            String a1="010"+String.valueOf(a);
            injuryHandle.setUid(a1);
            injuryHandle.setStatus("0");
            rows=injuryHandleMapper.insertInjuryHandle(injuryHandle);
        }
        return rows;
    }
}
