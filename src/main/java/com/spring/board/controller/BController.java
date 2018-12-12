package com.spring.board.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.board.domain.BoardVO;
import com.spring.board.domain.CategoryVO;
import com.spring.board.domain.ReplyVO;
import com.spring.board.domain.PagingVO;
import com.spring.board.domain.ReportVO;
import com.spring.board.persistent.BoardDAO;
import com.spring.board.persistent.ReplyDAO;
import com.spring.board.persistent.UserDAO;
import com.spring.board.service.BoardService;
import com.spring.board.util.MyUtils;

//Controller, Repository, Service, Component
@Controller
public class BController {
	
	private String category = "bigcategory=3001&category=4000";
	
	@Autowired
	BoardDAO boardDao;
	
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
	private BoardService boardService;
	
	@Autowired
	private ReplyDAO replyDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	//dispatcher역활
	//http://localhost:8000/board/
	@RequestMapping("/")
	public String index(){
		//return "index";
		return "redirect:/board/list?bigcategory=3001&category=4000";
	}
	
	// 게시판 
	@RequestMapping("/board/list")
	public String boardList(HttpSession session, Model model, @RequestParam(defaultValue="1", required=false) int page,BoardVO boardVO) throws Exception{
		Map<String, Object> info = new HashMap<String, Object>();
		int pageSize = 15;
		int startRow  = (page-1)*pageSize;
		
		int check = 0;
		if(session.getAttribute("userEmail") != null) {
			check = userDAO.userAdmin((String)session.getAttribute("userEmail"));
		}
		
		model.addAttribute("check", check);
		
		info.put("page", startRow);
		info.put("bigcategory", boardVO.getBigcategory());
		info.put("category", boardVO.getCategory());
		
		List<BoardVO> list = boardService.list(info);
		int count = boardService.getBoardCount(info);
		
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
		
	    model.addAttribute("bigcategory", boardVO.getBigcategory());
	    model.addAttribute("category", boardVO.getCategory());
		model.addAttribute("list", list);
		model.addAttribute("pagingVO", pagingVO);
		return "board/list";
	}// 게시판 
		
	
	// 게시판  검색
	@RequestMapping("/board/search")
	public String boardSearch(@RequestParam String searchOption, @RequestParam String keyword,BoardVO boardVO, Model model ,
			@RequestParam(defaultValue="1", required=false) int page, HttpSession session) throws Exception {
		Map<String, Object> search = new HashMap<String, Object>();
		keyword = keyword.replaceAll("\\p{Z}", "");
		int startRow  = (page-1)*15;
		search.put("keyword", keyword);
		search.put("bigcategory", boardVO.getBigcategory());
		search.put("category", boardVO.getCategory());
		search.put("page", startRow);

		int check = 0;
		if(session.getAttribute("userEmail") != null) {
			check = userDAO.userAdmin((String)session.getAttribute("userEmail"));
		}
		
		model.addAttribute("check", check);
		
		
		int count = 0;
		List<BoardVO> list;
		PagingVO pagingVO = null;
		
		if(searchOption.equals("all")){
			
			list = boardService.searchAll(search);
			count = boardService.searchAllCount(search);
			pagingVO = count(page, count);
			model.addAttribute("pagingVO", pagingVO);
			model.addAttribute("list", list);
			
			
		}else if(searchOption.equals("title")){
			
			list = boardService.searchTitle(search);
			count = boardService.searchTitleCount(search);
			pagingVO = count(page, count);
			model.addAttribute("pagingVO", pagingVO);
			model.addAttribute("list", list);
			
		}else if(searchOption.equals("content")){
			
			list = boardService.searchContent(search);
			count = boardService.searchContentCount(search);
			pagingVO = count(page, count);
			model.addAttribute("pagingVO", pagingVO);
			model.addAttribute("list", list);
			
		}else if(searchOption.equals("writer")){
			
			list = boardService.searchWriter(search);
			count = boardService.searchWritertCount(search);
			pagingVO = count(page, count);
			model.addAttribute("pagingVO", pagingVO);
			model.addAttribute("list", list);
			
		}
		model.addAttribute("seop", searchOption);
		model.addAttribute("keyword", keyword);
		model.addAttribute("bigcategory", boardVO.getBigcategory());
		model.addAttribute("category", boardVO.getCategory());
		return "board/serachList";
	}
	// 게시판 검색 
	
