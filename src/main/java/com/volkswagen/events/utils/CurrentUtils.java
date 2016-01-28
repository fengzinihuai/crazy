package com.volkswagen.events.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.volkswagen.events.entity.IUser;

/**
 * 当前请求工具类
 * 
 * @author crazy
 * 
 */
public class CurrentUtils {
    
    /**当前用户的session属性名称*/
    private final static String KEY_CURRENT_USER = "curr_user";

    /**
     * 获取当前的请求对象
     * 
     * @return
     */
    public static HttpServletRequest getRequest() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        return servletRequestAttributes.getRequest();
    }

    /**
     * 获取当前的请求对象
     * 
     * @return
     */
    public static <T> T getParam(String param) {
        HttpServletRequest request = getRequest();
        if(request==null){
            return null;
        }
        return (T) request.getParameter(param);
    }
    
    /**
     * 获取当前请求会话信息
     * 
     * @return
     */
    public static HttpSession getSession() {
        return getRequest().getSession();
    }

    /**
     * 获取session属性信息
     * 
     * @param attribute
     *            属性信息
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T getSessoinAttribute(String attribute) {
        HttpSession session = getSession();
        if (session == null) {
            return null;
        }
        return (T) session.getAttribute(attribute);
    }

    /**
     * 
     * 获取当前登录用户
     * 
     * @return
     */
    public static IUser getCurrentUser() {
        return getSessoinAttribute(KEY_CURRENT_USER);
    }

    /**
     * 
     * 将当前用户放入会话中
     * 
     * @return
     */
    public static void setUser(IUser user) {
        setSessoinAttribute(KEY_CURRENT_USER, user);
    }

    /**
     * 获取session属性信息
     * 
     * @param attribute
     *            属性信息
     * @return
     */
    public static void setSessoinAttribute(String attribute, Object value) {
        HttpSession session = getSession();
        if (session == null) {
            return;
        }
        session.setAttribute(attribute, value);
    }
}
