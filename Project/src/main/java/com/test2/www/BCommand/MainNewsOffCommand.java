package com.test2.www.BCommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test2.www.Command.Command;
import com.test2.www.DAO.BoardDAO;

public class MainNewsOffCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO bDao = BoardDAO.getBoardDAO();
		String no = request.getParameter("no");
		bDao.mainNewsSwitchDAO(no, false);
		request.setAttribute("msg", "메인 뉴스에서 해제되었습니다.");
		request.setAttribute("no", request.getParameter("no"));
	} 
}
