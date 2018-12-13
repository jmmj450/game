package com.spring.board.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.spring.board.domain.GBDetailVO;
import com.spring.board.domain.GBoardVO;
import com.spring.board.domain.PagingVO;
import com.spring.board.persistent.GBDetailDAO;
import com.spring.board.persistent.UserDAO;
import com.spring.board.service.GBDetailService;
import com.spring.board.service.GBoardService;
import com.spring.board.util.MyUtils;

//Controller, Repository, Service, Component
@Controller
public class GBController {
	
	private PagingVO count(int page, int count){
		int pageSize = 15;
		
		int pageCount = count / pageSize + (count%pageSize == 0 ? 0 : 1);
		int pageBlock = 15;
		int startPage = ((page/pageBlock) - (page%pageBlock==0 ? 1: 0)) * pageBlock + 1;
		 int endPage = startPage + pageBlock - 1;
	        if (endPage > pageCount) {
	            endPage = pageCount;
	        }
	        PagingVO pagingVO = new PagingVO();
	        pagingVO.setCount(count);
	        pagingVO.setPage(page);
	        pagingVO.setPageCount(pageCount);
	        pagingVO.setPageBlock(pageBlock);
	        pagingVO.setStartPage(startPage);
	        pagingVO.setEndPage(endPage);
	        return pagingVO;
	}
	
	
	@Autowired
	private GBoardService gBoardService;

	@Autowired
	private GBDetailService gbDetailService;
	
	@Autowired
	private GBDetailDAO gbDetailDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	//dispatcher역활
	//http://localhost:8000/board/
//	@RequestMapping("/")
//	public String index(){
//		return "index";
//	}
	
	// ps4 게시판 
	@RequestMapping("/gboard/list")
	public String boardList(Model model, @RequestParam(defaultValue="1", required=false) int page, @ModelAttribute GBoardVO gBoardVO) throws Exception{
		Map<String, Object> info = new HashMap<String, Object>();
		int pageSize = 15;
		int startRow  = (page-1)*pageSize;
		
		info.put("page", startRow);
		info.put("year", gBoardVO.getbYear());
		info.put("month", gBoardVO.getbMonth());
		
		List<GBoardVO> list = gBoardService.list(info);
		int count = gBoardService.getBoardCount(info);
		
		int pageCount = count / pageSize + (count%pageSize == 0 ? 0 : 1);
		int pageBlock = 15;
		int startPage = ((page/pageBlock) - (page%pageBlock==0 ? 1: 0)) * pageBlock + 1;
		 int endPage = startPage + pageBlock - 1;
	        if (endPage > pageCount) {
	            endPage = pageCount;
	        }
	        
	        PagingVO pagingVO = new PagingVO();
	        pagingVO.setCount(count);
	        pagingVO.setPage(page);
	        pagingVO.setPageCount(pageCount);
	        pagingVO.setPageBlock(pageBlock);
	        pagingVO.setStartPage(startPage);
	        pagingVO.setEndPage(endPage);
		
	    System.out.println(gBoardVO.getbYear());    
	    System.out.println(gBoardVO.getbMonth()); 
	        
	    model.addAttribute("year", gBoardVO.getbYear());
	    model.addAttribute("month", gBoardVO.getbMonth());
		model.addAttribute("list", list);
		model.addAttribute("pagingVO", pagingVO);
		return "/gboard/ps4Userinfor";
	}// ps4 게시판 
	
	// 게시판  검색
	@RequestMapping("/gboard/search")
	public String boardSearch(@RequestParam String searchOption, @RequestParam String keyword,@ModelAttribute GBoardVO gBoardVO, Model model ,
			@RequestParam(defaultValue="1", required=false) int page) throws Exception {
		Map<String, Object> search = new HashMap<String, Object>();
		keyword = keyword.replaceAll("\\p{Z}", "");
		search.put("keyword", keyword);
		search.put("year", gBoardVO.getbYear());
		search.put("month", gBoardVO.getbMonth());

		int count = 0;
		List<GBoardVO> list;
		
		if(searchOption.equals("all")){
			
			list = gBoardService.searchAll(search);
			count = gBoardService.searchAllCount(search);
			PagingVO pagingVO = count(page, count);
			model.addAttribute("pagingVO", pagingVO);
			model.addAttribute("list", list);
			
		}else if(searchOption.equals("title")){
			
			list = gBoardService.searchTitle(search);
			count = gBoardService.searchTitleCount(search);
			PagingVO pagingVO = count(page, count);
			model.addAttribute("pagingVO", pagingVO);
			model.addAttribute("list", list);
			
		}else if(searchOption.equals("content")){
			
			list = gBoardService.searchContent(search);
			count = gBoardService.searchContentCount(search);
			PagingVO pagingVO = count(page, count);
			model.addAttribute("pagingVO", pagingVO);
			model.addAttribute("list", list);
			
		}else if(searchOption.equals("writer")){
			
			list = gBoardService.searchWriter(search);
			count = gBoardService.searchWritertCount(search);
			PagingVO pagingVO = count(page, count);
			model.addAttribute("pagingVO", pagingVO);
			model.addAttribute("list", list);
			
		}
		
		model.addAttribute("year", gBoardVO.getbYear());
		model.addAttribute("month", gBoardVO.getbMonth());
		return "/board/ps4UserinforSe";
	}
	// 게시판 검색 
	
