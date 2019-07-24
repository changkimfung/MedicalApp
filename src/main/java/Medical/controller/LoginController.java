package Medical.controller;

import Medical.domain.User;
import Medical.framework.Filter.TokenUtils;
import Medical.framework.Util.StringUtils;
import Medical.framework.domain.AjaxResult;
import Medical.framework.domain.BaseController;
import Medical.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录业务操作控制器
 * @author zjf
 * @date   2019/01/15
 */

@Api("登陆业务处理")
@CrossOrigin(origins = "http://localhost:8080",maxAge = 3600)
@RestController
public class LoginController extends BaseController {

    @Autowired
    private LoginService loginService;

    /**
     * 登录功能实现
     * @param username
     * @param password
     * @return
     */
    @ApiOperation("登陆功能")
    @PostMapping("/login")
    public Map login(String username, String password, HttpServletResponse httpServletResponse,HttpServletRequest httpServletRequest) {
        Map resultMsg = new HashMap();

        String code = "0";
        String msg = null;
        if(StringUtils.isEmpty(username)||StringUtils.isEmpty(password)){
            code="0";
            msg="用户名与密码不能为空";
            resultMsg.put("msg", msg);
            resultMsg.put("code", code);
            return resultMsg;
        }
        User user = loginService.checkUserIsExit(username);
        try {
            if (user != null) {
                if (user.getPassword().equalsIgnoreCase(password)) {
                    code = "1";
                    msg = "登录成功";
                    TokenUtils utils=new TokenUtils();
                    String token=utils.createToken(username, password);
//                    HttpSession httpSession=httpServletRequest.getSession();
//                    httpSession.setAttribute("token",token);

                 Cookie cookie=new Cookie("token", token);
//             Cookie cookie=new Cookie("token",httpSession.getId());
                    httpServletResponse.addCookie(cookie);
                    String usertype= user.getUserType();

                    resultMsg.put("usertype",usertype);
                    resultMsg.put("msg", msg);
                    resultMsg.put("code", code);

                } else {
                    msg = "请输入正确的密码";
                    code = "0";
                    resultMsg.put("msg", msg);
                    resultMsg.put("code", code);
                }
            } else {
                msg = "请输入正确的用户名跟密码";
                code = "0";
                resultMsg.put("msg", msg);
                resultMsg.put("code", code);

            }
            return  resultMsg;
        } catch (Exception e) {
            msg="登录异常";
            code="0";
            resultMsg.put("msg",msg);
            resultMsg.put("code",code);
            return resultMsg;

        }

    }  }

