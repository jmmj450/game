package com.spring.board.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.spring.board.domain.GBDetailVO;
import com.spring.board.domain.GBoardVO;

public interface GBoardService {
	void insert(GBoardVO gboard, HttpServletRequest request,  GBDetailVO gbdetailVO) throws Exception;
	void delete(int bNum) throws Exception;
	void update(GBoardVO gboard) throws Exception;
	List<GBoardVO> list(Map<String, Object>info) throws Exception;
	GBoardVO detailService(int bNum) throws Exception;
//	void updateReadCount(int bNum) throws Exception;
    GBoardVO select(int bNum) throws Exception;
    int getBoardCount(Map<String, Object> info) throws Exception;
    List<GBoardVO> searchAll(Map<String, Object> search) throws Exception;
    List<GBoardVO> searchTitle(Map<String, Object> search) throws Exception;
	List<GBoardVO> searchContent(Map<String, Object> search) throws Exception;
	List<GBoardVO> searchWriter(Map<String, Object> search) throws Exception;
	int searchAllCount(Map<String, Object> search) throws Exception;
	int searchTitleCount(Map<String, Object> search) throws Exception;
	int searchContentCount(Map<String, Object> search) throws Exception;
	int searchWritertCount(Map<String, Object> search) throws Exception;
//	void seqUp(GBoardVO GBoardVO) throws Exception;
	void reinsert(GBoardVO GBoardVO) throws Exception;
	
}
