package com.qdu.buy.web.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
        Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
            logger.info("------preHandle进入拦截器------");
            //获取session
            //判断用户ID是否存在，不存在就跳转到登录界面
//            logger.info("session 是"+request.getSession().getAttribute("user"));
            if(request.getSession().getAttribute("user") == null){
                logger.info("------:session失效 去登录 直接跳转到login页面！");
                response.sendRedirect(request.getContextPath()+"/toLogin");
                return false;
            }else{
                //刷新session
                logger.info("-------:session有效 不用再去登录 直接往下走");
                request.getSession().setAttribute("user", request.getSession().getAttribute("user"));
                return true;
            }
        }

        @Override
        public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                ModelAndView modelAndView) throws Exception {
            // TODO Auto-generated method stub

        }

        @Override
        public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
            // TODO Auto-generated method stub

        }

    }
