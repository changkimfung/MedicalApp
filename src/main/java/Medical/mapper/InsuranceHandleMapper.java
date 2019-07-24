package Medical.mapper;

import Medical.domain.InsuranceHandle;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 数据访问层
 * @date 2019/01/14
 * @author  zjf
 */
@Mapper
public interface InsuranceHandleMapper {

    /**
     * 分页查询
     * @param insuranceHandle
     * @return
     */
    public List<InsuranceHandle>selectInsuranceHandleList(InsuranceHandle insuranceHandle);

    /**
     * 按照id查询
     * @param uid
     * @return
     */
    public InsuranceHandle  selectInsuranceHandleById(String uid);

    /**
     * 根据ids批量删除
     * @param ids
     * @return
     */
    public Integer  deleteInsuranceHandle(String[] ids);

    /**
     * 插入
     * @param InsuranceHandle
     * @return
     */
    public Integer   insertInsuranceHandle(InsuranceHandle InsuranceHandle);

    /**
     * 更新
     * @param InsuranceHandle
     * @return
     */
    public Integer    updateInsuranceHandle(InsuranceHandle InsuranceHandle);
}
