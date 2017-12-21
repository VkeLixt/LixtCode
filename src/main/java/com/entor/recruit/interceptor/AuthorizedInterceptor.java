package com.entor.recruit.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.entor.recruit.domain.User;
import com.entor.recruit.utils.RecruitConstants;


//拦截器需要实现HandlerInterceptor接口
public class AuthorizedInterceptor implements HandlerInterceptor {

	/**
	 * 定义不需要拦截的请求url
	 * 
	 */
	
	private static final String[] Ignore_URL = {
			"/index","/login","404.html","/register","/regist","/loginname","/cardid","/getCode","/getSession"
	};
	
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		//默认用户没有登录
				boolean flag = false;
				//获得请求的ServletPath
				String servletPath = request.getServletPath();
				
				//判断请求是否需要拦截
				
				for (String s : Ignore_URL) {
					if(servletPath.contains(s)){
						flag = true;
						break;
					}
				}
				
				//拦截请求
				
				if(!flag){
					//获取session中的用户
					//getAttribute表示从request范围取得设置的属性
					User user = (User) request.getSession().getAttribute(RecruitConstants.USER_SESSION);
					//判断用户是否为空（登录）
					if(user == null){
						//用户未登录，跳转至登录页面
						request.setAttribute("message", "请先登录");
						request.getRequestDispatcher(RecruitConstants.LOGIN).forward(request, response);
						return flag;
					}else{
						flag = true;
					}
				}
				return flag;
	}

}
