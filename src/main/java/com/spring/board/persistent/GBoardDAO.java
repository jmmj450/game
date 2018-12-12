package com.spring.board.persistent;

import java.util.List;
import java.util.Map;

import com.spring.board.domain.GBoardVO;

public interface GBoardDAO {
	void insert(GBoardVO gBoard) throws Exception;
	void delete(int bNum) throws Exception;
	void update(GBoardVO gBoard) throws Exception;
	void updateReadCount(int bNum) throws Exception;
	List<GBoardVO> list(Map<String, Object> info) throws Exception;
	GBoardVO select(int bNum) throws Exception;
	int getBoardCount(Map<String, Object> info) throws Exception;
	List<GBoardVO> searchAll(Map<String, Object> search) throws Exception;
	List<GBoardVO> searchTitle(Map<String, Object> search) throws Exception;
	List<GBoardVO> searchContent(Map<String, Object> search) throws Exception;
	List<GBoardVO> searchWriter(Map<String, Object> search) throws Exception;
	Integer maxbNum() throws Exception;
	void seqUp(GBoardVO gBoardVO) throws Exception;
	
	int searchAllCount(Map<String, Object> search) throws Exception;
	int searchTitleCount(Map<String, Object> search) throws Exception;
	int searchContentCount(Map<String, Object> search) throws Exception;
	int searchWritertCount(Map<String, Object> search) throws Exception;
}
