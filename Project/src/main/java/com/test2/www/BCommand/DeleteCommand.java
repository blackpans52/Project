package com.test2.www.BCommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test2.www.DAO.BoardDAO;
import com.test2.www.Command.Command;

public class DeleteCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO bDao = BoardDAO.getBoardDAO();		
		String board_code = bDao.getBoardDTO(request.getParameter("no")).getBoard_code();
		bDao.deleteDAO(request.getParameter("no"));
		bDao.articleCnt(-1,board_code);
		request.setAttribute("msg", "글이 삭제되었습니다.");
		request.setAttribute("bCode", board_code);
	}
}
