package Medical.service;

import java.util.List;

import Medical.domain.User;
import Medical.framework.page.TableDataInfo;

/**
 * 系统用户表实体类  服务层
 * @author zhengjianfeng
 * @date 2018-12-12
 */
public interface UserService {

    /**
     * 分页
     * @param user
     * @return
     */
	public TableDataInfo selectUserListPage(User user);
   /**
    * 编辑的按id查询
    * @param uid
    * @return
    */
    public User  selectUserListById(String uid);
    /**按uid删除
     * 
     * @param uid
     * @return
     */
    public Integer DeleteUserById(String uid);
    /**
     * 批量删除
     * @param ids
     * @return
     */
    public Integer DelteteUserByIds(String ids);
    /**更新user
     * 
     * @param user
     * @return
     */
    public Integer updateUser(User user);
    /**新增User
     * 
     * @param user
     * @return
     */
    public Integer insertUser(User user);
   /**
    * 保存
    * @param user
    * @return
    */
    public Integer save(User user);
}