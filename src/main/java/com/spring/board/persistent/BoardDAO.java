package com.spring.board.persistent;

import java.util.List;
import java.util.Map;

import com.spring.board.domain.BoardVO;
import com.spring.board.domain.CategoryVO;
import com.spring.board.domain.ReportVO;

public interface BoardDAO {
	void insert(BoardVO board) throws Exception;
	void delete(int bNum) throws Exception;
	void update(BoardVO board) throws Exception;
	void updateReadCount(int bNum) throws Exception;
	List<BoardVO> list(Map<String, Object> info) throws Exception;
	BoardVO select(int bNum) throws Exception;
	int getBoardCount(Map<String, Object> info) throws Exception;
	List<BoardVO> searchAll(Map<String, Object> search) throws Exception;
	List<BoardVO> searchTitle(Map<String, Object> search) throws Exception;
	List<BoardVO> searchContent(Map<String, Object> search) throws Exception;
	List<BoardVO> searchWriter(Map<String, Object> search) throws Exception;
	int maxbNum() throws Exception;
	void seqUp(BoardVO boardVO) throws Exception;
	
	int searchAllCount(Map<String, Object> search) throws Exception;
	int searchTitleCount(Map<String, Object> search) throws Exception;
	int searchContentCount(Map<String, Object> search) throws Exception;
	int searchWritertCount(Map<String, Object> search) throws Exception;

	List<CategoryVO> getCategoryList(String bigCategory);
	Map<String, String> getBigCategoryMap();
	
	void recommendBoard(BoardVO board) throws Exception;
	void reportBoard(ReportVO reportVO) throws Exception;
	
	
	int reportCheck(ReportVO reportVO) throws Exception;
	int recommendCheck(BoardVO board) throws Exception;
	void updateReport(BoardVO board) throws Exception;
	void updateRecommend(BoardVO board) throws Exception;
	
	List<ReportVO> reportBoard(int startRow) throws Exception;
	
	void ok(int bNum) throws Exception;
	
	ReportVO reportdetail(int bNum) throws Exception;
	
	

}
