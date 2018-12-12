package com.spring.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.board.domain.ProductVO;
import com.spring.board.domain.UserVO;
import com.spring.board.persistent.ProductDAO;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDAO productDAO;
	
	@Override 	//상품 전체 목록
	public List<ProductVO> list() throws Exception {
		return productDAO.list();
	}
	
	@Override // 상품 상세보기
	public ProductVO detail(int proNum) throws Exception {
		return productDAO.detail(proNum);
	}
	
	@Override   // 관리자 로그인 체크
	public String loginCheck(UserVO vo) throws Exception {
		return productDAO.loginCheck(vo);
	}
	
	@Override  // 상품수정
	public void update(ProductVO vo) throws Exception {
		productDAO.update(vo);	
	}

	@Override   //  상품 삭제
	public void delete(int proNum) throws Exception {
		productDAO.delete(proNum);
	}
	
	@Override  // 상품 추가
	public void insert(ProductVO vo) throws Exception {
		productDAO.insert(vo);
	}

	@Override
	public String fileInfo(int proNum) throws Exception {
		return productDAO.fileInfo(proNum);
	}
	
}
