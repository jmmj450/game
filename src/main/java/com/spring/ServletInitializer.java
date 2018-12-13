package com.spring;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.stereotype.Component;

import com.spring.board.domain.LevelVO;
import com.spring.board.domain.PointVO;
import com.spring.board.domain.UserVO;
import com.spring.board.persistent.LevelDAO;
import com.spring.board.persistent.PointDAO;
import com.spring.board.service.UserService;

@Component
public class ServletInitializer extends SpringBootServletInitializer {
	
	@Autowired
	private LevelDAO levelDAO; 
	@Autowired 
	private PointDAO pointDAO;
	@Autowired
	private UserService userService;

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(GameApplication.class);
	}

//	@Override
//	public void onStartup(ServletContext servletContext) throws ServletException {
//		// TODO Auto-generated method stub
//		super.onStartup(servletContext);
//
//		try {
//			System.out.println("levelDAO.count() : " + levelDAO.count());
//			System.out.println("pointDAO.count() : " + pointDAO.count());
//			System.out.println("userService.list(1).size() : " + userService.list(1).size());
//			
//			if (levelDAO.count() == 0) {
//				levelDAO.insert(new LevelVO(10, 1));
//				levelDAO.insert(new LevelVO(20, 2));
//				levelDAO.insert(new LevelVO(30, 3));
//				levelDAO.insert(new LevelVO(50, 4));
//				levelDAO.insert(new LevelVO(100, 5));
//				levelDAO.insert(new LevelVO(150, 6));
//				levelDAO.insert(new LevelVO(200, 7));
//				levelDAO.insert(new LevelVO(250, 8));
//				levelDAO.insert(new LevelVO(300, 9));
//				levelDAO.insert(new LevelVO(320, 10));
//			}
//
//			if (pointDAO.count() == 0) {
//				pointDAO.insert(new PointVO("회원가입", "join", 50));
//				pointDAO.insert(new PointVO("로그인", "login", 20));
//				pointDAO.insert(new PointVO("글쓰기", "write", 30));
//				pointDAO.insert(new PointVO("댓글달기", "reple", 20));		
//				
//			}
//
//			if (userService.list(1).size() == 0) {
//				userService.insert(new UserVO("harom99@gmail.com", "1234", "홍길동", "0", "서울특별시 동작구 노량진로 171-2, 123 (노량진동)", 1160, 10, 69, "2018-11-30 10:21:27", 1, "1"));
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	} //onStartup()

}
