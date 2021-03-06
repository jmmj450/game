package com.spring.board.service;

import java.util.List;
import java.util.Map;

import com.spring.board.domain.BoardVO;
import com.spring.board.domain.CategoryVO;
import com.spring.board.domain.ReportVO;

public interface BoardService {
	void insert(BoardVO board) throws Exception;
	void delete(int bNum) throws Exception;
	void update(BoardVO board) throws Exception;
	List<BoardVO> list(Map<String, Object>info) throws Exception;
	BoardVO detailService(int bNum) throws Exception;
//	void updateReadCount(int bNum) throws Exception;
    BoardVO select(int bNum) throws Exception;
    int getBoardCount(Map<String, Object> info) throws Exception;
    List<BoardVO> searchAll(Map<String, Object> search) throws Exception;
    List<BoardVO> searchTitle(Map<String, Object> search) throws Exception;
	List<BoardVO> searchContent(Map<String, Object> search) throws Exception;
	List<BoardVO> searchWriter(Map<String, Object> search) throws Exception;
	int searchAllCount(Map<String, Object> search) throws Exception;
	int searchTitleCount(Map<String, Object> search) throws Exception;
	int searchContentCount(Map<String, Object> search) throws Exception;
	int searchWritertCount(Map<String, Object> search) throws Exception;
	List<CategoryVO> getCategoryList(String bigCategory);
	//	void seqUp(BoardVO boardVO) throws Exception;
	void reinsert(BoardVO boardVO) throws Exception;
	Map<String, String> getBigCategoryMap();
	
	List<ReportVO> reportBoard(int startRow)throws Exception;
	void ok(int bNum) throws Exception;
	ReportVO reportdetail(int bNum) throws Exception;
	
	List<BoardVO> boardbest(BoardVO boardVO) throws Exception;
}
