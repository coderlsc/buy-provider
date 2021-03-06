package com.qdu.buy.config;


import com.qdu.buy.web.interceptor.AdminInterceptor;
import com.qdu.buy.web.interceptor.LoginInterceptor;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan
public class WebConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public WebConfig() {
        super();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/static/");
        registry.addResourceHandler("/templates/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/templates/");
        super.addResourceHandlers(registry);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截规则：除了login，其他都拦截判断
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/user/**").addPathPatterns("/cart/**");
        registry.addInterceptor(new AdminInterceptor()).addPathPatterns("/admin/**").excludePathPatterns("/admin/login").excludePathPatterns("/admin/login2").excludePathPatterns("/admin/register");
//        .excludePathPatterns("/toLogin").excludePathPatterns("/user/login").excludePathPatterns("/")
//                .excludePathPatterns("/toRegister").excludePathPatterns("/index").excludePathPatterns("/purchaser/register").excludePathPatterns("/purchaser/login")
//                .excludePathPatterns("/toConfirm").excludePathPatterns("/downloadTemplate").excludePathPatterns("/*.html");
        super.addInterceptors(registry);
    }

}