package com.spring.board.persistent;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.board.domain.PointHistoryVO;

@Mapper
@Repository
public class PointHistoryDAOImpl implements PointHistoryDAO {

	@Autowired
	private SqlSession session;
	private static final String namespace = "com.spring.pointHistory";
	
	@Override
	public void insert(PointHistoryVO point) throws Exception {
		session.insert(namespace+".insert", point);
	}

//	@Override
//	public List<PointHistoryVO> list(String userEmail) throws Exception {
//		return session.selectList(namespace+".list", userEmail); // 맵 보내기
//	}
	@Override
	public List<PointHistoryVO> list(Map<String, Object> map) throws Exception {
		return session.selectList(namespace+".list", map); // 맵 보내기
	}	

	@Override
	public void delete(int no) throws Exception {
		session.delete(namespace+".delete", no);		
	}

}
