package top.tinysand.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        if (request.getSession().getAttribute("examUser") == null) { // 未登录
            // 添加页面信息提示
            request.getSession().setAttribute("msg", "要查看该页面，请先登录");
            // 请求重定向到登录页面
            response.sendRedirect("/login");
            return false;
        }

        // 登录成功，移除提示
        request.getSession().removeAttribute("msg");
        return true;
    }
}
