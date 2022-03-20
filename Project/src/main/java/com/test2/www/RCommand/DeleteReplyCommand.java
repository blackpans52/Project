package com.test2.www.RCommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test2.www.Command.Command;
import com.test2.www.DAO.ReplyDAO;

public class DeleteReplyCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReplyDAO rDao = ReplyDAO.getReplyDAO();
		rDao.deleteReplyDAO(request.getParameter("no"));
		request.setAttribute("msg", "댓글이 삭제되었습니다.");
		request.setAttribute("no", request.getParameter("viewno"));		
	}
}
