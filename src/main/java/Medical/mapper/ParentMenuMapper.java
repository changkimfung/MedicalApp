package Medical.mapper;

import Medical.domain.ParentMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * mapper层
 * @AUTHOR ZJF
 * @date 2019/01/23
 */
@Mapper
public interface ParentMenuMapper {

  public List<ParentMenu> select(ParentMenu ParentMenu);

}
