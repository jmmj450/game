package com.spring.board.persistent;

import java.util.List;
import java.util.Map;

import com.spring.board.domain.PointHistoryVO;

public interface PointHistoryDAO {
	void insert(PointHistoryVO point) throws Exception;
	//List<PointHistoryVO> list(String userEmail) throws Exception;
	List<PointHistoryVO> list(Map<String, Object> map) throws Exception;
	void delete(int no) throws Exception;
}
