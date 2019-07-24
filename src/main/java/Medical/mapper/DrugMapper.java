package Medical.mapper;

import Medical.domain.Drug;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author  zjf
 * @date    2019/01/14
 *
 */
@Mapper
public interface DrugMapper {

    /**
     * 分页查询drug
     * @param drug
     * @return
     */
    public List<Drug> selectDrug(Drug drug);

    /**
     * 通过uid查询
     * @param uid
     * @return
     */
    public Drug selectDrugById(String uid);

    /**
     * 通过id数组批量删除
     * @param ids
     * @return
     */
    public Integer deleteDrug(String[] ids);

    /**
     * 更新Drug
     * @param drug
     * @return
     */
    public Integer updateDrug(Drug drug);

    /**
     * 插入Drug
     * @param drug
     * @return
     */
    public Integer insertDrug(Drug drug);
}
