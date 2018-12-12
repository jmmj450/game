package com.spring.board.persistent;

import java.util.List;

import com.spring.board.domain.LevelVO;

public interface LevelDAO {
	void insert(LevelVO level) throws Exception;
	void update(LevelVO level) throws Exception;
	void delete(int no) throws Exception;
	List<LevelVO> list(int page) throws Exception;
	LevelVO select(int level) throws Exception;
	LevelVO selectMyLevel(int point) throws Exception;
}
