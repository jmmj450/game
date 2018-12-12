package com.spring.board.controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.board.domain.CartVO;
import com.spring.board.service.CartService;

@Controller
@RequestMapping("/cart")
public class CController {
	
	@Autowired
	CartService cartService;
	
//	@RequestMapping("cart")
//	public String cart(){
//		return "/product/cart_detail";
//	}
	
	// 1. 장바구니 추가
	@RequestMapping("insert")
	public String insert(@ModelAttribute CartVO vo, HttpSession session) throws Exception{
		String userEmail = (String) session.getAttribute("userEmail");
		vo.setUserEmail(userEmail);

		// 장바구니에 기존 상품이 있는지 검사
		int count = cartService.count(vo.getProNum(), userEmail);
//		count == 0 ? cartService.update(vo) : cartService.insert(vo);
		if(count == 0) { // 수량이 없으면 인서트
			cartService.insert(vo);
		} else {  // 수량이 있으면 업데이트
			cartService.update(vo);
		}
		return "redirect:list";
	}
	
	// 2. 장바구니목록
	@RequestMapping("/list")
	public ModelAndView list(HttpSession session, ModelAndView mav) throws Exception{
		String userEmail = (String) session.getAttribute("userEmail"); // 세션에 저장된 유저이메일
		Map<String, Object> map = new HashMap<String, Object>();
		List<CartVO> list =cartService.list(userEmail); // 장바구니 정보
		int sumMoney = cartService.sumMoney(userEmail);  // 장바구니 전체 금액
		// 장바구니 전체 금액에 따라 배송비 구분 : 10만원이상 무료, 미만 2500
		int fee = sumMoney >= 100000 ? 0 : 2500;
		map.put("list", list);				// 장바구니정보를 맵에저장
		map.put("count", list.size());		// 장바구니 상품의 유무
		map.put("sumMoney", sumMoney);		// 장바구니 전체 금앱
		map.put("fee", fee);				// 배송비		
		map.put("allSum", sumMoney+fee);	// 주문상품 전체 총합금액
		mav.setViewName("/product/cart_detail");			// view(jsp)페이지의 이름 저장
		mav.addObject("map", map);			// 맵변수 저장
		return mav;
	}
	

	
	// 3. 장바구니 삭제
	@RequestMapping("delete")
	public String delete(@RequestParam int cartNum) throws Exception{
		cartService.delete(cartNum);
		return "redirect:list";
	}
	
	// 4. 장바구니수정
	@RequestMapping("update")
	public String update(@RequestParam int[] amount, @RequestParam int[] proNum, HttpSession session) throws Exception{
		String userEmail = (String) session.getAttribute("userEmail"); // 세션아이디 가져오기
		for (int i=0; i<proNum.length; i++) {  // 레코드 수만큼 반복
			CartVO vo = new CartVO();
			vo.setUserEmail(userEmail);
			vo.setCartAmount(amount[i]);
			vo.setProNum(proNum[i]);
			cartService.modify(vo);
		}
		return "redirect:list";
	}
	
	// 5. 구매결정 
	@RequestMapping("buy")
	public String buy(HttpSession session) throws Exception{
		String userEmail = (String) session.getAttribute("userEmail"); // 세션아이디 가져오기
		System.out.println(userEmail);
		
		cartService.buy(userEmail);
		return "/product/buy";
	}
	
//	@RequestMapping("buy")
//	public String buy(){
//		return "product/buy";
//	}

}
