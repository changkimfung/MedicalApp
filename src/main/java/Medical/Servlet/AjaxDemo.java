package Medical.Servlet;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController("/checkName")
public class AjaxDemo extends HttpServlet {
  protected void service(HttpServletRequest request, HttpServletResponse httpServletResponse) throws IOException {
      String username=request.getParameter("username");
      if(username.equals("15551102081")){
        httpServletResponse.getWriter().println(false);
      }else {
        httpServletResponse.getWriter().println(true);
      }
  }
}
