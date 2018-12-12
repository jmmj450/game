package com.spring.board.service;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.board.domain.LevelVO;
import com.spring.board.domain.PointHistoryVO;
import com.spring.board.domain.PointVO;
import com.spring.board.domain.UserVO;
import com.spring.board.persistent.LevelDAO;
import com.spring.board.persistent.PointDAO;
import com.spring.board.persistent.PointHistoryDAO;
import com.spring.board.persistent.UserDAO;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private PointDAO pointDAO;
	
	@Autowired
	private PointHistoryDAO pointHistoryDAO;

	@Autowired
	private LevelDAO levelDAO;
	
	@Override
	public void insert(UserVO userVO) throws Exception {
		userDAO.insert(userVO);
	}

	@Override
	public void delete(int userID) throws Exception {
		userDAO.delete(userID);
	}
	
	@Override
	public void changeValidate(int userID) throws Exception {

		Map<String, Object> map = new HashMap<>();
		map.put("userID", userID);
		
		UserVO userVO = userDAO.selectByID(userID);
		if (userVO.getUserValidate() == 1) {
			map.put("userValidate", 0);
		} else {
			map.put("userValidate", 1);
		}  
		
		userDAO.changeValidate(map);
	}

	@Override
	public int loginCheck(UserVO userVO) throws Exception {
		return userDAO.loginCheck(userVO);
	}

	@Override
	public int countById(String userEmail) {
		return userDAO.countById(userEmail);
	}

	@Override
	public void updatePoint(UserVO userVO) throws Exception {
		userDAO.updatePoint(userVO);
	}

	@Override
	public void insertWithPoint(UserVO userVO, PointHistoryVO pointHistoryVO) throws Exception {
		// 회원 DB 등록
		userDAO.insert(userVO);

		// 포인트값 조회 후 포인트 히스토리 테이블에 저장
		PointVO pointVO = pointDAO.select("join");
		pointHistoryVO.setItemType(pointVO.getItemType());
		pointHistoryVO.setPoint(pointVO.getPoint());
		pointHistoryDAO.insert(pointHistoryVO);

		// user 테이블에 포인트 업데이트
		userVO.setUserPoint(pointVO.getPoint());
		userDAO.updatePoint(userVO);
	}
	
	@Override
	public void loginWithPoint(UserVO userVO, PointHistoryVO pointHistoryVO) throws Exception {
		// 포인트값 조회 후 포인트 히스토리 테이블에 저장
		PointVO pointVO = pointDAO.select("login");
		pointHistoryVO.setItemType(pointVO.getItemType());
		pointHistoryVO.setPoint(pointVO.getPoint());
		pointHistoryDAO.insert(pointHistoryVO);

		// 회원정보
		userVO = userDAO.select(userVO.getUserEmail()); 
		
		// 포인트 추가
		int lastPoint = userVO.getUserPoint() + pointVO.getPoint();
		userVO.setUserPoint(lastPoint);
		
		// 자동등업처리
		LevelVO levelVO = levelDAO.selectMyLevel(lastPoint);
		userVO.setUserLevel(levelVO.getLevel());

		// 로그인 카운트 추가
		userVO.setUserLoginCount(userVO.getUserLoginCount() + 1);
		
		userDAO.updatePointLevelLoginCount(userVO);
	}

	@Override
	public UserVO select(String userEmail) throws Exception {
		return userDAO.select(userEmail);
	}
	
	@Override
	public UserVO selectByID(int userID) throws Exception {
		return userDAO.selectByID(userID);
	}

	@Override
	public void update(UserVO userVO) throws Exception {
		userDAO.update(userVO);
	}

	@Override
	public List<UserVO> list(int page) throws Exception {
		return userDAO.list(page);
	}

	@Override
	public void keepLogin(String userEmail, String sessionId, Date next) {
		userDAO.keepLogin(userEmail, sessionId, next);
		
	}

	@Override
	public UserVO checkUserWithSessionKey(String sessionId) {
		return userDAO.checkUserWithSessionKey(sessionId);
	}

	@Override
	public String findId(UserVO userVO) throws Exception {
		return userDAO.findId(userVO);
	}

	@Override
	public void findPwd(UserVO userVO, String randomPwd) throws Exception {
		userDAO.findPwd(userVO, randomPwd);		
	}
	
	
}
