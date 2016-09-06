package customerproductorder.web.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object o) throws Exception {
        HttpSession session = request.getSession(false);
        if (request.getServletPath().equals("/login")) {
            return true;
        } else if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login");
            return false;
        } else {
            return true;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request,
            HttpServletResponse response, Object o,
            ModelAndView mav) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request,
            HttpServletResponse response, Object o,
            Exception excptn) throws Exception {

    }

}
