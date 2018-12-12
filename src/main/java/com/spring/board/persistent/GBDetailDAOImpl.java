package com.spring.board.persistent;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.board.domain.GBDetailVO;

@Mapper
@Repository
public class GBDetailDAOImpl implements GBDetailDAO {

	@Autowired
	private SqlSession session;
	private static final String namespace = "com.spring.gbdetail";
	
	@Override
	public int maxbNum() throws Exception {
		return session.selectOne(namespace+".reRef");
	}
	
	@Override
	public void insert(GBDetailVO gbdetail) throws Exception {

		session.insert(namespace+".insert", gbdetail);	
	}

	@Override
	public void delete(int bNum) throws Exception {
		session.delete(namespace+".delete", bNum);	
	}

	@Override
	public void update(GBDetailVO gbdetail) throws Exception {
		session.update(namespace+".update", gbdetail);
	}

	@Override
	public void updateReadCount(int bNum) throws Exception {
		session.update(namespace+".updateReadCount", bNum);
	}

	@Override
	public List<GBDetailVO> list(int bNum) throws Exception {
		return session.selectList(namespace+".list", bNum);
	}

	@Override
	public GBDetailVO select(int bNum) throws Exception {
		return session.selectOne(namespace+".select", bNum);
	}
	
	@Override
	public int getBoardCount(Map<String, Object> info) throws Exception {
		return session.selectOne(namespace+".allCount", info);
	}
	
	@Override
	public List<GBDetailVO> searchAll(Map<String, Object> search) throws Exception {
		return session.selectList(namespace+".searchAll", search);
	}
	
	@Override
	public List<GBDetailVO> searchTitle(Map<String, Object> search) throws Exception {
		return session.selectList(namespace+".searchTitle", search);
	}
	
	@Override
	public List<GBDetailVO> searchContent(Map<String, Object> search)
			throws Exception {
		return session.selectList(namespace+".searchContent", search);
	}
	
	@Override
	public List<GBDetailVO> searchWriter(Map<String, Object> search)
			throws Exception {
		return session.selectList(namespace+".searchWritert", search);
	}
	
	@Override
	public int searchAllCount(Map<String, Object> search) throws Exception {
		return session.selectOne(namespace+".searchAllCount", search);
	}
	
	@Override
	public int searchTitleCount(Map<String, Object> search) throws Exception {
		return session.selectOne(namespace+".searchTitleCount", search);
	}
	
	@Override
	public int searchContentCount(Map<String, Object> search) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".searchContentCount", search);
	}
	
	@Override
	public int searchWritertCount(Map<String, Object> search) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".searchWritertCount", search);
	}
	
	@Override
	public void seqUp(GBDetailVO gbdetail) throws Exception {
		session.update(namespace+".seqUp", gbdetail);
	}
	
}
