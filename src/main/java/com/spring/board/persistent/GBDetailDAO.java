package com.spring.board.persistent;

import java.util.List;
import java.util.Map;

import com.spring.board.domain.GBDetailVO;

public interface GBDetailDAO {
	void insert(GBDetailVO gbdetial) throws Exception;
	void delete(int bNum) throws Exception;
	void update(GBDetailVO gbdetial) throws Exception;
	void updateReadCount(int bNum) throws Exception;
	List<GBDetailVO> list(int bNum) throws Exception;
	GBDetailVO select(int bNum) throws Exception;
	int getBoardCount(Map<String, Object> info) throws Exception;
	List<GBDetailVO> searchAll(Map<String, Object> search) throws Exception;
	List<GBDetailVO> searchTitle(Map<String, Object> search) throws Exception;
	List<GBDetailVO> searchContent(Map<String, Object> search) throws Exception;
	List<GBDetailVO> searchWriter(Map<String, Object> search) throws Exception;
	int maxbNum() throws Exception;
	void seqUp(GBDetailVO gbdetial) throws Exception;
	
	int searchAllCount(Map<String, Object> search) throws Exception;
	int searchTitleCount(Map<String, Object> search) throws Exception;
	int searchContentCount(Map<String, Object> search) throws Exception;
	int searchWritertCount(Map<String, Object> search) throws Exception;
}
