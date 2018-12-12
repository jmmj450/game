package com.spring.board.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.board.domain.GBDetailVO;
import com.spring.board.domain.GBoardVO;
import com.spring.board.persistent.GBoardDAO;

@Service
public class GBoardServiceImpl implements GBoardService{

	@Autowired
	private GBoardDAO gBoardDAO;

	@Autowired
	private GBDetailService gbDetailService;
	
	@Override
	public void insert(GBoardVO gBoard, HttpServletRequest request,  GBDetailVO gbdetailVO) throws Exception {
		Integer maxNum = gBoardDAO.maxbNum();
		if (maxNum == null) {
			maxNum = 1;
		} else {
			maxNum = gBoardDAO.maxbNum() + 1;
		}
		System.out.println("year : " + gBoard.getYear());
		gBoard.setReRef(maxNum);
		gBoard.setReLev(0);
		gBoard.setReSeq(0);
		gBoard.setbReadCount(0);
		gBoardDAO.insert(gBoard);
		
		ServletContext application =  request.getSession().getServletContext();
		String realPath = application.getRealPath("/resources/editor/upload");
		   
        try {
            // csv 데이터 파일
            File csv = new File(realPath, gBoard.getFileName());
            System.out.println(csv);
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(csv), "UTF-8"));

           String line = "";
          
            //line = br.readLine();
            int idx = 0;
            while ((line = br.readLine()) != null) {
            	System.out.println(line);
            	
            	//if(idx==0) { br.readLine(); System.out.println(line);}
            	idx++;
            	System.out.println(line);
            	String[] str = line.split("\t", -1);
            	gbdetailVO.setbNum(gBoardDAO.maxbNum()); // 본글 번호 
            	if(str.length > 0) { System.out.println("dNum======== : " + str[0]); gbdetailVO.setdNum(str[0]); }
        		if(str.length > 1) { System.out.println("authNum======== : " + str[1]); gbdetailVO.setAuthNum(str[1]); }
        		if(str.length > 2) { System.out.println("gamename======== : " + str[2]); gbdetailVO.setGameName(str[2]); }
        		if(str.length > 3) { System.out.println("gamecompany======== : " + str[3]); gbdetailVO.setGameCompany(str[3]); }
        		if(str.length > 4) { System.out.println("applyDate======== : " + str[4]); gbdetailVO.setApplyDate(str[4]); }
        		if(str.length > 5) { System.out.println("decideDate======== : " + str[5]); gbdetailVO.setDecideDate(str[5]); }
        		if(str.length > 6) { System.out.println("decideGrade======== : " + str[6]); gbdetailVO.setDecideGrade(str[6]); }
        		if(str.length > 7) { System.out.println("receiptNumber======== : " + str[7]); gbdetailVO.setReceiptNumber(str[7]); }
        		if(str.length > 8) { System.out.println("agency======== : " + str[8]); gbdetailVO.setAgency(str[8]); }
     		       		
          		if (str.length < 2) {
        			continue;
        		}
          		
        		gbDetailService.insert(gbdetailVO);
  
//            	for (i=0; i<str.length; i++) {
//            		System.out.println("str["+i+"]" + str[i]);
//            	}
            }
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
		
		
		
		
	}

	@Override
	public void delete(int bNum) throws Exception {
		gBoardDAO.delete(bNum);
	}

	@Override
	public void update(GBoardVO gBoard) throws Exception {
		gBoardDAO.update(gBoard);	
	}

	@Override
	public List<GBoardVO> list(Map<String, Object> info) throws Exception {
		return gBoardDAO.list(info);
	}

	@Transactional
	@Override
	public GBoardVO detailService(int bNum) throws Exception {
		gBoardDAO.updateReadCount(bNum);
		return gBoardDAO.select(bNum);
	}

	@Override
	public GBoardVO select(int bNum) throws Exception {
		return gBoardDAO.select(bNum);
	}
	
	@Override
	public int getBoardCount(Map<String, Object> info) throws Exception {
		return gBoardDAO.getBoardCount(info);
	}
	
	@Override
	public List<GBoardVO> searchAll(Map<String, Object> search) throws Exception {
		return gBoardDAO.searchAll(search);
	}
	
	@Override
	public List<GBoardVO> searchTitle(Map<String, Object> search) throws Exception {
		return gBoardDAO.searchTitle(search);
	}
	
	@Override
	public List<GBoardVO> searchContent(Map<String, Object> search) throws Exception {
		return gBoardDAO.searchContent(search);
	}
	
	@Override
	public List<GBoardVO> searchWriter(Map<String, Object> search) throws Exception {
		return gBoardDAO.searchWriter(search);
	}
	
	@Override
	public int searchAllCount(Map<String, Object> search) throws Exception {
		return gBoardDAO.searchAllCount(search);
	}
	
	@Override
	public int searchTitleCount(Map<String, Object> search) throws Exception {
		return gBoardDAO.searchTitleCount(search);
	}
	
	@Override
	public int searchContentCount(Map<String, Object> search) throws Exception {
		return gBoardDAO.searchContentCount(search);
	}
	
	@Override
	public int searchWritertCount(Map<String, Object> search) throws Exception {
		return gBoardDAO.searchWritertCount(search);
	}
	
	@Override
	public void reinsert(GBoardVO gBoardVO) throws Exception {
		gBoardDAO.seqUp(gBoardVO);
		gBoardVO.setReLev(gBoardVO.getReLev()+1);
		gBoardVO.setReSeq(gBoardVO.getReSeq()+1);
		
		gBoardDAO.insert(gBoardVO);
		
	}
}
