package Medical.mapper;

import Medical.domain.ProblemItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zjf
 * @date 2019/1/14
 */
@Mapper
public interface ProblemItemMapper {

    /**
     * 分页查询
     * @param problemItem
     * @return
     */
    public List<ProblemItem> selectProblemItemList(ProblemItem  problemItem);

    /**
     * delete删除
     * @param ids
     * @return
     */
    public Integer deleteProblemItem(String[] ids );

    /**
     * 根据ID查询
     * @param uid
     * @return
     */
    public ProblemItem selectProblemItemById(String uid);

    /**
     * 更新
     * @param problemItem
     * @return
     */
    public Integer updateProblemItem(ProblemItem    problemItem);

    /**
     * 新增
     * @param problemItem
     * @return
     */
    public  Integer insertProblemItem(ProblemItem problemItem);

}
