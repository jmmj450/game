package com.spring.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.board.domain.LevelVO;
import com.spring.board.domain.PointVO;
import com.spring.board.domain.UserVO;
import com.spring.board.persistent.LevelDAO;
import com.spring.board.persistent.PointDAO;
import com.spring.board.service.UserService;

@Controller
public class AdminController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	PointDAO pointDAO;

	@Autowired
	LevelDAO levelDAO;
	
	@RequestMapping("/admin/userList")
	public String adminUserList(Model model, @RequestParam(defaultValue="1") int page) throws Exception {
		List<UserVO> list = userService.list(page);
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		return "/admin/userList";
	}	
		
	@RequestMapping("/admin/user/delete")
	public String adminUserDelete(@RequestParam int userID) throws Exception {
		userService.delete(userID);
		return "redirect:/admin/userList";
	}

	@RequestMapping("/admin/user/changeValidate")
	public String adminUserChangeValidate(@RequestParam int userID) throws Exception {
		userService.changeValidate(userID);
		return "redirect:/admin/userList";
	}
	
	@RequestMapping("/admin/pointList")
	public String adminPointList(Model model, @RequestParam(defaultValue="1") int page) throws Exception {
		List<PointVO> list = pointDAO.list(page);
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		return "/admin/pointList";
	}
	
	@RequestMapping("/admin/pointUpdate")
	public String adminPointUpdate(PointVO pointVO) throws Exception {
		pointDAO.update(pointVO);
		return "redirect:/admin/pointList";
	}
	
	@RequestMapping("/admin/levelList")
	public String adminLevelList(Model model, @RequestParam(defaultValue="1") int page) throws Exception {
		List<LevelVO> list = levelDAO.list(page);
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		return "/admin/levelList";
	}
	
	@RequestMapping("/admin/levelUpdate")
	public String adminLevelUpdate(LevelVO levelVO) throws Exception {
		levelDAO.update(levelVO);
		return "redirect:/admin/levelList";
	}
	
	@RequestMapping("/admin/levelDelete")
	public String adminLevelDelete(@RequestParam int no) throws Exception {
		levelDAO.delete(no);
		return "redirect:/admin/levelList";
	}
	
	@RequestMapping("/admin/levelWriteForm")
	public String adminLevelWriteForm() {
		return "/admin/levelWriteForm";
	}

	@RequestMapping("/admin/levelWrite")
	public String adminLevelWrite(LevelVO level) throws Exception {
		levelDAO.insert(level);
		return "redirect:/admin/levelList";
	}
}
