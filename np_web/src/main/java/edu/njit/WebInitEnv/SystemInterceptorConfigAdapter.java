package edu.njit.WebInitEnv;

import edu.njit.interceptors.SystemUrlInterceptor;
import edu.njit.interceptors.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class SystemInterceptorConfigAdapter implements WebMvcConfigurer {
    @Autowired
    private SystemUrlInterceptor systemUrlInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(systemUrlInterceptor).addPathPatterns("/service/**");
        registry.addInterceptor(new TokenInterceptor()).addPathPatterns("/**");
    }

//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/index").setViewName("/sign/index");
//        registry.addViewController("/index").setViewName("/sign/index");
//    }
}
