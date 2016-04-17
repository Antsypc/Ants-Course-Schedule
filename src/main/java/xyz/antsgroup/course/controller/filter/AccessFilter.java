/**
 * 网站访问过滤，第一个过滤Servlet
 */

package xyz.antsgroup.course.controller.filter;

import org.apache.logging.log4j.ThreadContext;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class AccessFilter
 */
public class AccessFilter implements Filter {

    private String[] excludeArray;  // 不过滤URL数组
    private String[] studentURLs;
    private String[] teacherURLs;
    private String[] labManagerURLs;
    /**
     * Default constructor. 
     */
    public AccessFilter() {
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
    }

    /**
     * 对labms应用每次进行访问时都要进过该Servlet过滤
     * 1. 设置响应编码为UTF-8
     * 2. 如果没有登录，重定向到登录页面
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // place your code here
        
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        HttpServletRequest req = (HttpServletRequest) request;
        ThreadContext.clearAll();

        String requesturi = req.getRequestURI();
        if("/".equals(requesturi)) {
            chain.doFilter(request, response);
            return;
        }
        // 如果是不需要过滤的uri则不过滤：这里主要是登录及登录验证的uri
        for(String s : excludeArray) {
            if(requesturi.equals(s) || requesturi.startsWith(s)) {
                chain.doFilter(request, response);
                return;
            }
        }

        System.out.println(requesturi);
        String user = (String) req.getSession().getAttribute("identity");
        HttpServletResponse rep = (HttpServletResponse) response;
        if(user == null) {
            // 如果用户没登录可以访问该url，但是如果用户登录了，不能让他访问
            if("/logging/login.jsp".equals(requesturi) || "/login".equals(requesturi) ) {
                chain.doFilter(request, response);
                return;
            }
            // 如果请求的不是共有资源（上面）那么拒绝，重新导向至index
            rep.sendRedirect("/index.jsp");
        } else if("student".equals(user)) {
            for(String s : studentURLs) {
                if(requesturi.equals(s)) {
                    chain.doFilter(request, response);
                    return;
                }
            }
            rep.sendError(404);
        } else if("teacher".equals(user)) {
            for(String s : teacherURLs) {
                if(requesturi.equals(s)) {
                    chain.doFilter(request, response);
                    return;
                }
            }
            rep.sendError(404);
        } else if("labManager".equals(user)) {
            for(String s : labManagerURLs) {
                if(requesturi.equals(s) || requesturi.startsWith(s)) {
                    chain.doFilter(request, response);
                    return;
                }
            }
            rep.sendError(404);
        } else {
            chain.doFilter(request, response);
        }
        
    }

    /**
     * 从配置文件读取不过滤URL信息，分割存入excludeArray
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        excludeArray  = fConfig.getInitParameter("exclude").split(";");
        studentURLs    = fConfig.getInitParameter("studentURL").split(";");
        teacherURLs    = fConfig.getInitParameter("teacherURL").split(";");
        labManagerURLs = fConfig.getInitParameter("labManagerURL").split(";");
        //System.out.println(excludeArray + " " + studentURL+  " " + teacherURL + " "+ labManagerURL + " ");
    }

}
