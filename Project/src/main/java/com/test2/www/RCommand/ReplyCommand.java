package com.test2.www.RCommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test2.www.DAO.BoardDAO;
import com.test2.www.DAO.MemberDAO;
import com.test2.www.DAO.ReplyDAO;
import com.test2.www.DTO.BoardDTO;
import com.test2.www.DTO.MemberDTO;
import com.test2.www.DTO.ReplyDTO;
import com.test2.www.Command.Command;

public class ReplyCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDAO mDao = MemberDAO.getMemberDAO();
		ReplyDAO rDao = ReplyDAO.getReplyDAO();
		MemberDTO userInfo = (MemberDTO)session.getAttribute("userInfo");
		MemberDTO mDto = mDao.getMember(userInfo.getId());
		
		ReplyDTO rDto = new ReplyDTO();
		rDto.setId(mDto.getId());
		rDto.setNickname(mDto.getNickname());
		rDto.setReply_contents(request.getParameter("reply_contents"));
		rDto.setPost_num(Integer.parseInt(request.getParameter("no")));
		rDao.writeReplyDAO(rDto);
		request.setAttribute("msg", "댓글이 작성되었습니다.");
		request.setAttribute("no", request.getParameter("no"));
	}	
}
