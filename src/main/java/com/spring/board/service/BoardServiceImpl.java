package com.spring.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.board.domain.BoardVO;
import com.spring.board.domain.CategoryVO;
import com.spring.board.domain.ReportVO;
import com.spring.board.persistent.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDAO boardDAO;

	@Override
	public void insert(BoardVO board) throws Exception {
		board.setReRef(boardDAO.maxbNum()+1);
		boardDAO.insert(board);
	}

	@Override
	public void delete(int bNum) throws Exception {
		boardDAO.delete(bNum);
	}

	@Override
	public void update(BoardVO board) throws Exception {
		boardDAO.update(board);	
	}

	@Override
	public List<BoardVO> list(Map<String, Object> info) throws Exception {
		return boardDAO.list(info);
	}

	@Transactional
	@Override
	public BoardVO detailService(int bNum) throws Exception {
		boardDAO.updateReadCount(bNum);
		return boardDAO.select(bNum);
	}

	@Override
	public BoardVO select(int bNum) throws Exception {
		return boardDAO.select(bNum);
	}
	
	@Override
	public int getBoardCount(Map<String, Object> info) throws Exception {
		return boardDAO.getBoardCount(info);
	}
	
	@Override
	public List<BoardVO> searchAll(Map<String, Object> search) throws Exception {
		return boardDAO.searchAll(search);
	}
	
	@Override
	public List<BoardVO> searchTitle(Map<String, Object> search) throws Exception {
		return boardDAO.searchTitle(search);
	}
	
	@Override
	public List<BoardVO> searchContent(Map<String, Object> search) throws Exception {
		return boardDAO.searchContent(search);
	}
	
	@Override
	public List<BoardVO> searchWriter(Map<String, Object> search) throws Exception {
		return boardDAO.searchWriter(search);
	}
	
	@Override
	public int searchAllCount(Map<String, Object> search) throws Exception {
		return boardDAO.searchAllCount(search);
	}
	
	@Override
	public int searchTitleCount(Map<String, Object> search) throws Exception {
		return boardDAO.searchTitleCount(search);
	}
	
	@Override
	public int searchContentCount(Map<String, Object> search) throws Exception {
		return boardDAO.searchContentCount(search);
	}
	
	@Override
	public int searchWritertCount(Map<String, Object> search) throws Exception {
		return boardDAO.searchWritertCount(search);
	}
	
	public List<CategoryVO> getCategoryList(String bigCategory) {
		return boardDAO.getCategoryList(bigCategory);
	}
	
	@Override
	public void reinsert(BoardVO boardVO) throws Exception {
		boardDAO.seqUp(boardVO);
		boardVO.setReLev(boardVO.getReLev()+1);
		boardVO.setReSeq(boardVO.getReSeq()+1);
		
		boardDAO.insert(boardVO);
		
	}
	
	public Map<String, String> getBigCategoryMap() {
		return boardDAO.getBigCategoryMap();
	}
	
	@Override
	public List<ReportVO> reportBoard(int startRow) throws Exception {
		return boardDAO.reportBoard(startRow);
	}
	
	@Override
	public void ok(int bNum) throws Exception {
		boardDAO.ok(bNum);
	}
	
	@Override
	public ReportVO reportdetail(int bNum) throws Exception {
		return boardDAO.reportdetail(bNum);
	}
}
