package com.spring.board.persistent;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.taglibs.standard.tag.common.sql.DataSourceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.board.domain.UserVO;

@Mapper
@Repository
public class UserDAOImpl implements UserDAO{

	@Autowired
	private SqlSession session;
	private static final String namespace = "com.spring.user";
	
	@Override
	public void insert(UserVO userVO) throws Exception {
		session.insert(namespace+".insert", userVO);
	}

	@Override
	public void delete(int userID) throws Exception {
		session.delete(namespace+".delete", userID);
	}
	
	@Override
	public void changeValidate(Map<String, Object> map) throws Exception {
		session.update(namespace+".changeValidate", map);
	}

	@Override
	public int loginCheck(UserVO userVO) throws Exception {
		return session.selectOne(namespace+".loginCheck", userVO);
	}
	
	@Override
	public int userAdmin(String userEmail) throws Exception {
		return session.selectOne(namespace+".userAdmin", userEmail);
	}
	
	@Override
	public int countById(String userEmail) {
		return session.selectOne(namespace+".chkDupId", userEmail);
	}
	
	@Override
	public void updatePoint(UserVO userVO) throws Exception {
		session.update(namespace+".updatePoint", userVO);
	}

	@Override
	public UserVO select(String userEmail) throws Exception {
		return session.selectOne(namespace+".select", userEmail);
	}
	
	@Override
	public UserVO selectByID(int userID) throws Exception {
		return session.selectOne(namespace+".selectByID", userID);
	}

	@Override
	public void updatePointLevelLoginCount(UserVO userVO) throws Exception {
		session.update(namespace+".updatePointLevelLoginCount", userVO);
	}

	@Override
	public void update(UserVO userVO) throws Exception {
		session.update(namespace+".update", userVO);
	}

	@Override
	public List<UserVO> list(int page) throws Exception {
		return session.selectList(namespace+".list", (page-1)*5);
	}

	@Override
	public void keepLogin(String userEmail, String sessionId, Date next) {
	    Map<String, Object> map = new HashMap<>();
        map.put("userEmail", userEmail);
        map.put("sessionId", sessionId);
        map.put("next", next);
        session.update(namespace+".keepLogin", map);
	}

	@Override
	public UserVO checkUserWithSessionKey(String sessionId) {
        // 유효시간이 남아있고(>now()) 전달받은 세션 id와 일치하는 사용자 정보를 꺼낸다.
        return session.selectOne(namespace+".checkUserWithSessionKey",sessionId);
	}
	
//	@Override
//	public UserVO checkUserWithSessionKey(String sessionId) {
//        // 유효시간이 남아있고(>now()) 전달받은 세션 id와 일치하는 사용자 정보를 꺼낸다.
//		UserVO userVO = null;
//		try {
//			userVO = jdbcTemplate.queryForObject("select * from member where sessionKey = ? and sessionLimit > now()", new BeanPropertyRowMapper<UserVO>(UserVO.class), sessionId);
//		} catch (DataAccessException e) {
//			e.printStackTrace();
//		}
//		return userVO;
//	}

	@Override
	public String findId(UserVO userVO) throws Exception {
		return session.selectOne(namespace+".findId", userVO);
	}

	@Override
	public void findPwd(UserVO userVO, String randomPwd) throws Exception {
	    Map<String, Object> map = new HashMap<>();
        map.put("userEmail", userVO.getUserEmail());
        map.put("userName", userVO.getUserName());
        map.put("userPassword", randomPwd);
		session.update(namespace+".findPwd", map);
	}
	
}
