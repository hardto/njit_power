package edu.njit.interceptors;

import edu.njit.WebUtils.ObectUtils;
import edu.njit.WebUtils.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class SystemUrlInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(SystemUrlInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getParameter("token");
        HttpSession session = request.getSession();
        if (!ObectUtils.isEmpty(token) && token.equals((String) session.getAttribute("token"))) {
            logger.warn(WebUtils.getClientIP(request) + "于" + WebUtils.getTimeNow() + "访问此网站");
            return true;
        }
        return false;
    }
}
