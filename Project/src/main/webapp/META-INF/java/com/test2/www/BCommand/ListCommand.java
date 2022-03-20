package com.test2.www.BCommand;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test2.www.DTO.BoardDTO;
import com.test2.www.DTO.BoardInfoDTO;
import com.test2.www.DTO.MemberDTO;
import com.test2.www.Command.Command;
import com.test2.www.DAO.BoardDAO;
import com.test2.www.DAO.MemberDAO;
import com.test2.www.DAO.ReplyDAO;

public class ListCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO bDao = BoardDAO.getBoardDAO();
		String board_code = request.getParameter("bCode");
		String article_category = request.getParameter("aCode");
		if(article_category == null) { article_category = "multi"; }
		ArrayList<BoardDTO> list = null;
		int page = 0, pageCnt = 0;
		int pageStart = 1, pageEnd = 0;
		int articleCnt = 0;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page")) - 1;
			pageStart = (((page+1)/10)*10)+1;
		}
		
		if(bDao.getBoardInfoDAO(board_code).getBoard_category2().equals("picutre")) {
			articleCnt = 9;
		} else {
			articleCnt = 10;
		}
		
		if(board_code.contains("002") && !article_category.equals("multi")) {
			list = bDao.newsListDAO(page, articleCnt,board_code, article_category);
			pageCnt = (bDao.newsListSize(board_code,article_category)%articleCnt < 1) ? bDao.newsListSize(board_code,article_category)/articleCnt : (bDao.newsListSize(board_code,article_category)/articleCnt) + 1;
		} else {
			list = bDao.listDAO(page,articleCnt,board_code);
			pageCnt = (bDao.listSize(board_code)%articleCnt < 1) ? bDao.listSize(board_code)/articleCnt : (bDao.listSize(board_code)/articleCnt) + 1;
		}		
		
		if(pageCnt == 0) { pageCnt = 1; }		
		if(pageStart+9 < pageCnt) { pageEnd = pageStart+9; } 
		else if(pageStart+9 >= pageCnt) { pageEnd = pageCnt; }
		
		BoardInfoDTO bIDto = bDao.getBoardInfoDAO(board_code);
		
		MemberDAO mDao = MemberDAO.getMemberDAO();
		MemberDTO mDto = mDao.getMember(bIDto.getAdmin_id());
		
		request.setAttribute("list", list);
		request.setAttribute("pageCnt", pageCnt);
		request.setAttribute("pageStart", pageStart);
		request.setAttribute("pageEnd", pageEnd);
		request.setAttribute("boardInfo", bIDto);
		request.setAttribute("admin_id", mDto.getId());
		request.setAttribute("aCode", article_category);
	}	
}
