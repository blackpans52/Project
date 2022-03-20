package com.test2.www.CCommand;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test2.www.Command.Command;
import com.test2.www.DAO.BoardDAO;
import com.test2.www.DTO.BoardDTO;

public class ArcadeCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO bDao = BoardDAO.getBoardDAO();
		ArrayList<BoardDTO> arcadeList1 = bDao.titleListDAO(0,7,"015");
		ArrayList<BoardDTO> arcadeList2 = bDao.titleListDAO(0,7,"0151");
		ArrayList<BoardDTO> arcadeList3 = bDao.titleListDAO(0,7,"0152");
		ArrayList<BoardDTO> arcadeList4 = bDao.titleListDAO(0,7,"0153");
		ArrayList<BoardDTO> arcadeList5 = bDao.titleListDAO(0,7,"0154");
		
		request.setAttribute("arcadeList1", arcadeList1);
		request.setAttribute("arcadeList2", arcadeList2);
		request.setAttribute("arcadeList3", arcadeList3);
		request.setAttribute("arcadeList4", arcadeList4);
		request.setAttribute("arcadeList5", arcadeList5);
	}	
}
