package com.spring.board.persistent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.board.domain.CartVO;

@Mapper
@Repository
public class CartDAOImpl implements CartDAO{

	@Autowired
	private SqlSession session;
	private static final String namespace = "com.spring.cart";
	
	// 1. 장바구니 추가
	@Override
	public void insert(CartVO vo) throws Exception {
		session.insert(namespace+".insert", vo);	
	}

	// 2. 장바구니 목록
	@Override
	public List<CartVO> list(String userEmail) throws Exception {
		return session.selectList(namespace+".list", userEmail);
	}

	// 3. 장바구니 삭제
	@Override
	public void delete(int cartNum) throws Exception {
		session.delete(namespace+".delete", cartNum);
		
	}

	// 4.장바구니 수량 수정
	@Override
	public void modify(CartVO vo) throws Exception {
		session.update(namespace+".modify", vo);
		
	}

	// 5. 장바구니 금액 합계
	@Override
	public int sumMoney(String userEmail) throws Exception {
		return session.selectOne(namespace+".sumMoney", userEmail);
	}

	// 6. 장바구니 동일한 상품 레코드 확인
	@Override
	public int count(int proNum, String userEmail) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("proNum", proNum);
		map.put("userEmail", userEmail);
		return session.selectOne(namespace+".count", map);
	}

	// 7.장바구니 동일한 상품이 존재하면 수정(수량+)	
	@Override
	public void update(CartVO vo) throws Exception {
		session.update(namespace+".update", vo);
		
	}

	 // 8.결재하기 : 장바구니비우기
	@Override
	public void buy(String userEmail) throws Exception {
		session.delete(namespace+".buy", userEmail);
		
	}

}