	// ps4 게시판  글쓰기
	@RequestMapping("/board/writeForm")
	public String boardWriteForm(Model	model,@RequestParam int page,@RequestParam String bigcategory,HttpSession session ) throws Exception{	
		List<CategoryVO> cList = boardService.getCategoryList(bigcategory);
		model.addAttribute("cList", cList);
		model.addAttribute("page", page);
		model.addAttribute("bigcategory", bigcategory);
		return "/board/writeForm";
	}// ps4 게시판  글쓰기
	
	@RequestMapping("/board/reWriteForm")
	public String boardreWriteForm(@RequestParam int bNum,Model model,@RequestParam int page)throws Exception{
		BoardVO boardVO = boardService.select(bNum);
		model.addAttribute("reRef", boardVO.getReRef());
		model.addAttribute("reLev", boardVO.getReLev());
		model.addAttribute("reSeq", boardVO.getReSeq());
		model.addAttribute("bigcategory", boardVO.getBigcategory());
		model.addAttribute("category", boardVO.getCategory());
		model.addAttribute("page", page);
		return "/board/reWrite";
	}
	
	@RequestMapping("/board/reWrite")
	public String boardreWrite(BoardVO boardVO,Model model,@RequestParam int page)throws Exception{
		
	
		
		boardService.reinsert(boardVO);
		
		return "redirect:/board/list?page="+page+"&bigcategory="+boardVO.getBigcategory()+"&category="+boardVO.getCategory();
	}
	
	
	
	
	//@RequestParam String bTitle
	@RequestMapping(value="/board/write", method= RequestMethod.POST)
	public String boardWrite(BoardVO boardVO) throws Exception{
		System.out.println(boardVO.getBigcategory());
		boardService.insert(boardVO);
		Map<String, String> map = boardService.getBigCategoryMap();
		String bigC = map.get(boardVO.getBigcategory());
		
		return "redirect:/board/list?page=1&bigcategory="+boardVO.getBigcategory()+"&category="+boardVO.getCategory();
	}
	
	@RequestMapping(value="/board/delete")
	public String boardDelete(@RequestParam int bNum, HttpSession session) throws Exception{	
		boardService.delete(bNum);
		return "redirect:/board/list?&"+category;
	}
	
	@RequestMapping(value="board/admin/board/delete", method= RequestMethod.POST)
	public String adminBoardDelete(HttpServletRequest request) throws Exception{	
	String[] bNum = request.getParameterValues("checkboxDelete");
		for(int i=0; i<bNum.length; i++) {
		int a = Integer.parseInt(bNum[i]);
		boardService.delete(a);
	}
		return "redirect:/board/list?&"+category;
	}
	
	@RequestMapping("/board/detail")
	public String boardDetail(BoardVO boardVO, Model model,HttpSession session,@RequestParam int page,HttpServletRequest request) throws Exception{	
			String u = request.getRequestURL().toString();
	   if(request.getQueryString() != null){
		   String uri = u+"?"+request.getQueryString();
		   model.addAttribute("uri", uri);
	   }else{
		   model.addAttribute("uri", u);
	   }
		
	   
		//조회수 증가
		
		boardVO = boardService.detailService(boardVO.getbNum());
		List<ReplyVO> list = replyDAO.list(boardVO.getbNum());
		String result = MyUtils.getYoutubeMovie(boardVO.getbContent());
		boardVO.setbContent(result);
		
		int check = 0;
		if(session.getAttribute("userEmail") != null) {
			check = userDAO.userAdmin((String)session.getAttribute("userEmail"));
		}
		
		model.addAttribute("check", check);
		
		boardVO.setbContent(result);
		model.addAttribute("page", page);
		model.addAttribute("boardVO", boardVO);
		model.addAttribute("list", list);
		return "/board/detail";
	}		
	
