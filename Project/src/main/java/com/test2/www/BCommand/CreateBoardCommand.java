package com.test2.www.BCommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test2.www.Command.Command;
import com.test2.www.DAO.BoardDAO;
import com.test2.www.DTO.BoardInfoDTO;

public class CreateBoardCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO bDao = BoardDAO.getBoardDAO();
		BoardInfoDTO biDto = new BoardInfoDTO();
		biDto.setBoard_code(request.getParameter("board_code"));
		biDto.setBoard_name(request.getParameter("board_name"));	
		biDto.setAdmin_id(request.getParameter("admin_id"));
		String[] arrCategory = request.getParameterValues("board_category1[]");
		String category = String.join("|", arrCategory);
		biDto.setBoard_category1(category);
		biDto.setBoard_category2(request.getParameter("board_category2"));
		biDto.setAdmin_write(Boolean.parseBoolean(request.getParameter("admin_write")));
		bDao.createBoardDAO(biDto);
	}	
}
