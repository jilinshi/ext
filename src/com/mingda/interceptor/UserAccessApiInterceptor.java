package com.mingda.interceptor;

import java.lang.reflect.Method;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.mingda.annotation.AccessRequired;

public class UserAccessApiInterceptor extends HandlerInterceptorAdapter {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Method method = handlerMethod.getMethod();
		AccessRequired annotation = method.getAnnotation(AccessRequired.class);
		if (annotation != null) {
			System.out.println("你遇到了：@AccessRequired");
			String accessToken = request.getParameter("access_token");
			/**
			 * Do something
			 */
			if (null == accessToken || "".equals(accessToken)) {
				return true;
			} else {
				System.out.println(11);
				response.reset();
				response.setContentType("text/plain; charset=utf-8");
				response.setCharacterEncoding("UTF-8");
				ServletOutputStream out = response.getOutputStream();
				String a=new String("阿三的发生大的".getBytes("UTF-8"),"ISO-8859-1");
				out.println(a);
				out.flush();
				out.close();
				System.out.println(12);
			}
		}
		// 没有注解通过拦截
		return true;

	}
}