	@RequestMapping("/board/updateForm")
	public String boardUpdateForm
	(BoardVO boardVO, Model model,@RequestParam int page) throws Exception{	
		boardVO = boardService.select(boardVO.getbNum());
		model.addAttribute("boardVO", boardVO);
		model.addAttribute("page", page);
		return "/board/updateForm";
	}	
	
	@RequestMapping(value="/board/update", method= RequestMethod.POST)
	public String boardUpdate(BoardVO boardVO,@RequestParam int page) throws Exception{
		boardService.update(boardVO);
		
		return "redirect:/board/list?page="+page+"&bigcategory="+boardVO.getBigcategory()+"&category="+boardVO.getCategory();
	}
	
	@RequestMapping(value="/board/report", method=RequestMethod.POST)
	public String addReport(int bNum, HttpServletRequest request, HttpServletResponse response,@RequestParam String uri) throws Exception{
		HttpSession session = request.getSession();
		ReportVO b = new ReportVO();
		b.setUri(uri);
		b.setbNum(bNum);
		b.setUserEmail((String)session.getAttribute("userEmail"));
		b.setReport(1);
		b.setRecommend(0);
		b.setOk(0);
		BoardVO ob = boardService.select(bNum);
		b.setbTitle(ob.getbTitle());
		System.out.println(b.getbTitle());
		int or = ob.getReport();
		or = or + 1;
		ob.setReport(or);
		response.setContentType("text/html; charset=UTF-8");
		System.out.println(boardDao.reportCheck(b));
		PrintWriter out = response.getWriter();
		if(boardDao.reportCheck(b)>0) {
			out.println("<script>alert('이미 신고되었습니다.');history.back();</script>");
			out.close();
		} else {
			boardDao.reportBoard(b);
			boardDao.updateReport(ob);	
		}
		out.println("<script>alert('신고되었습니다.');history.back();</script>");
		out.close();
		return null;
	}
	
	@RequestMapping("/board/recommend")
	public String addRecommend(int bNum, HttpServletRequest request, HttpServletResponse response) throws Exception{
		HttpSession session = request.getSession();
		BoardVO b = new BoardVO();
		b.setbNum(bNum);
		b.setUserEmail((String)session.getAttribute("userEmail"));
		b.setReport(0);
		b.setRecommend(1);
		BoardVO ob = boardService.select(bNum);
		int or = ob.getRecommend();
		or = or + 1;
		ob.setRecommend(or);
		response.setContentType("text/html; charset=UTF-8");
		System.out.println(boardDao.recommendCheck(b));
		PrintWriter out = response.getWriter();
		if(boardDao.recommendCheck(b)>0) {
			out.println("<script>alert('이미 추천하였습니다.');history.back();</script>");
			out.close();
		} else {
			boardDao.recommendBoard(b);
			boardDao.updateRecommend(ob);
		}
		out.println("<script>alert('추천하였습니다.');history.back();</script>");
		out.close();
		return null;
	}
	
	@RequestMapping("/board/reportBoard")
	public String reportBoard(Model model,@RequestParam(defaultValue="1", required=false) int page) throws Exception{
		
		int pageSize = 15;
		int startRow  = (page-1)*pageSize;
		
		
		 List<ReportVO> list = boardService.reportBoard(startRow);
		 int count = list.size();
		 
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
		 
		        model.addAttribute("list", list);
				model.addAttribute("pagingVO", pagingVO);
		 return "board/reportBoard";
	}
	
	@RequestMapping("/board/reportDetail")
	public String reporydetail(@RequestParam int bNum,@RequestParam int page,Model model) throws Exception{
		ReportVO reportVO = boardService.reportdetail(bNum);
		if(reportVO.getOk() == 0){
			boardService.ok(bNum);
		}
		
		model.addAttribute("reportVO", reportVO);
		model.addAttribute("page", page);
		return "board/reportDetail";
	}
}
