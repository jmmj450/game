package com.spring.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.board.domain.LevelVO;
import com.spring.board.domain.PointHistoryVO;
import com.spring.board.domain.PointVO;
import com.spring.board.domain.ReplyVO;
import com.spring.board.domain.UserVO;
import com.spring.board.persistent.LevelDAO;
import com.spring.board.persistent.PointDAO;
import com.spring.board.persistent.PointHistoryDAO;
import com.spring.board.persistent.ReplyDAO;
import com.spring.board.persistent.UserDAO;

@Controller
public class RController {
	
	@Autowired
	private ReplyDAO replyDAO;
	
	@Autowired
	private PointDAO pointDAO;
	
	@Autowired
	private PointHistoryDAO pointHistoryDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private LevelDAO levelDAO;
	
	@RequestMapping(value="/reply/write", method=RequestMethod.POST)
	public @ResponseBody String replyWrite(@RequestBody ReplyVO reply,HttpSession session) 
	throws Exception{
		replyDAO.insert(reply);
		int rNum = replyDAO.selectMaxRnum();
		
			if(session.getAttribute("userEmail") != null){
				PointHistoryVO pointHistoryVO = new PointHistoryVO();
		
				// 포인트값 조회 후 포인트 히스토리 테이블에 저장
				PointVO pointVO = pointDAO.select("reple");
				pointHistoryVO.setUserEmail((String)session.getAttribute("userEmail"));
				pointHistoryVO.setItemType(pointVO.getItemType());
				pointHistoryVO.setPoint(pointVO.getPoint());
				pointHistoryDAO.insert(pointHistoryVO);

				// 회원정보
				UserVO userVO = userDAO.select((String)session.getAttribute("userEmail")); 
				
				// 포인트 추가
				int lastPoint = userVO.getUserPoint() + pointVO.getPoint();
				userVO.setUserPoint(lastPoint);
				
				// 자동등업처리
				LevelVO levelVO = levelDAO.selectMyLevel(lastPoint);
				userVO.setUserLevel(levelVO.getLevels());
			}
		return rNum+"";
	}
	
	@RequestMapping("/reply/delete")
	
	public String replyDelete(@RequestParam int rNum, 
			@RequestParam int bNum,
			RedirectAttributes redirect,@RequestParam int page,@RequestParam int bigcategory,@RequestParam int category) throws Exception{
		replyDAO.delete(rNum);
		redirect.addAttribute("bigcategory", bigcategory);
		redirect.addAttribute("category", category);
		redirect.addAttribute("bNum", bNum);
		redirect.addAttribute("page", page);
		return "redirect:/board/detail";
	}
	
	
	
	
	
	
}
