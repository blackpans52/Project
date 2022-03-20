package com.test2.www.CCommand;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test2.www.Command.Command;
import com.test2.www.DAO.BoardDAO;
import com.test2.www.DTO.BoardDTO;

public class NewsCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO bDao = BoardDAO.getBoardDAO();
		ArrayList<BoardDTO> mainNews1 = bDao.MainNewsListDAO(0, 1, "002");
		ArrayList<BoardDTO> mainNewsList = bDao.MainNewsListDAO(0, 6, "002");
		ArrayList<BoardDTO> newsList1 = bDao.newsTitleListDAO(0,7,"002");
		ArrayList<BoardDTO> newsList2 = bDao.newsTitleListDAO(1,7,"002");
		ArrayList<BoardDTO> consoleList1 = bDao.newsTitleListDAO(0,7,"004");
		ArrayList<BoardDTO> reviewList1 = bDao.newsTitleListDAO(0,7,"0021");
		ArrayList<BoardDTO> pcList = bDao.titleListDAO(0, 7, "005");
		ArrayList<BoardDTO> mobileList = bDao.titleListDAO(0, 7, "006");
		
		request.setAttribute("mainNews1", mainNews1);
		request.setAttribute("mainNewsList", mainNewsList);
		request.setAttribute("newsList1", newsList1);
		request.setAttribute("newsList2", newsList2);
		request.setAttribute("consoleList1", consoleList1);
		request.setAttribute("reviewList1", reviewList1);
		request.setAttribute("pcList", pcList);
		request.setAttribute("mobileList", mobileList);
	}	
}
