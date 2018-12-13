package com.spring.board.persistent;

import java.util.List;

import com.spring.board.domain.BoardVO;
import com.spring.board.domain.PointVO;

public interface PointDAO {
	void insert(PointVO pointVO) throws Exception;
	PointVO select(String itemType) throws Exception;
	void update(PointVO pointVO) throws Exception;
	List<PointVO> list(int page) throws Exception;
	int count() throws Exception;
}
