package com.mingda.interceptor;

import java.lang.reflect.Method;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jgroups.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.mingda.annotation.AvoidDuplicateSubmission;
import com.mingda.entity.Attorneyrecord;
import com.mingda.service.privilege.UserService;

public class AvoidDuplicateSubmissionInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private UserService userService;// 注入业务接口
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {	
		long id = 1224850;
		System.out.println(id);
		Attorneyrecord userInfo = userService.getById(Attorneyrecord.class, new Long(1224850));
		System.out.println(userInfo.getAId());
		Attorneyrecord userInfo1 = userService.getById(Attorneyrecord.class, new Long(1224850));
		System.out.println(userInfo1.getAId());
		// User user = UserUtil.getUser();

		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Method method = handlerMethod.getMethod();

		AvoidDuplicateSubmission annotation = method.getAnnotation(AvoidDuplicateSubmission.class);
		if (annotation != null) {
			String viewtype = annotation.viewtype();
			String sendpage = annotation.sendpage();
			boolean needSaveSession = annotation.needSaveToken();
			if (needSaveSession) {
				request.getSession(false).setAttribute("token", UUID.randomUUID().toString());
			}

			boolean needRemoveSession = annotation.needRemoveToken();
			if (needRemoveSession) {
				System.out.println(1);
				if (isRepeatSubmit(request)) {
					if ("json".equals(viewtype)) {
						System.out.println(11);
						response.reset();
						response.setContentType("text/plain; charset=utf-8");
						response.setCharacterEncoding("UTF-8");
						ServletOutputStream out = response.getOutputStream();
						String a = new String("阿三的发生大的".getBytes("UTF-8"), "ISO-8859-1");
						out.println(a);
						out.flush();
						out.close();
						System.out.println(12);
					} else {
						String path = request.getContextPath();
						String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/error/";
						response.sendRedirect(basePath+""+sendpage);
					}

				}
				System.out.println(2);
				request.getSession(false).removeAttribute("token");
				System.out.println(3);
			}
		}

		return true;
	}

	private boolean isRepeatSubmit(HttpServletRequest request) {
		String serverToken = (String) request.getSession(false).getAttribute("token");
		if (serverToken == null) {
			return true;
		}
		String clinetToken = request.getParameter("token");
		if (clinetToken == null) {
			return true;
		}
		if (!serverToken.equals(clinetToken)) {
			return true;
		}
		return false;
	}

}