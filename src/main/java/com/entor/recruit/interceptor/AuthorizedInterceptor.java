package com.entor.recruit.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.entor.recruit.domain.User;
import com.entor.recruit.utils.RecruitConstants;


//��������Ҫʵ��HandlerInterceptor�ӿ�
public class AuthorizedInterceptor implements HandlerInterceptor {

	/**
	 * ���岻��Ҫ���ص�����url
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
		//Ĭ���û�û�е�¼
				boolean flag = false;
				//��������ServletPath
				String servletPath = request.getServletPath();
				
				//�ж������Ƿ���Ҫ����
				
				for (String s : Ignore_URL) {
					if(servletPath.contains(s)){
						flag = true;
						break;
					}
				}
				
				//��������
				
				if(!flag){
					//��ȡsession�е��û�
					//getAttribute��ʾ��request��Χȡ�����õ�����
					User user = (User) request.getSession().getAttribute(RecruitConstants.USER_SESSION);
					//�ж��û��Ƿ�Ϊ�գ���¼��
					if(user == null){
						//�û�δ��¼����ת����¼ҳ��
						request.setAttribute("message", "���ȵ�¼");
						request.getRequestDispatcher(RecruitConstants.LOGIN).forward(request, response);
						return flag;
					}else{
						flag = true;
					}
				}
				return flag;
	}

}
