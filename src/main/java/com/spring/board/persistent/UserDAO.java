package com.spring.board.persistent;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import com.spring.board.domain.UserVO;

public interface UserDAO {
	void insert(UserVO userVO) throws Exception;
	UserVO select(String userEmail) throws Exception;
	UserVO selectByID(int userID) throws Exception;
	void delete(int userID) throws Exception;
	void changeValidate(Map<String, Object> map) throws Exception;
	int loginCheck(UserVO userVO) throws Exception;
	int userAdmin(String userEmail) throws Exception;
	int countById(String userEmail);
	void updatePoint(UserVO userVO) throws Exception;
	void updatePointLevelLoginCount(UserVO userVO) throws Exception;
	void update(UserVO userVO) throws Exception;
	List<UserVO> list(int page) throws Exception;
	
    // 자동로그인 체크한 경우에 사용자 테이블에 세션과 유효시간을 저장하기 위한 메서드
    public void keepLogin(String userEmail, String sessionId, Date next);
     
    // 이전에 로그인한 적이 있는지, 즉 유효시간이 넘지 않은 세션을 가지고 있는지 체크한다.
    public UserVO checkUserWithSessionKey(String sessionId);
    
    public String findId(UserVO userVO) throws Exception;
    public void findPwd(UserVO userVO, String randomPwd) throws Exception;
    
}
