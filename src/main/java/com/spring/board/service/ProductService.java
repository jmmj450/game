package com.spring.board.service;

import java.util.List;

import com.spring.board.domain.BoardVO;
import com.spring.board.domain.ProductVO;
import com.spring.board.domain.UserVO;

public interface ProductService {
	List<ProductVO> list() throws Exception; //상품 전체 목록
	ProductVO detail(int proNum) throws Exception;   // 상품 상세보기
	String loginCheck(UserVO vo) throws Exception; // 관리자 로그인 체크
	void update(ProductVO vo) throws Exception;   // 상품 수정
	void delete(int proNum) throws Exception;  // 상품레코드 삭제
	void insert(ProductVO vo) throws Exception;  // 상품 추가하기
	String fileInfo(int proNum) throws Exception; // 삭제를 위한 상품 이미지 파일 가져오기
}



