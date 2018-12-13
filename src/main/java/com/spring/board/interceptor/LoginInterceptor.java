package com.spring.board.interceptor;

import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.spring.board.domain.UserVO;
import com.spring.board.service.UserService;

public class LoginInterceptor 
extends HandlerInterceptorAdapter {
	
	@Autowired
	UserService userService;
	
//	@Override
//	public boolean preHandle(HttpServletRequest request,
//			HttpServletResponse response, Object handler) throws Exception {
//		HttpSession session = request.getSession();
//		System.out.println("preHandle");
//		
//		if(session.getAttribute("userEmail") != null){
//			session.removeAttribute("userEmail");
//			session.removeAttribute("userAdmin");
//			System.out.println("===== session validate");
//		}
//
//       return true;
//	}
	
/*	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle");
		HttpSession session = request.getSession();
		ModelMap modelMap = modelAndView.getModelMap();
		UserVO userVO = (UserVO)modelMap.get("userVO");
		int result = (Integer)modelMap.get("result");
		
		System.out.println("modelMap.get(result) : " + modelMap.get("result"));
		
		String keepLogin = (String)modelMap.get("keepLogin");
		
		if(result == 1){ // 회원데이터가 있고
			 if (userVO.getUserValidate()==1) {  // 활성화가 되어있으면
				session.setAttribute("userEmail", userVO.getUserEmail());
				session.setAttribute("userAdmin", userVO.getUserAdmin());
				
				//System.out.println("keepLogin : " + keepLogin);
				
				if(keepLogin.equals("yes")){
				    // 쿠키 사용한다는게 체크되어 있으면...
	                // 쿠키를 생성하고 현재 로그인되어 있을 때 생성되었던 세션의 id를 쿠키에 저장한다.
	                Cookie cookie = new Cookie("loginCookie", session.getId());
	                // 쿠키를 찾을 경로를 컨텍스트 경로로 변경해 주고...
	                cookie.setPath("/");
	                int amount = 60*60*24*7;
	                cookie.setMaxAge(amount); // 단위는 (초)임으로 7일정도로 유효시간을 설정해 준다.
	                // 쿠키를 적용해 준다.
	                response.addCookie(cookie);
	                 
	                // currentTimeMills()가 1/1000초 단위임으로 1000곱해서 더해야함 
	                Date sessionLimit = new Date(System.currentTimeMillis() + (1000*amount));
	                // 현재 세션 id와 유효시간을 사용자 테이블에 저장한다.
	                userService.keepLogin(userVO.getUserEmail(), session.getId(), sessionLimit);
	                
				}
				
				System.out.println("===== login success");
			 } else {
				response.setContentType("text/html; charset=UTF-8");
	            PrintWriter out = response.getWriter();
	            out.println("<script>");
	            out.println("alert('미인증회원임');");
	            out.println("history.back();");
	            out.println("</script>");
	            out.close();
			 }
		}
	}*/
}
