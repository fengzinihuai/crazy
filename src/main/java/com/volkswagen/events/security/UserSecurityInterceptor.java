package com.volkswagen.events.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.volkswagen.events.entity.IUser;
import com.volkswagen.events.entity.User;
import com.volkswagen.events.utils.CurrentUtils;

/**
 * 登录验证拦截
 *
 * @author crazy
 * 
 */
public class UserSecurityInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
      //   验证用户是否登陆
         
        IUser user = CurrentUtils.getCurrentUser();
        if (user == null) {
            String email= CurrentUtils.getParam("email");
            IUser u=getUserByEmail(email);
            if( u!=null){
               CurrentUtils.setUser(u);
               return true;
            }
            request.getRequestDispatcher("/login1.jsp").forward(request, response);  
            CurrentUtils.setSessoinAttribute("errormsg", "密码错误,请重新填写");
            return false;
        }
        return true;
    }

    private IUser getUserByEmail(String email) {
        if (email == null || email.trim().equals("")) {
            return null;
        }
        if (CurrentUtils.getParam("password") != null
                && CurrentUtils.getParam("password").toString().equals("123")) {
            User u = new User();
            u.setParams(email);
            return u;
        }
        return null;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }
}
