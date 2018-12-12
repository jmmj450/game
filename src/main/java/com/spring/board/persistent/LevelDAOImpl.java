package com.spring.board.persistent;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.board.domain.LevelVO;

@Mapper
@Repository
public class LevelDAOImpl implements LevelDAO {
	
	@Autowired
	private SqlSession session;
	private static final String namespace = "com.spring.level";
	
	@Override
	public void insert(LevelVO level) throws Exception {
		session.insert(namespace+".insert", level);
	}
	
	@Override
	public void update(LevelVO level) throws Exception {
		session.update(namespace+".update", level);
	}

	@Override
	public void delete(int no) throws Exception {
		session.delete(namespace+".delete", no);
	}

	@Override
	public List<LevelVO> list(int page) throws Exception {
		return session.selectList(namespace+".list", (page-1)*5);
	}

	@Override
	public LevelVO select(int level) throws Exception {
		return session.selectOne(namespace+".select", level);
	}

	@Override
	public LevelVO selectMyLevel(int point) throws Exception {
		return session.selectOne(namespace+".selectMyLevel", point);
	}
	
}
