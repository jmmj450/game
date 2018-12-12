package com.spring.board.persistent;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.board.domain.PointVO;

@Mapper
@Repository
public class PointDAOImpl implements PointDAO{

	@Autowired
	private SqlSession session;
	private static final String namespace = "com.spring.point";
	
	@Override
	public PointVO select(String itemType) throws Exception {
		return session.selectOne(namespace+".select", itemType);
	}

	@Override
	public void update(PointVO pointVO) throws Exception {
		session.update(namespace+".update", pointVO);
	}

	@Override
	public List<PointVO> list(int page) throws Exception {
		return session.selectList(namespace+".list", page);
	}
	
}
