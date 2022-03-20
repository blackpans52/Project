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

public class CommunityCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO bDao = BoardDAO.getBoardDAO();
		ArrayList<BoardDTO> freeList1 = bDao.titleListDAO(0,7,"001");
		ArrayList<BoardDTO> freeList2 = bDao.titleListDAO(1,7,"001");
		ArrayList<BoardDTO> pictureList = bDao.titleListDAO(0,10,"003");
		ArrayList<BoardDTO> bestList1 = bDao.bestListDAO(0, 7);
		ArrayList<BoardDTO> bestList2 = bDao.bestListDAO(1, 7);
		ArrayList<BoardInfoDTO> comCategoryBoardList = bDao.categoryBoardListDAO("community");
		
		request.setAttribute("freeList1", freeList1);
		request.setAttribute("freeList2", freeList2);		
		request.setAttribute("bestList1", bestList1);		
		request.setAttribute("bestList2", bestList2);		
		request.setAttribute("pictureList", pictureList);		
		request.setAttribute("comCategoryBoardList", comCategoryBoardList);
		
	}
}
