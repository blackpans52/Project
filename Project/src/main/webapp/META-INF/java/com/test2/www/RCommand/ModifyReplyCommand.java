package com.test2.www.RCommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test2.www.Command.Command;
import com.test2.www.DAO.ReplyDAO;
import com.test2.www.DTO.ReplyDTO;

public class ModifyReplyCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReplyDAO rDao = ReplyDAO.getReplyDAO();
		ReplyDTO rDto = rDao.getReplyDTO(request.getParameter("no"));
		rDto.setReply_contents(request.getParameter("modify_reply_contents"));
		rDao.modifyReplyDAO(rDto);
		request.setAttribute("msg", "댓글이 수정되었습니다.");
		request.setAttribute("no", request.getParameter("viewno"));
	}
}
