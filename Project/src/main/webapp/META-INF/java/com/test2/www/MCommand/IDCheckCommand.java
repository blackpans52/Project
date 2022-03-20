package com.test2.www.MCommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test2.www.Command.Command;
import com.test2.www.DAO.MemberDAO;

public class IDCheckCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO mDao = MemberDAO.getMemberDAO();
		String id = request.getParameter("id");
		Boolean result = mDao.duplicateID(id);
		request.setAttribute("result", result);
		request.setAttribute("id", id);
	}
}
