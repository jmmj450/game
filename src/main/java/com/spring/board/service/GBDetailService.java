package com.spring.board.service;

import java.util.List;
import java.util.Map;

import com.spring.board.domain.GBDetailVO;

public interface GBDetailService {
	void insert(GBDetailVO board) throws Exception;
	void delete(int bNum) throws Exception;
	void update(GBDetailVO board) throws Exception;
	List<GBDetailVO> list(int bNum) throws Exception;
	GBDetailVO detailService(int bNum) throws Exception;
//	void updateReadCount(int bNum) throws Exception;
	GBDetailVO select(int bNum) throws Exception;
    int getBoardCount(Map<String, Object> info) throws Exception;
    List<GBDetailVO> searchAll(Map<String, Object> search) throws Exception;
    List<GBDetailVO> searchTitle(Map<String, Object> search) throws Exception;
	List<GBDetailVO> searchContent(Map<String, Object> search) throws Exception;
	List<GBDetailVO> searchWriter(Map<String, Object> search) throws Exception;
	int searchAllCount(Map<String, Object> search) throws Exception;
	int searchTitleCount(Map<String, Object> search) throws Exception;
	int searchContentCount(Map<String, Object> search) throws Exception;
	int searchWritertCount(Map<String, Object> search) throws Exception;
//	void seqUp(BoardVO boardVO) throws Exception;
	//void reinsert(GBDetailVO boardVO) throws Exception;
	
}
