package com.test2.www.BCommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test2.www.Command.Command;
import com.test2.www.DAO.BoardDAO;
import com.test2.www.DTO.BoardInfoDTO;

public class WriteCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String board_code = request.getParameter("bCode");
		BoardDAO bDao = BoardDAO.getBoardDAO();
		BoardInfoDTO bDto = bDao.getBoardInfoDAO(board_code);
		
		request.setAttribute("boardInfo", bDto);
	}
}
