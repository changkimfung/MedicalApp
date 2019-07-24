package Medical.service;

import Medical.domain.User;
import Medical.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 登录业务逻辑实现层
 * @author zjf
 * @date   2019/01/15
 */
@Service
public class LoginServiceimpl  implements  LoginService{

   @Autowired
    private UserMapper userMapper;

    @Override
    public User checkUserIsExit(String username) {
        return userMapper.checkUserNameIsExist(username);
    }
}
