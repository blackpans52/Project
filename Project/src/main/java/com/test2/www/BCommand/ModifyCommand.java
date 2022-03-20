package com.test2.www.BCommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test2.www.Command.Command;
import com.test2.www.DAO.BoardDAO;
import com.test2.www.DTO.BoardDTO;
import com.test2.www.DTO.BoardInfoDTO;

public class ModifyCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO bDao = BoardDAO.getBoardDAO();
		String no = request.getParameter("no");
		BoardDTO bDto = bDao.getBoardDTO(no);
		BoardInfoDTO bIDto = bDao.getBoardInfoDAO(bDto.getBoard_code());
		request.setAttribute("articleInfo", bDto);
		request.setAttribute("boardInfo", bIDto);
	}
}
