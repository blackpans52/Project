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

public class PcCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO bDao = BoardDAO.getBoardDAO();
		
		ArrayList<BoardDTO> pcNewsList1 = bDao.newsListDAO(0, 7, "002", "pc");
		ArrayList<BoardDTO> pcNewsList2 = bDao.newsListDAO(1, 7, "002", "pc");
		ArrayList<BoardDTO> pcUserNewsList = bDao.newsTitleListDAO(0, 7, "005");
		ArrayList<BoardInfoDTO> pcCategoryBoardList = bDao.categoryBoardListDAO("pc");
		ArrayList<BoardDTO> pcUserBoardList = bDao.titleListDAO(0,7,"0014");
		ArrayList<BoardInfoDTO> pcRankList = bDao.boardRankingListDAO(0,6,"pc");
		
		request.setAttribute("pcNewsList1", pcNewsList1);
		request.setAttribute("pcNewsList2", pcNewsList2);
		request.setAttribute("pcUserNewsList", pcUserNewsList);
		request.setAttribute("pcCategoryBoardList", pcCategoryBoardList);
		request.setAttribute("pcUserBoardList", pcUserBoardList);
		request.setAttribute("pcRankList", pcRankList);
	}
}
