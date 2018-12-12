package com.spring.board.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.spring.board.domain.UserVO;
import com.spring.board.service.UserService;

public class SessionInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	UserService userService;
	
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		
		
		 // session 객체를 가져옴
	     //  HttpSession session = request.getSession();
	       // login처리를 담당하는 사용자 정보를 담고 있는 객체를 가져옴
	       Object obj = session.getAttribute("userEmail");

//			String reqUrl = request.getRequestURL().toString();
//		    System.out.println(reqUrl);
//			
//		    URL url = new URL(reqUrl);
		    
//		    URL naverNewURL = new URL("https://news.naver.com:80");
//		    url = new URL(naverNewURL, "/main/list.nhn?mode=LSD&mid=sec&sid1=001");
//		    System.out.println("프로토콜:" + url.getProtocol());
//			System.out.println("호스트명:" + url.getHost());
//			System.out.println("포트번호:" + url.getPort());
//			System.out.println("경로부분:" + url.getPath());
//			System.out.println("파일이름:" + url.getFile());
		    
	       if ( obj == null ){ // 로그인된 세션이 없는 경우...
	           // 우리가 만들어 논 쿠키를 꺼내온다.
	    		Cookie[] cookies = request.getCookies();
	    		if (cookies != null) {
	    			for (Cookie cookie : cookies ) {
	    				//System.out.println(cookie.getName());
	    				if (cookie.getName().equals("loginCookie")) {
			               String sessionId = cookie.getValue();
			               // 세션Id를 checkUserWithSessionKey에 전달해 이전에 로그인한적이 있는지 체크하는 메서드를 거쳐서
			               // 유효시간이 > now() 인 즉 아직 유효시간이 지나지 않으면서 해당 sessionId 정보를 가지고 있는 사용자 정보를 반환한다.
			               UserVO userVO = userService.checkUserWithSessionKey(sessionId);
			                
			               if ( userVO != null ){ // 그런 사용자가 있다면
			                   // 세션을 생성시켜 준다.
			                   session.setAttribute("userEmail", userVO.getUserEmail());
			                   session.setAttribute("userAdmin", userVO.getUserAdmin());
			                   //return true;
			               }

	    				}
	    			}
	    		}
	    }
		
		
		String reqUrl = request.getRequestURL().toString();
		System.out.println("reqUrl : "+reqUrl);
		if(reqUrl.contains("/")){
			return true;
		}else if(reqUrl.contains("/ps4/board")){
			return true;
		}else if(reqUrl.contains("/ps4/detail"))
			return true;
		if(session.getAttribute("userEmail") == null){
			response.sendRedirect("/user/loginForm");
			return false;
		}
		
		return true;
		
	}

	
}
