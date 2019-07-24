package Medical.service;

import Medical.domain.User;

/**
 * 登录业务逻辑层
 * @author zjf
 * @date 2019/01/15
 */
public interface LoginService {

    /**
     * 判断录入的是否存在
     * @param username
     * @return
     */
    public User checkUserIsExit(String username);
}
