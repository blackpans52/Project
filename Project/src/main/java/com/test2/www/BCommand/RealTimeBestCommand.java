package com.test2.www.BCommand;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test2.www.Command.Command;
import com.test2.www.DAO.BoardDAO;
import com.test2.www.DTO.BoardDTO;
import com.test2.www.DTO.BoardInfoDTO;

public class RealTimeBestCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO bDao = BoardDAO.getBoardDAO();
		ArrayList<BoardDTO> realList = bDao.realTimeBestListDAO();
		ArrayList<BoardInfoDTO> allRankList = bDao.allRankingListDAO(0, 7);
		request.setAttribute("realList", realList);
		request.setAttribute("allRankList", allRankList);
	}
}
