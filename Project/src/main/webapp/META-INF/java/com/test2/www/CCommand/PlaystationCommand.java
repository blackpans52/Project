package com.test2.www.CCommand;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test2.www.Command.Command;
import com.test2.www.DAO.BoardDAO;
import com.test2.www.DTO.BoardDTO;
import com.test2.www.DTO.BoardInfoDTO;

public class PlaystationCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO bDao = BoardDAO.getBoardDAO();
		
		ArrayList<BoardDTO> pNewsList1 = bDao.newsListDAO(0, 7, "002", "playstation");
		ArrayList<BoardDTO> pNewsList2 = bDao.newsListDAO(1, 7, "002", "playstation");
		ArrayList<BoardDTO> pUserNewsList = bDao.newsListDAO(0, 7, "004", "playstation");
		ArrayList<BoardInfoDTO> pCategoryBoardList = bDao.categoryBoardListDAO("playstation");
		ArrayList<BoardDTO> pUserBoardList = bDao.titleListDAO(0,7,"0011");
		ArrayList<BoardInfoDTO> pRankList = bDao.boardRankingListDAO(0,6,"playstation");
		
		request.setAttribute("pNewsList1", pNewsList1);
		request.setAttribute("pNewsList2", pNewsList2);
		request.setAttribute("pUserNewsList", pUserNewsList);
		request.setAttribute("pCategoryBoardList", pCategoryBoardList);
		request.setAttribute("pUserBoardList", pUserBoardList);
		request.setAttribute("pRankList", pRankList);
		
	}
}
