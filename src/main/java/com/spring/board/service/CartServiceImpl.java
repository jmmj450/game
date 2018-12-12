package com.spring.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.board.domain.CartVO;
import com.spring.board.persistent.CartDAO;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private CartDAO cartDao;
	
	// 1.장바구니 추가
	@Override
	public void insert(CartVO vo) throws Exception {
		cartDao.insert(vo);		
	}

	// 2.장바구니 목록
	@Override
	public List<CartVO> list(String userEmail) throws Exception {
		return cartDao.list(userEmail);
	}

	// 3.장바구니 삭제
	@Override
	public void delete(int cartNum) throws Exception {
		cartDao.delete(cartNum);		
	}

	// 4.장바구니 수량 수정
	@Override
	public void modify(CartVO vo) throws Exception {
		cartDao.modify(vo);		
	}

	// 5.장바구니 금액 합계
	@Override
	public int sumMoney(String userEmail) throws Exception {
		return cartDao.sumMoney(userEmail);
	}

	// 6.장바구니 동일한 상품 레코드 확인
	@Override
	public int count(int proNum, String userEmail) throws Exception {
		return cartDao.count(proNum, userEmail);
	}

	// 7.장바구니 동일한 상품이 존재하면 수정(수량+)
	@Override
	public void update(CartVO vo) throws Exception {
		cartDao.update(vo);
	}
	
	 // 8.결재하기 : 장바구니비우기
	@Override
	public void buy(String userEmail) throws Exception {
		cartDao.buy(userEmail);		
	}
}
