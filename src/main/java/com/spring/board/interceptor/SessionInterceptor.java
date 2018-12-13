package com.spring.board.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SessionInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();

		// session 객체를 가져옴
		// HttpSession session = request.getSession();
		// login처리를 담당하는 사용자 정보를 담고 있는 객체를 가져옴
		String userEmail = (String) session.getAttribute("userEmail");
		String userAdmin = (String) session.getAttribute("userAdmin");
		
		
		System.out.println("SessionInterceptor userEmail: " + userEmail + ", userAdmin: " + userAdmin);
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

		if (userEmail == null || userAdmin == null) { // 로그인된 세션이 없는 경우...
			// 우리가 만들어 논 쿠키를 꺼내온다.
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					// System.out.println(cookie.getName());
					if (cookie.getName().equals("userEmail")) {
						userEmail = cookie.getValue();
						System.out.println("cookie userEmail : " + userEmail);

						// 세션Id를 checkUserWithSessionKey에 전달해 이전에 로그인한적이 있는지 체크하는 메서드를 거쳐서
						// 유효시간이 > now() 인 즉 아직 유효시간이 지나지 않으면서 해당 sessionId 정보를 가지고 있는 사용자 정보를 반환한다.
//						if (sessionId != null) {
//							UserVO userVO = userService.checkUserWithSessionKey(sessionId);
//							System.out.println(userVO);
//							
//							if (userVO != null) { // 그런 사용자가 있다면
//								// 세션을 생성시켜 준다.
//								session.setAttribute("userEmail", userVO.getUserEmail());
//								session.setAttribute("userAdmin", userVO.getUserAdmin());
//								// return true;
//							}
//						}
					} // if

					if (cookie.getName().equals("userAdmin")) {
						userAdmin = cookie.getValue();
						System.out.println("cookie userAdmin : " + userAdmin);
					}
				} // for
			} // if
			
			session.setAttribute("userEmail", userEmail);
			session.setAttribute("userAdmin", userAdmin);
		}


		
		String reqUrl = request.getRequestURL().toString();
		System.out.println("reqUrl : " + reqUrl);
		if (reqUrl.contains("/")) {
			return true;
		} else if (reqUrl.contains("/ps4/board")) {
			return true;
		} else if (reqUrl.contains("/ps4/detail"))
			return true;
		if (session.getAttribute("userEmail") == null) {
			response.sendRedirect("/user/loginForm");
			return false;
		}

		return true;
	}

}
