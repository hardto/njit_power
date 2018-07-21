package edu.njit.WebInitEnv;

import edu.njit.interceptors.SystemUrlInterceptor;
import edu.njit.WebUtils.ObectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class SystemInterceptorConfigAdapter implements WebMvcConfigurer {
    private Logger logger = LoggerFactory.getLogger(SystemInterceptorConfigAdapter.class);
    @Autowired
    private SystemUrlInterceptor systemUrlInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(systemUrlInterceptor).addPathPatterns("/**");
    }
}
