package com.spring.board.persistent;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.board.domain.ProductVO;
import com.spring.board.domain.UserVO;

@Mapper
@Repository
public class ProductDAOImpl implements ProductDAO{

	@Autowired
	private SqlSession session;
	private static final String namespace = "com.spring.product";
	
	@Override
	public List<ProductVO> list() throws Exception { 	 // 상품 전체 목록
		return session.selectList(namespace+".list");
	}
	
	@Override
	public ProductVO detail(int proNum) throws Exception {   // 상품 상세보기
		return session.selectOne(namespace+".detail", proNum);	
	}
	
	@Override
	public String loginCheck(UserVO vo) throws Exception {  // 관리자 로그인 체크
		return session.selectOne(namespace+".loginCheck", vo);
	}

	@Override
	public void update(ProductVO vo) throws Exception {  // 상품 수정
		session.update(namespace+".update", vo);		
	}
	
	@Override
	public void delete(int proNum) throws Exception {  // 상품레코드 삭제
		session.delete(namespace+".delete", proNum);		
	}
	
	@Override
	public void insert(ProductVO vo) throws Exception {  // 상품 추가하기
		session.insert(namespace+".insert", vo);		
	}

	@Override
	public String fileInfo(int proNum) throws Exception {  // 삭제를 위한 상품 이미지 파일 가져오기
		return session.selectOne(namespace+".fileInfo", proNum);
	}
	
}
