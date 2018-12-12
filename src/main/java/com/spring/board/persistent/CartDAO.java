package com.spring.board.persistent;

import java.util.List;

import com.spring.board.domain.CartVO;
import com.spring.board.domain.ProductVO;
import com.spring.board.domain.ReplyVO;

public interface CartDAO {
	
	void insert(CartVO vo) throws Exception; // 1.장바구니추가
	List<CartVO> list(String userEmail) throws Exception; //2. 장바구니 목록
	void delete(int cartNum) throws Exception; // 3.장바구니 삭제
	void modify(CartVO vo) throws Exception;// 4.장바구니 수량 수정
	int sumMoney(String userEmail) throws Exception;// 5.장바구니 금액 합계
	int count(int proNum, String userEmail) throws Exception;// 6.장바구니 동일한 상품 레코드 확인
	void update(CartVO vo) throws Exception;// 7.장바구니 동일한 상품이 존재하면 수정(수량+)
	void buy(String userEmail) throws Exception; // 8.결재하기 : 장바구니비우기
}
