package Medical.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import Medical.domain.User;
import Medical.framework.page.TableDataInfo;

/**
 * 系统用户表实体类  数据层
 * @author zhengjianfeng
 * @date 2018-12-12
 */

@Mapper
public interface UserMapper {
	
	
	/**
	 *  检验数据库是否有username 
	 * @param username
	 * @return
	 */
	

	public User  checkUserNameIsExist(@Param("username")String username);
   
	/**
	 * 分页查询
	 * @param user
	 * @return
	 */
    public List<User> selectUserListPage(User user);
    
    /**
     * 编辑的 按Id搜寻
     * @param uid
     * @return
     */
    public User selectUserListById(String uid);
    /**
     * 根据id删除
     * @param uid
     * @return
     */
    public Integer DeleteUserById(String uid);
    /**
     * 根据ids 批量删除
     * @param ids
     * @return
     */
    public Integer DeleteUserByIds(String []ids);
    
    /**
     * update更新
     * @param user
     * @return
     */
    public Integer updateUser(User user);
    
    /**
     * insert插入
     */
    public Integer insertUser(User user);
}
