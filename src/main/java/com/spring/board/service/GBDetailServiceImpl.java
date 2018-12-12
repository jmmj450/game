package com.spring.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.board.domain.GBDetailVO;
import com.spring.board.persistent.GBDetailDAO;

@Service
public class GBDetailServiceImpl implements GBDetailService {

	@Autowired
	private GBDetailDAO gBDetailDAO;

	@Override
	public void insert(GBDetailVO board) throws Exception {
		//board.setReRef(gBDetailDAO.maxbNum()+1);
		gBDetailDAO.insert(board);
	}

	@Override
	public void delete(int bNum) throws Exception {
		gBDetailDAO.delete(bNum);
	}

	@Override
	public void update(GBDetailVO board) throws Exception {
		gBDetailDAO.update(board);	
	}

	@Override
	public List<GBDetailVO> list(int bNum) throws Exception {
		return gBDetailDAO.list(bNum);
	}

	@Transactional
	@Override
	public GBDetailVO detailService(int bNum) throws Exception {
		gBDetailDAO.updateReadCount(bNum);
		return gBDetailDAO.select(bNum);
	}

	@Override
	public GBDetailVO select(int bNum) throws Exception {
		return gBDetailDAO.select(bNum);
	}
	
	@Override
	public int getBoardCount(Map<String, Object> info) throws Exception {
		return gBDetailDAO.getBoardCount(info);
	}
	
	@Override
	public List<GBDetailVO> searchAll(Map<String, Object> search) throws Exception {
		return gBDetailDAO.searchAll(search);
	}
	
	@Override
	public List<GBDetailVO> searchTitle(Map<String, Object> search) throws Exception {
		return gBDetailDAO.searchTitle(search);
	}
	
	@Override
	public List<GBDetailVO> searchContent(Map<String, Object> search) throws Exception {
		return gBDetailDAO.searchContent(search);
	}
	
	@Override
	public List<GBDetailVO> searchWriter(Map<String, Object> search) throws Exception {
		return gBDetailDAO.searchWriter(search);
	}
	
	@Override
	public int searchAllCount(Map<String, Object> search) throws Exception {
		return gBDetailDAO.searchAllCount(search);
	}
	
	@Override
	public int searchTitleCount(Map<String, Object> search) throws Exception {
		return gBDetailDAO.searchTitleCount(search);
	}
	
	@Override
	public int searchContentCount(Map<String, Object> search) throws Exception {
		return gBDetailDAO.searchContentCount(search);
	}
	
	@Override
	public int searchWritertCount(Map<String, Object> search) throws Exception {
		return gBDetailDAO.searchWritertCount(search);
	}
	
//	@Override
//	public void reinsert(GBDetailVO GBDetailVO) throws Exception {
//		gBDetailDAO.seqUp(GBDetailVO);
//		GBDetailVO.setReLev(GBDetailVO.getReLev()+1);
//		GBDetailVO.setReSeq(GBDetailVO.getReSeq()+1);
//		
//		gBDetailDAO.insert(GBDetailVO);
//		
//	}
}
