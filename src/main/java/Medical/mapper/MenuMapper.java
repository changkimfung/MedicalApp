package Medical.mapper;

import Medical.domain.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 菜单管理数据访问层
 * @author zjf
 * @date   2019/01/16
 */
@Mapper
public interface MenuMapper {
    /**
     * 菜单管理
     * @param username
     * @return
     */
    public List<Menu> selectMenuByUsername(@Param("uid")String username,@Param("parId")String parId);


}
