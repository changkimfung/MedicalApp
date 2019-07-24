package Medical.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import Medical.domain.User;
import Medical.framework.Util.StringUtils;
import Medical.framework.page.PageUtil;
import Medical.framework.page.TableDataInfo;
import Medical.mapper.UserMapper;

/**
 * 系统用户表实体类  服务层实现
 *
 * @author zhengjianfeng
 * @date 2018-12-12
 */
@Service

public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper usermapper;

    @Override
    public TableDataInfo selectUserListPage(User user) {
        // TODO 自动生成的方法存根
        PageUtil.startPage(user);
        List<User> list = usermapper.selectUserListPage(user);
        return PageUtil.getDataTable(list);
    }

    @Override
    public User selectUserListById(String uid) {
        // TODO 自动生成的方法存根
        User a = usermapper.selectUserListById(uid);
        System.out.println(1);
        return a;
    }

    @Override
    public Integer DeleteUserById(String uid) {
        // TODO 自动生成的方法存根
        return usermapper.DeleteUserById(uid);
    }

    @Override
    public Integer DelteteUserByIds(String ids) {
        // TODO 自动生成的方法存根
        return usermapper.DeleteUserByIds(StringUtils.toStrArray(ids));
    }

    @Override
    public Integer updateUser(User user) {
        // TODO 自动生成的方法存根
        return usermapper.updateUser(user);
    }

    @Override
    public Integer insertUser(User user) {
        // TODO 自动生成的方法存根
        return usermapper.insertUser(user);
    }

    public Integer save(User user) {
        String uid = user.getUid();
        int rows = 0;
        if (StringUtils.isNotNull(uid)) {
            rows = usermapper.updateUser(user);
        } else {
            Date date =new Date();
            long a =date.getTime();
            String a1="010"+String.valueOf(a);
            user.setUid(a1);
            rows = usermapper.insertUser(user);

        }

        return rows;

    }
}
