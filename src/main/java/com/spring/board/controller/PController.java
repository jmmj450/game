package com.spring.board.controller;



import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.spring.board.domain.ProductVO;
import com.spring.board.persistent.ProductDAO;
import com.spring.board.service.ProductService;

@Controller
@RequestMapping("/product")
public class PController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping("/write")
	public String write(){
		return "/product/write";
	}
	
	@RequestMapping("/list")
	public ModelAndView list(ModelAndView mav) throws Exception{
		mav.setViewName("/product/p_list");
		mav.addObject("list", productService.list());
		return mav;
	}
	
	@RequestMapping("/adminList")
	public ModelAndView adminList(ModelAndView mav) throws Exception{
		mav.setViewName("/product/admin_list");
		mav.addObject("list", productService.list());
		return mav;
	}
	
	@RequestMapping("/detail")
	public String productDetail(@RequestParam int proNum, Model model) throws Exception{	
		ProductVO productVO = productService.detail(proNum);
		List<ProductVO> list = productDAO.list();
		model.addAttribute("vo", productVO);
		model.addAttribute("list", list);
		return "/product/p_detail";
	}	
	
	@RequestMapping("/insert")
	public String insert(@ModelAttribute ProductVO vo, HttpServletRequest request) throws Exception{
		
		ServletContext application =  request.getSession().getServletContext();
		String realPath = application.getRealPath("/resources/editor/upload");
		// System.out.println("realPath : " + realPath);
		int maxPostSize = 1024*1024*5; // 5MB
		
		MultipartRequest multi = new MultipartRequest(request, realPath, maxPostSize, "utf-8", new DefaultFileRenamePolicy());
		
		vo.setProName(multi.getParameter("proName"));
		vo.setProPrice(Integer.parseInt(multi.getParameter("proPrice")));
		vo.setProContent(multi.getParameter("proContent"));
		vo.setProFile(multi.getFilesystemName("filename"));
		// System.out.println(vo);
		
		productService.insert(vo);
		return "redirect:/product/adminList";
	}
	
	@RequestMapping("/edit")
	public String edit(@RequestParam int proNum, Model model) throws Exception{	
		ProductVO vo = productService.detail(proNum);
		model.addAttribute("vo", vo);
		return "/product/edit";
	}
	
	@RequestMapping("/update")
	public String Update(@ModelAttribute ProductVO vo, HttpServletRequest request) throws Exception{
		
		ServletContext application =  request.getSession().getServletContext();
		String realPath = application.getRealPath("/resources/editor/upload");
		// System.out.println("realPath : " + realPath);
		int maxPostSize = 1024*1024*5; // 5MB
		
		MultipartRequest multi = new MultipartRequest(request, realPath, maxPostSize, "utf-8", new DefaultFileRenamePolicy());
		
		vo.setProNum(Integer.parseInt(multi.getParameter("proNum")));
		vo.setProName(multi.getParameter("proName"));
		vo.setProPrice(Integer.parseInt(multi.getParameter("proPrice")));
		vo.setProContent(multi.getParameter("proContent"));
		
		System.out.println(multi.getFilesystemName("filename"));
		
		if(multi.getFilesystemName("filename")==null){
			vo.setProFile(multi.getOriginalFileName("filename"));
		}
		vo.setProFile(multi.getFilesystemName("filename"));

		System.out.println(vo);
		
		productService.update(vo);
		return "redirect:/product/edit?proNum=" + Integer.parseInt(multi.getParameter("proNum"));
	}	
	
	@RequestMapping("/delete")
	public String Delete(@RequestParam int proNum) throws Exception{	
		productService.delete(proNum);
		return "redirect:/product/adminList";
	}	
	
}
