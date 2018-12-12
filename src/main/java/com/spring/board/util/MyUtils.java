package com.spring.board.util;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class MyUtils {
	public static String getYoutubeParse(String url){
		String result = "";
		String parsing = "";
		if(url.contains("=")){
			int index = url.indexOf("=");
			parsing = url.substring(index+1);
			System.out.println(parsing);
		}else{
			int index = url.lastIndexOf("/");
			parsing = url.substring(index+1);
			System.out.println(parsing);
		}
		
		result = result + parsing;
		System.out.println(result);
		return result;
	}
	
	public static String getYoutubeMovie(String bContent){
		//String data = "<p>영상 주소</p><p><a href=\"https://www.youtube.com/watch?v=uFJGdUeC2pk\">https://www.youtube.com/watch?v=uFJGdUeC2pk</a>&nbsp;</p>";
		String data = bContent;
		Document doc = Jsoup.parse(data);
		//System.out.println(doc);
		Elements a_tag = doc.select("a");
		int a_tagSize = a_tag.size();
		if(a_tagSize > 0){
			for(int i=0; i< a_tagSize; i++){
				if(a_tag.get(i).attr("href").contains("https://www.youtube.com") || a_tag.get(i).attr("href").contains("https://youtu.be")){
					//System.out.println("유투브 영상 링크가 존재합니다.");
					String href = a_tag.get(i).attr("href");
					String result = getYoutubeParse(href);
					String iFrame = "<iframe id=\"player\" type=\"text/html\" width=\"90%\" height=\"409\" src=\"http://www.youtube.com/embed/"+result+"\" frameborder=\"0\" webkitallowfullscreen=\"\" mozallowfullscreen=\"\" allowfullscreen=\"\"></iframe>";
					a_tag.get(i).after(iFrame);
				}
			}
		}
		//System.out.println(doc);
		return doc.toString();
	}
	
	public static String simpleEmailSend(String userEmail, String userName, String randomNum) {

		long beginTime = System.currentTimeMillis();
		
		// SimpleEmail 객체 생성
		SimpleEmail email = new SimpleEmail();
		// SMTP 서버 연결 설정
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthentication("miaewoo8@gmail.com", "bitc5600!");
		// SMTP 보안 SSL, TLS 설정
		email.setSSL(true);
		email.setTLS(true);
		
//		email.setSSLOnConnect(true);   // SSL 사용 설정
//		email.setStartTLSEnabled(true);  // TLS 사용 설정
		
		String result = "fail";
		try {
			// 보내는 사람 설정
			email.setFrom("miaewoo8@gmail.com", "관리자", "UTF-8");
			// 받는 사람 설정
			email.addTo(userEmail, userName, "UTF-8");
			// 받는 사람(참조인) 설정
			//email.addCc(email, name, charset);
			// 받는 사람(숨은참조인) 설정
			//email.addBcc(email, name, charset);
			
			// 제목 설정
			email.setSubject("인증키입니다.");
			// 본문 내용 준비
			StringBuilder sb = new StringBuilder();
			sb.append("authorization code : " + randomNum);
			// 본문 설정
			email.setMsg(sb.toString());
			// 메일 전송
			result = email.send();
		} catch (EmailException e) {
			e.printStackTrace();
		} finally {
			long execTime = System.currentTimeMillis() - beginTime ;
			System.out.println("execTime : " + execTime);
			System.out.println("result : " + result);
		}
		
		return result;		
		
	} 
	
	
	
	
}
