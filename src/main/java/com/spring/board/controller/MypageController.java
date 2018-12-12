package com.spring.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.board.domain.PointHistoryVO;
import com.spring.board.persistent.PointHistoryDAO;

@Controller
public class MypageController {

	@Autowired
	private PointHistoryDAO pointHistoryDAO;
	
	@RequestMapping("/mypage/pointList")
	public String mypagePointList(Model model, @RequestParam(defaultValue="1") int page, HttpSession session) throws Exception{	
		String userEmail = (String) session.getAttribute("userEmail");
		
		Map<String, Object> map = new HashMap<>();
		map.put("userEmail", userEmail);
		map.put("startNum", (page-1)*15);
		
		List<PointHistoryVO> list = pointHistoryDAO.list(map);
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		return "/mypage/pointList";
	}
}
