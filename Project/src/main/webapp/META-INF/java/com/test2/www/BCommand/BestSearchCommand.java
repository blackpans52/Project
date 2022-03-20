package com.test2.www.BCommand;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test2.www.Command.Command;
import com.test2.www.DAO.BoardDAO;
import com.test2.www.DTO.BoardDTO;

public class BestSearchCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO bDao = BoardDAO.getBoardDAO();
		String where = "";
		String searchTag = (String)request.getParameter("searchTag");
		String search = (String)request.getParameter("search");
		
		if(searchTag.equals("title")) {
			where = "title LIKE '%" + search +"%'";
		} else if(searchTag.equals("title+contents")) {
			where = "title LIKE '%" + search +"%' or"
					+" contents LIKE '%" + search +"%'";
		} else if(searchTag.equals("nickname")) {
			where = "nickname LIKE '%" + search +"%'";
		}
		
		int page = 0, searchPageCnt = 0;		
		int pageStart = 1, pageEnd = 0;
		int articleCnt = 10;
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page")) - 1;
			pageStart = (((page+1)/10)*10)+1;
		}
		
		ArrayList<BoardDTO> list = bDao.bestSearchListDAO(where, page, articleCnt);
		searchPageCnt = (bDao.bestSearchListSize(where)/articleCnt < 1) ? bDao.bestSearchListSize(where)/articleCnt : (bDao.bestSearchListSize(where)/articleCnt) +1 ;
		if(searchPageCnt == 0) { searchPageCnt = 1; }
		
		if(pageStart+9 < searchPageCnt) { pageEnd = pageStart+9; } 
		else if(pageStart+9 >= searchPageCnt) { pageEnd = searchPageCnt; }
		
		request.setAttribute("list", list);
		request.setAttribute("searchTag", searchTag);
		request.setAttribute("search", search);
		request.setAttribute("searchPageCnt", searchPageCnt);
		request.setAttribute("pageStart", pageStart);
		request.setAttribute("pageEnd", pageEnd);
	}
}
