package com.spring.board.persistent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.board.domain.BoardVO;
import com.spring.board.domain.CategoryVO;
import com.spring.board.domain.ReportVO;

@Mapper
@Repository
public class BoardDAOImpl implements BoardDAO{

	@Autowired
	private SqlSession session;
	private static final String namespace = "com.spring.board";
	
	@Override
	public int maxbNum() throws Exception {
		return session.selectOne(namespace+".reRef");
	}
	
	@Override
	public void insert(BoardVO board) throws Exception {

		session.insert(namespace+".insert", board);	
	}

	@Override
	public void delete(int bNum) throws Exception {
		session.delete(namespace+".delete", bNum);	
	}

	@Override
	public void update(BoardVO board) throws Exception {
		session.update(namespace+".update", board);
	}

	@Override
	public void updateReadCount(int bNum) throws Exception {
		session.update(namespace+".updateReadCount", bNum);
	}

	@Override
	public List<BoardVO> list(Map<String, Object> info) throws Exception {
		return session.selectList(namespace+".list", info);
	}

	@Override
	public BoardVO select(int bNum) throws Exception {
		return session.selectOne(namespace+".select", bNum);
	}
	
	@Override
	public int getBoardCount(Map<String, Object> info) throws Exception {
		return session.selectOne(namespace+".allCount", info);
	}
	
	@Override
	public List<BoardVO> searchAll(Map<String, Object> search) throws Exception {
		return session.selectList(namespace+".searchAll", search);
	}
	
	@Override
	public List<BoardVO> searchTitle(Map<String, Object> search) throws Exception {
		return session.selectList(namespace+".searchTitle", search);
	}
	
	@Override
	public List<BoardVO> searchContent(Map<String, Object> search)
			throws Exception {
		return session.selectList(namespace+".searchContent", search);
	}
	
	@Override
	public List<BoardVO> searchWriter(Map<String, Object> search)
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
	public void seqUp(BoardVO boardVO) throws Exception {
		session.update(namespace+".seqUp", boardVO);
	}
	
	@Override
	public List<CategoryVO> getCategoryList(String bigCategory){
		
		List<CategoryVO> cList = new ArrayList<CategoryVO>();
		if(bigCategory.equals("3001") || bigCategory.equals("3002") || bigCategory.equals("3003")) {
			String[] categoryName = {"유저정보", "예판/핫딜 정보", "게임 심의결과", "게임 이야기", "질문 게시판", "스크린샷", "동영상", "게임 추천"};
			CategoryVO c1 = new CategoryVO();
			for(int i=0; i<categoryName.length; i++) {
				CategoryVO c = new CategoryVO();
				c.setCategoryName(categoryName[i]);
				c.setCategory(4000+i);
				cList.add(c);
			}
		}
		if(bigCategory.equals("3004") || bigCategory.equals("3005")) {
			String[] categoryName = {"유저정보", "예판/핫딜 정보", "게임 심의결과", "게임 이야기", "질문 게시판", "게임 추천", "스크린샷", "동영상"};
			CategoryVO c1 = new CategoryVO();
			for(int i=0; i<categoryName.length; i++) {
				CategoryVO c = new CategoryVO();
				c.setCategoryName(categoryName[i]);
				c.setCategory(5000+i);
				cList.add(c);
			}
		}
		
		if(bigCategory.equals("3006")) {
			String[] categoryName = {"PC정보", "예판/핫딜 정보", "게임 추천", "질문 게시판", "PC 업체 견적", "모니터", "노트북/데스크", "기타/주변기기", "소프트웨어"};
			CategoryVO c1 = new CategoryVO();
			for(int i=0; i<categoryName.length; i++) {
				CategoryVO c = new CategoryVO();
				c.setCategoryName(categoryName[i]);
				c.setCategory(6000+i);
				cList.add(c);
			}
		}
		
		
		if(bigCategory.equals("3007")) {
			String[] categoryName = {"모바일 게임 정보", "기타모바일 정보", "예판/핫딜 정보", "앱 추천/홍보", "질문 게시판", "게임 이야기", "스크린샷", "동영상", "iOS", "안드로이드", "윈도우", "피쳐폰", "MP3/PMP"};
			CategoryVO c1 = new CategoryVO();
			for(int i=0; i<categoryName.length; i++) {
				CategoryVO c = new CategoryVO();
				c.setCategoryName(categoryName[i]);
				c.setCategory(7000+i);
				cList.add(c);
			}
		}
		
		
		return cList;
	}
	
		@Override
		public Map<String, String> getBigCategoryMap() {
			Map<String, String> map = new HashMap<>();
			map.put("3001", "ps4");
			map.put("3002", "psvita");
			map.put("3003", "xbox");
			map.put("3004", "switch");
			map.put("3005", "3ds");
			map.put("3006", "pc");
			map.put("3007", "phone");
			return map;
		}
		


	@Override
	public void reportBoard(ReportVO reportVO) throws Exception {
		session.insert(namespace+".report", reportVO);
	}
	
	@Override
	public void recommendBoard(BoardVO board) throws Exception {
		session.insert(namespace+".recommend", board);
	}
	
	public int reportCheck(ReportVO reportVO) throws Exception {
		return session.selectOne(namespace+".reportCheck", reportVO);
	}
	public int recommendCheck(BoardVO board) throws Exception {
		return session.selectOne(namespace+".recommendCheck", board);
	}
	public void updateReport(BoardVO board) throws Exception {
		session.update(namespace+".updateReport", board);
	}
	public void updateRecommend(BoardVO board) throws Exception {
		session.update(namespace+".updateRecommend", board);
	}
	
	@Override
	public List<ReportVO> reportBoard(int startRow) throws Exception {
		return session.selectList(namespace+".reportboard",startRow);
	}
	
	@Override
	public void ok(int bNum) throws Exception {
		session.update(namespace+".ok", bNum);
	}
	
	@Override
	public ReportVO reportdetail(int bNum) throws Exception {
		return session.selectOne(namespace+".reportdetail", bNum);
	}
}
