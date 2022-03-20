package com.test2.www.BCommand;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test2.www.Command.Command;
import com.test2.www.DAO.BoardDAO;
import com.test2.www.DTO.BoardDTO;


public class BestCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO bDao = BoardDAO.getBoardDAO();
		int page = 0, pageCnt = 0;
		int pageStart = 1, pageEnd = 0;
		int articleCnt = 10;
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page")) - 1;
			pageStart = (((page+1)/10)*10)+1;
		}
		
		ArrayList<BoardDTO> list = bDao.bestListDAO(page, articleCnt);
		
		pageCnt = (bDao.bestListSize()/articleCnt < 1) ? bDao.bestListSize()/articleCnt : (bDao.bestListSize()/articleCnt) + 1 ;
		if(pageCnt == 0) { pageCnt = 1; }
		
		if(pageStart+9 < pageCnt) { pageEnd = pageStart+9; } 
		else if(pageStart+9 >= pageCnt) { pageEnd = pageCnt; }
		
		request.setAttribute("list", list);
		request.setAttribute("pageCnt", pageCnt);
		request.setAttribute("pageStart", pageStart);
		request.setAttribute("pageEnd", pageEnd);
	}
}
