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

public class MobileCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
BoardDAO bDao = BoardDAO.getBoardDAO();
		
		ArrayList<BoardDTO> mNewsList1 = bDao.newsListDAO(0, 7, "002", "mobile");
		ArrayList<BoardDTO> mNewsList2 = bDao.newsListDAO(1, 7, "002", "mobile");
		ArrayList<BoardDTO> mUserNewsList = bDao.newsTitleListDAO(0, 7, "006");
		ArrayList<BoardInfoDTO> mCategoryBoardList = bDao.categoryBoardListDAO("mobile");
		ArrayList<BoardDTO> mUserBoardList = bDao.titleListDAO(0,7,"0015");
		ArrayList<BoardInfoDTO> mRankList = bDao.boardRankingListDAO(0,6,"mobile");
		
		request.setAttribute("mNewsList1", mNewsList1);
		request.setAttribute("mNewsList2", mNewsList2);
		request.setAttribute("mUserNewsList", mUserNewsList);
		request.setAttribute("mCategoryBoardList", mCategoryBoardList);
		request.setAttribute("mUserBoardList", mUserBoardList);
		request.setAttribute("mRankList", mRankList);
	}	
}
