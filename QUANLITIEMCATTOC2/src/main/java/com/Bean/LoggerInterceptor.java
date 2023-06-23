package com.Bean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoggerInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		// TODO Auto-generated method stub
//		HttpSession httpSession = request.getSession();
//		Object customerId = httpSession.getAttribute("customerId");
//		if(customerId == null) {
//			response.sendRedirect(request.getContextPath() + "/customer/login.htm");
//	        return false;
//		}
//		
		System.out.println("LoggerInterceptor.preHandler()");
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		System.out.println("LoggerInterceptor.postHandle()");
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("LoggerInterceptor.afterCompletion()");

	}

	
	
}
