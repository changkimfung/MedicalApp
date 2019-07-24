package Medical.service;

import Medical.domain.Drug;
import Medical.framework.Util.StringUtils;
import Medical.framework.page.PageUtil;
import Medical.framework.page.TableDataInfo;
import Medical.mapper.DrugMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class DrugServiceimpl implements DrugService {

    @Autowired
    private DrugMapper drugmapper;

    /**
     * 分页查询
     * @param drug
     * @return
     */
    @Override
    public TableDataInfo selectDrugPage(Drug drug){
        PageUtil.startPage(drug);
        List<Drug> list = drugmapper.selectDrug(drug);
        return PageUtil.getDataTable(list);

    }

    /**
     * 根据ID查询
     * @param uid
     * @return
     */
    @Override
    public Drug selectDrugById(String uid) {
        return drugmapper.selectDrugById(uid);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @Override
    public Integer deleteDrug(String[] ids) {
        return drugmapper.deleteDrug(ids);
    }

    @Override
    public Integer save(Drug drug) {
        String uid=drug.getUid();
        int rows=0;
        if(StringUtils.isNotNull(uid)){
            rows=drugmapper.updateDrug(drug);
        }
        else{
            Date date =new Date();
            long a =date.getTime();
            String a1="010"+String.valueOf(a);
            drug.setUid(a1);
            rows=drugmapper.insertDrug(drug);
        }
        return rows;
    }


}
