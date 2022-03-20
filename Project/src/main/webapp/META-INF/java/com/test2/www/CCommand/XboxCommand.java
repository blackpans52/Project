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

public class XboxCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO bDao = BoardDAO.getBoardDAO();
		
		ArrayList<BoardDTO> xNewsList1 = bDao.newsListDAO(0, 7, "002", "xbox");
		ArrayList<BoardDTO> xNewsList2 = bDao.newsListDAO(1, 7, "002", "xbox");
		ArrayList<BoardDTO> xUserNewsList = bDao.newsListDAO(0, 7, "004", "xbox");
		ArrayList<BoardInfoDTO> xCategoryBoardList = bDao.categoryBoardListDAO("xbox");
		ArrayList<BoardDTO> xUserBoardList = bDao.titleListDAO(0,7,"0013");
		ArrayList<BoardInfoDTO> xRankList = bDao.boardRankingListDAO(0,6,"xbox");
		
		request.setAttribute("xNewsList1", xNewsList1);
		request.setAttribute("xNewsList2", xNewsList2);
		request.setAttribute("xUserNewsList", xUserNewsList);
		request.setAttribute("xCategoryBoardList", xCategoryBoardList);
		request.setAttribute("xUserBoardList", xUserBoardList);
		request.setAttribute("xRankList", xRankList);
	}
}
