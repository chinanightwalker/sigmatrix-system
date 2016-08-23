package com.sigmatrix.sc.web.filter;
/** 
 * @author  zln:
 * @date 创建时间：2016年7月29日 下午4:40:48 
 * @parameter   
 * @return 
 */
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;



/**
 * shiro自定义过滤器，解决DWZ会话超时不跳转登录页
 * 
 * @author liushihao
 *
 */
public class StandardadminFormAuthenticationFilter extends FormAuthenticationFilter {
  /**
   * 访问被拒绝
   */
  @Override
  protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
    if (isLoginRequest(request, response)) {
      if (isLoginSubmission(request, response)) {
        return executeLogin(request, response);
      } else {
        return true;
      }
    } else {
      HttpServletResponse res = WebUtils.toHttp(response);
      String url = WebUtils.toHttp(request).getRequestURL().toString();
      int index = url.indexOf("activity");
      if(index!=-1)
      url.substring(0,index);
      if (isAjaxRequest(WebUtils.toHttp(request))) {
          String msg = "{\"statusCode\":\"" + 301 + "\", \"message\":\"" + "会话超时,请重新登录" + "\"}";
          res.setContentType("application/json;charset=utf-8");
          res.getWriter().write(msg);
      } else if(WebUtils.toHttp(request).getRequestURI().contains("activity/list") || WebUtils.toHttp(request).getRequestURI().contains("activity/toEdit") || WebUtils.toHttp(request).getRequestURI().contains("prize/list")
    		  || WebUtils.toHttp(request).getRequestURI().contains("prize/input")){
    	  res.setCharacterEncoding("UTF-8");
          res.getWriter().write("<script type='text/javascript'>parent.alertMsg.error('会话超时,请重新登录', {okCall:function(){parent.DWZ.loadLogin();}});</script>");
      }else {
        redirectToLogin(request, response);
      }
      return false;
    }
  }

  private boolean isAjaxRequest(HttpServletRequest request) {
    return request.getHeader("x-requested-with") != null;
  }
}

