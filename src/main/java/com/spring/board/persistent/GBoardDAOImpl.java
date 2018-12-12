package com.spring.board.persistent;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.board.domain.GBoardVO;

@Mapper
@Repository
public class GBoardDAOImpl implements GBoardDAO {

	@Autowired
	private SqlSession session;
	private static final String namespace = "com.spring.gboard";
	
	@Override
	public Integer maxbNum() throws Exception {
		return session.selectOne(namespace+".reRef");
	}
	
	@Override
	public void insert(GBoardVO gBoard) throws Exception {

		session.insert(namespace+".insert", gBoard);	
	}

	@Override
	public void delete(int bNum) throws Exception {
		session.delete(namespace+".delete", bNum);	
	}

	@Override
	public void update(GBoardVO gBoard) throws Exception {
		session.update(namespace+".update", gBoard);
	}

	@Override
	public void updateReadCount(int bNum) throws Exception {
		session.update(namespace+".updateReadCount", bNum);
	}

	@Override
	public List<GBoardVO> list(Map<String, Object> info) throws Exception {
		return session.selectList(namespace+".list", info);
	}

	@Override
	public GBoardVO select(int bNum) throws Exception {
		return session.selectOne(namespace+".select", bNum);
	}
	
	@Override
	public int getBoardCount(Map<String, Object> info) throws Exception {
		return session.selectOne(namespace+".allCount", info);
	}
	
	@Override
	public List<GBoardVO> searchAll(Map<String, Object> search) throws Exception {
		return session.selectList(namespace+".searchAll", search);
	}
	
	@Override
	public List<GBoardVO> searchTitle(Map<String, Object> search) throws Exception {
		return session.selectList(namespace+".searchTitle", search);
	}
	
	@Override
	public List<GBoardVO> searchContent(Map<String, Object> search)
			throws Exception {
		return session.selectList(namespace+".searchContent", search);
	}
	
	@Override
	public List<GBoardVO> searchWriter(Map<String, Object> search)
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
	public void seqUp(GBoardVO gBoardVO) throws Exception {
		session.update(namespace+".seqUp", gBoardVO);
	}
	
}
