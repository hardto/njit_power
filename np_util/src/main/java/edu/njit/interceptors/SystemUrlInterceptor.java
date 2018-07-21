package edu.njit.interceptors;

import edu.njit.WebUtils.Const;
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
        HttpSession session = request.getSession();
        if(!ObectUtils.isNone(session)&&!ObectUtils.isEmpty((String) session.getAttribute(Const.USER_KEY))){
            logger.warn(WebUtils.getClientIP(request)+"于"+WebUtils.getTimeNow()+"访问此网站");
            return true;
        }
        logger.warn(WebUtils.getClientIP(request)+"于"+WebUtils.getTimeNow()+"未登录访问此网站");
        return false;

    }
}
