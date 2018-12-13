package com.spring.board.service;

import java.sql.Date;
import java.util.List;

import com.spring.board.domain.PointHistoryVO;
import com.spring.board.domain.UserVO;

public interface UserService {
	void insert(UserVO userVO) throws Exception;
	UserVO select(String userEmail) throws Exception;
	UserVO selectByID(int userID) throws Exception;
	void delete(int userID) throws Exception;
	void changeValidate(int userID) throws Exception;
	int loginCheck(UserVO userVO) throws Exception;
	int countById(String userEmail);
	void updatePoint(UserVO userVO) throws Exception;

	//회원가입
	//userDAO.insert(userVO);pointDAO.select("join");pointHistoryDAO.insert(pointHistoryVO);userDAO.updatePoint(userVO);
	void insertWithPoint(UserVO userVO, PointHistoryVO pointHistoryVO) throws Exception;	
	
	//로그인
	//pointDAO.select("login");pointHistoryDAO.insert(pointHistoryVO);userDAO.updatePoint(userVO);userDAO.updateLoginCount(userVO.getUserEmail()); 
	void loginWithPoint(UserVO userVO, PointHistoryVO pointHistoryVO) throws Exception;
	
	void update(UserVO userVO) throws Exception;
	
	List<UserVO> list(int page) throws Exception;
    
   // 자동로그인 체크한 경우에 사용자 테이블에 세션과 유효시간을 저장하기 위한 메서드
   public void keepLogin(String userEmail, String sessionId, Date next);
    
   // 이전에 로그인한 적이 있는지, 즉 유효시간이 넘지 않은 세션을 가지고 있는지 체크한다.
   public UserVO checkUserWithSessionKey(String sessionId);
	
   public String findId(UserVO userVO) throws Exception;
   public void findPwd(UserVO userVO, String randomPwd) throws Exception;
}
