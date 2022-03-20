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

public class NintendoCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO bDao = BoardDAO.getBoardDAO();
		
		ArrayList<BoardDTO> nNewsList1 = bDao.newsListDAO(0, 7, "002", "nintendo");
		ArrayList<BoardDTO> nNewsList2 = bDao.newsListDAO(1, 7, "002", "nintendo");
		ArrayList<BoardDTO> nUserNewsList = bDao.newsListDAO(0, 7, "004", "nintendo");
		ArrayList<BoardInfoDTO> nCategoryBoardList = bDao.categoryBoardListDAO("nintendo");
		ArrayList<BoardDTO> nUserBoardList = bDao.titleListDAO(0,7,"0012");
		ArrayList<BoardInfoDTO> nRankList = bDao.boardRankingListDAO(0,6,"nintendo");
		
		request.setAttribute("nNewsList1", nNewsList1);
		request.setAttribute("nNewsList2", nNewsList2);
		request.setAttribute("nUserNewsList", nUserNewsList);
		request.setAttribute("nCategoryBoardList", nCategoryBoardList);
		request.setAttribute("nUserBoardList", nUserBoardList);
		request.setAttribute("nRankList", nRankList);
	}
}
