package com.spring.board.controller;



import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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
	public String insert(@ModelAttribute ProductVO vo, HttpServletRequest request, @RequestParam(value="file") MultipartFile multipartFile) throws Exception{
		
		File file = null;
		String realPath = "";
		String filename = ""; // 파일명 초기화
		if (!multipartFile.isEmpty()) { // 파일 있으면(업로드 했으면)
			ServletContext application = request.getServletContext();
			realPath = application.getRealPath("/resources/editor/upload");
			
			filename = multipartFile.getOriginalFilename(); // 업로드한 파일명 가져오기
			// 엣지 브라우저 요청 파일이름 처리
			int index = filename.lastIndexOf("\\");
			filename = filename.substring(index + 1);
	        
	        file = new File(realPath, filename);
	        if (file.exists()) { // 해당 경로에 동일한 파일명이 이미 존재하는 경우
	        	// 파일명 앞에 업로드 시간 밀리초 붙여서 파일명 중복을 방지
	        	filename = System.currentTimeMillis() + "_" + filename;
	        	file = new File(realPath, filename);
	        }
	        
	        System.out.println("업로드 경로: " + realPath);
	        System.out.println("업로드 파일명: " + filename);
	        
	        // 업로드 수행
	        IOUtils.copy(multipartFile.getInputStream(), new FileOutputStream(file));
		} else {
			System.out.println("파일이 존재하지 않거나 파일크기가 0 입니다.");
		}
		
		vo.setProFile(filename);
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
	public String Update(@ModelAttribute ProductVO vo, HttpServletRequest request, @RequestParam(value="file") MultipartFile multipartFile) throws Exception{
		
		File file = null;
		String realPath = "";
		String filename = ""; // 파일명 초기화
		if (!multipartFile.isEmpty()) { // 파일 있으면(업로드 했으면)
			ServletContext application = request.getServletContext();
			realPath = application.getRealPath("/resources/editor/upload");
			
			filename = multipartFile.getOriginalFilename(); // 업로드한 파일명 가져오기
			// 엣지 브라우저 요청 파일이름 처리
			int index = filename.lastIndexOf("\\");
			filename = filename.substring(index + 1);
	        
	        file = new File(realPath, filename);
	        if (file.exists()) { // 해당 경로에 동일한 파일명이 이미 존재하는 경우
	        	// 파일명 앞에 업로드 시간 밀리초 붙여서 파일명 중복을 방지
	        	filename = System.currentTimeMillis() + "_" + filename;
	        	file = new File(realPath, filename);
	        }
	        
	        System.out.println("업로드 경로: " + realPath);
	        System.out.println("업로드 파일명: " + filename);
	        
	        // 업로드 수행
	        IOUtils.copy(multipartFile.getInputStream(), new FileOutputStream(file));
		} else {
			System.out.println("파일이 존재하지 않거나 파일크기가 0 입니다.");
		}
		
		productService.update(vo);
		return "redirect:/product/edit?proNum=" + vo.getProNum();
	}	
	
	@RequestMapping("/delete")
	public String Delete(@RequestParam int proNum) throws Exception{	
		productService.delete(proNum);
		return "redirect:/product/adminList";
	}	
	
}
