package Medical.mapper;

import Medical.domain.InjuryHandle;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InjuryHandleMapper {

    /**
     * 分页查询
     * @param InjuryHandle
     * @return
     */
    public List<InjuryHandle> selectInjuryHandleList(InjuryHandle InjuryHandle);

    /**
     * 根据uid查询
     * @param uid
     * @return
     */
    public InjuryHandle selectInjuryHandleById(String uid);

    /**
     * 根据ids delete
     * @param ids
     * @return
     */
    public Integer  deleteInjuryHandleByIds(String[] ids);

    /**
     * 插入InjuryHandle
     * @param InjuryHandle
     * @return
     */
    public Integer insertInjuryHandle(InjuryHandle InjuryHandle);

    /**
     * 更新InjuryHandle
     * @param InjuryHandle
     * @return
     */
    public Integer updateInjuryHandle(InjuryHandle InjuryHandle);


}
