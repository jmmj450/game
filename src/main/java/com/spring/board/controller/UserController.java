package com.spring.board.controller;

import java.io.PrintWriter;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.board.domain.PointHistoryVO;
import com.spring.board.domain.UserVO;
import com.spring.board.persistent.PointDAO;
import com.spring.board.persistent.PointHistoryDAO;
import com.spring.board.service.UserService;
import com.spring.board.util.MyUtils;

@Controller
public class UserController {

//	@Autowired
//	private UserDAO userDAO;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PointHistoryDAO pointHistoryDAO;
	
	@Autowired
	private PointDAO pointDAO;
	
	@RequestMapping("/user/joinForm")
	public String userJoinForm(){
		return "/user/joinForm";
	}
	
	@RequestMapping("/user/join")
	public String userJoin(HttpSession session, UserVO userVO, @RequestParam String userAuthNum, HttpServletResponse response, PointHistoryVO pointHistoryVO) throws Exception{
		
		// 인증번호 체크
		String sessionRandomNum = (String) session.getAttribute("randomNum");
		
		// 세션의 난수값과 입력값 비교 인증
		if (!sessionRandomNum.equals(userAuthNum)) { // 실패시
			response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>");
            out.println("alert('인증번호틀림');");
            out.println("history.back();");
            out.println("</script>");
            out.close();
            return null;
		} 	
		
		userService.insertWithPoint(userVO, pointHistoryVO);
		
		return "redirect:/";
	}
	
	@RequestMapping("/user/updateForm")
	public String userUpdateForm(HttpSession session, Model model) throws Exception {
		UserVO userVO = userService.select((String)session.getAttribute("userEmail"));
		model.addAttribute("userVO", userVO);
		return "/user/updateForm";
	}	

	@RequestMapping(value="/user/update", method=RequestMethod.POST)
	public String userUpdate(UserVO userVO) throws Exception {
		userService.update(userVO);
		return "redirect:/mypage/pointList";
	}	

	@RequestMapping("/user/detail")
	public String userDetail(Model model, @RequestParam int userID) throws Exception {
		UserVO userVO = userService.selectByID(userID);
		model.addAttribute("userVO", userVO);
		return "/user/detail";
	}

	@RequestMapping("/user/deleteForm")
	public String userDeleteForm() throws Exception {
		return "/user/deleteForm";
	}
	
	@RequestMapping("/user/delete")
	public String userDelete(HttpSession session, HttpServletResponse response) throws Exception {
		String sessionUserEmail = (String)session.getAttribute("userEmail");
		UserVO userVO = userService.select(sessionUserEmail);
		userService.delete(userVO.getUserID());	
		
		response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<script>");
        out.println("alert('탈퇴되었습니다.');");
        out.println("location.href='/'");
        out.println("</script>");
        out.close();
        
		session.removeAttribute("userEmail");
        
        return null;
	}
	
	@RequestMapping("/user/loginForm")
	public String userLoginForm(){
		return "/user/loginForm";
	}
	
	@RequestMapping(value="/user/login", method=RequestMethod.POST)
	public String userLogin(HttpServletRequest request, HttpServletResponse response, UserVO userVO, Model model, PointHistoryVO pointHistoryVO, @RequestParam(defaultValue="no", required=false) String keepLogin) throws Exception{
		int result = userService.loginCheck(userVO);
		model.addAttribute("result", result);
		userVO = userService.select(userVO.getUserEmail());
		model.addAttribute("userVO", userVO);
		model.addAttribute("keepLogin", keepLogin);
		
		if(result == 1 && userVO.getUserValidate()==1){
			userService.loginWithPoint(userVO, pointHistoryVO);
			return "redirect:/board/list?bigcategory=3001&category=4000";
		}else{
			return "/user/loginForm";
		}
	}
	
	@RequestMapping("/user/logout")
	public String userLogout(HttpSession session, HttpServletRequest request, HttpServletResponse response){
		String userEmail = (String)session.getAttribute("userEmail");
		
		session.removeAttribute("userEmail");
		session.removeAttribute("userAdmin");
		
		//쿠키를 가져와보고
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("loginCookie")) {
		             // null이 아니면 존재하면!
		             cookie.setPath("/");
		             // 쿠키는 없앨 때 유효시간을 0으로 설정하는 것 !!! invalidate같은거 없음.
		             cookie.setMaxAge(0);
		             // 쿠키 설정을 적용한다.
		             response.addCookie(cookie);
		              
		             // 사용자 테이블에서도 유효기간을 현재시간으로 다시 세팅해줘야함.
		             Date date = new Date(System.currentTimeMillis());
		             userService.keepLogin(userEmail, session.getId(), date);
				}
			}
		}
		
		return "redirect:/";
	}
	
	@ResponseBody
	@RequestMapping(value="/user/sendAuthEmail", method=RequestMethod.POST)
	public String userSendAuthEmail(HttpSession session, @RequestBody String userEmailInfo){
		
		//1000 ~ 9999 중에 난수 구하기
		Integer randomNum = (int) (Math.random() * 9000) + 1000;
		
		// JSON 파서 준비
		JSONParser parser = new JSONParser(); 
		JSONObject jsonObject = null;
		try {
			jsonObject = (JSONObject) parser.parse(userEmailInfo);  // 파싱 수행
			System.out.println(jsonObject.get("userEmail"));
			System.out.println(jsonObject.get("userName"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		// 이메일 전송
		String result = MyUtils.simpleEmailSend(jsonObject.get("userEmail").toString(), jsonObject.get("userName").toString(), randomNum.toString()); // 메일발송
		if (!result.equals("fail")) { // 이메일 발송 성공
			session.setAttribute("randomNum", randomNum.toString());
			result = "success";
		} 
		
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/user/chkDupId")
	public Map<String, Integer> checkDuplicatId(@RequestParam String userEmail) {
		int count = userService.countById(userEmail);
		Map<String, Integer> map = new HashMap<>();
		map.put("count", count);

		return map;
	}
	
	@RequestMapping("/user/findIdForm")
	public String userFindIdForm(){
		return "/user/findIdForm";
	}
	
	@RequestMapping("/user/findId")
	public String userFindId(Model model, UserVO userVO) throws Exception {
		String userEmail = userService.findId(userVO);
		System.out.println(userEmail);
		model.addAttribute("userEmail", userEmail);
		return "/user/findId";
	}
	
	@RequestMapping("/user/findPwdForm")
	public String userFindPwdForm(){
		return "/user/findPwdForm";
	}
	
	
	@RequestMapping("/user/findPwd")
	public String userFindPwd(Model model, UserVO userVO, HttpServletRequest request, HttpServletResponse response, @RequestParam String userAuthNum) throws Exception {
		HttpSession session = request.getSession();
		
		// 인증번호 체크
		String sessionRandomNum = (String) session.getAttribute("randomNum");

		// 세션의 난수값과 입력값 비교 인증
		if (!sessionRandomNum.equals(userAuthNum)) { // 실패시
			response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>");
            out.println("alert('인증번호틀림');");
            out.println("history.back();");
            out.println("</script>");
            out.close();
            return null;
		} 	
		
		//100000 ~ 999999 중에 난수 구하기
		Integer randomPwd = (int) (Math.random() * 900000) + 100000;
		userService.findPwd(userVO, randomPwd.toString());
		
		System.out.println(randomPwd);
		model.addAttribute("userVO", userVO);
		model.addAttribute("randomPwd", randomPwd);
		
		return "/user/findPwd";
	}
	
	
	
	
}
