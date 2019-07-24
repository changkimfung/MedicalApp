package Medical.framework.Filter;


import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.regex.Pattern;

/**
 * @author zjf
 * @date 2019/3/21 10:09
 */
//@Component
public class AcessFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("**********校园医疗管理系统过滤器启动**********");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest= (HttpServletRequest) request;
        Cookie[] cookies = httpServletRequest.getCookies();
        long deadline=0;
        long now=0;
        HttpServletResponse httpServletResponse= (HttpServletResponse) response;
        String username=null;
        TokenUtils tokenUtils=new TokenUtils();
        System.out.println("*******过滤器使用中*********");
        String uri = httpServletRequest.getRequestURI();
        boolean needFilter = isNeedFilter(uri);
        if (!needFilter) { //不需要过滤直接传给下一个过滤器
            chain.doFilter(request, response);

        }
       else {
            if(cookies!=null) {
                String token=null;
                for (Cookie cookie : cookies) {
                if (cookie.getName().toString().equalsIgnoreCase("token")) {
                    token= cookie.getValue();
                    username = tokenUtils.getClaims(token).get("username").toString();
                    String password = tokenUtils.getClaims(token).get("password").toString();
                    deadline =Long.valueOf(tokenUtils.getClaims(token).get("deadline").toString());
                    now= System.currentTimeMillis();

                }
            }
            if (deadline>now) {
                System.out.println("过滤不成功");
                chain.doFilter(request, response);
            }
            else {
                httpServletResponse.setStatus(999);
            }
              if(token!=null){
                  System.out.println("过滤不成功");
                  chain.doFilter(request, response);
              }
              else {
                  httpServletResponse.setStatus(999);
              }
            }

        }



    }
    public boolean isNeedFilter(String uri) {
        String[] urls={"/login/*",".*swagger.*","/swagger-ui.html#/*",".*api-docs.*",".*/Medical/static/css/static/.*"};
        for(String url:urls){
            boolean fi= Pattern.matches(url, uri);
            if(fi) {
                System.out.println("不需要过滤");
                return false;
            }}

                return true;
    }


    @Override
    public void destroy() {

    }
}