	// ps4 게시판  글쓰기
	@RequestMapping("/gboard/writeForm")
	public String boardWriteForm(Model model, @RequestParam int page, HttpSession session) throws Exception{	
		String userEmail = (String) session.getAttribute("userEmail");
		if(userEmail != null){
			String userAdmin = (String)session.getAttribute("userAdmin");
			int admin = Integer.parseInt(userAdmin);
			model.addAttribute("admin", admin);
		}
		
		model.addAttribute("page", page);
		return "/gboard/userInforWrite";
	}// ps4 게시판  글쓰기

	//@RequestParam String bTitle
	@RequestMapping(value="/gboard/write", method= RequestMethod.POST)
	public String boardWrite(@ModelAttribute GBoardVO gBoardVO, HttpServletRequest request, @ModelAttribute GBDetailVO gbdetailVO, @RequestParam(value="file") MultipartFile multipartFile) throws Exception{
		System.out.println("gBoardVO.getbYear()rol: " + gBoardVO.getbYear());
		System.out.println("gBoardVO.getbMonth(): " + gBoardVO.getbMonth());
		
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
		
/*		ServletContext application =  request.getSession().getServletContext();
		String realPath = application.getRealPath("/resources/editor/upload");
		// System.out.println("realPath : " + realPath);
		int maxPostSize = 1024*1024*5; // 5MB
		
		MultipartRequest multi = new MultipartRequest(request, realPath, maxPostSize, "utf-8", new DefaultFileRenamePolicy());
		
		gBoardVO.setYear(multi.getParameter("year"));
		gBoardVO.setMonth(multi.getParameter("month"));
		gBoardVO.setPassword(multi.getParameter("password"));
		gBoardVO.setUserEmail(multi.getParameter("userEmail"));
		gBoardVO.setbTitle(multi.getParameter("bTitle"));
		gBoardVO.setbContent(multi.getParameter("bContent"));
		gBoardVO.setFileName(multi.getFilesystemName("filename"));*/
		// System.out.println(gBoardVO);
		
		gBoardVO.setFileName(filename); // 파일명
		String path = file.getPath(); // 전체경로
		System.out.println("gBoardVO.getFileName()" + gBoardVO.getFileName());
		
		gBoardService.insert(gBoardVO, path, gbdetailVO);
		return "redirect:/gboard/list?page=1&year="+gBoardVO.getbYear()+"&month="+gBoardVO.getbMonth();
	}
	
	@RequestMapping("/gboard/reWriteForm")
	public String boardreWriteForm(@RequestParam int bNum,Model model,@RequestParam int page)throws Exception{
		GBoardVO gBoardVO = gBoardService.select(bNum);
		model.addAttribute("reRef", gBoardVO.getReRef());
		model.addAttribute("reLev", gBoardVO.getReLev());
		model.addAttribute("reSeq", gBoardVO.getReSeq());
		model.addAttribute("year", gBoardVO.getbYear());
		model.addAttribute("month", gBoardVO.getbMonth());
		model.addAttribute("page", page);
		return "/gboard/reWrite";
	}
	
	@RequestMapping("/gboard/reWrite")
	public String boardreWrite(@ModelAttribute GBoardVO gBoardVO,Model model,@RequestParam int page)throws Exception{
		gBoardService.reinsert(gBoardVO);
		return "redirect:/gboard/board?page="+page+"&year="+gBoardVO.getbYear()+"&month="+gBoardVO.getbMonth();
	}

	
	@RequestMapping("/admin/gboard/delete")
	public String adminBoardDelete(@RequestParam int bNum, HttpSession session) throws Exception{	
		gBoardService.delete(bNum);
		gbDetailService.delete(bNum);
		//return "redirect:/gboard/list";
		return "redirect:/gboard/list";
	}
	
	@RequestMapping("/gboard/delete")
	public String boardDelete(@RequestParam int bNum) throws Exception{	
		gBoardService.delete(bNum);
		return "redirect:/gboard/list";
	}
	
	@RequestMapping("/gboard/detail")
	public String boardDetail(@ModelAttribute GBoardVO gBoardVO, Model model,HttpSession session,@RequestParam int page) throws Exception{	
	    //조회수 증가
		
		gBoardVO = gBoardService.detailService(gBoardVO.getbNum());
		List<GBDetailVO> list = gbDetailDAO.list(gBoardVO.getbNum());
		String result = MyUtils.getYoutubeMovie(gBoardVO.getbContent());
		gBoardVO.setbContent(result);
		
		model.addAttribute("page", page);
		model.addAttribute("gBoardVO", gBoardVO);
		model.addAttribute("list", list);
		return "/gboard/detail";
	}		
	
	@RequestMapping("/gboard/updateForm")
	public String boardUpdateForm (@ModelAttribute GBoardVO gBoardVO, Model model,@RequestParam int page) throws Exception{	
		gBoardVO = gBoardService.select(gBoardVO.getbNum());
		model.addAttribute("gBoardVO", gBoardVO);
		model.addAttribute("page", page);
		return "/gboard/updateForm";
	}	
	
	@RequestMapping(value="/gboard/update", method= RequestMethod.POST)
	public String boardUpdate(@ModelAttribute GBoardVO gBoardVO,@RequestParam int page) throws Exception{
		gBoardService.update(gBoardVO);
		
		return "redirect:/gboard/list?page="+page+"&year="+gBoardVO.getbYear()+"&category="+gBoardVO.getbMonth();
	}
	
	
}
