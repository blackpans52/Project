package com.test2.www.RCommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test2.www.Command.Command;
import com.test2.www.DAO.MemberDAO;
import com.test2.www.DAO.ReplyDAO;
import com.test2.www.DTO.MemberDTO;
import com.test2.www.DTO.ReplyDTO;

public class NestedReplyCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();		
		MemberDAO mDao = MemberDAO.getMemberDAO();
		ReplyDAO rDao = ReplyDAO.getReplyDAO();
		MemberDTO userInfo = (MemberDTO)session.getAttribute("userInfo");
		MemberDTO mDto = mDao.getMember(userInfo.getId());
		
		ReplyDTO rDto = new ReplyDTO();
		ReplyDTO rDto2 = rDao.getReplyDTO(request.getParameter("no"));
		rDto.setId(mDto.getId());
		rDto.setNickname(mDto.getNickname());
		rDto.setReply_nick(rDto2.getNickname());
		rDto.setReply_contents(request.getParameter("nested_reply_contents"));
		rDto.setPost_num(Integer.parseInt(request.getParameter("viewno")));
		rDto.setGroupNum(rDto2.getGroupNum());
		rDto.setStepNum(rDto2.getStepNum());
		rDao.nestedReplyDAO(rDto);	
		request.setAttribute("msg", "댓글이 작성되었습니다.");
		request.setAttribute("no", request.getParameter("viewno"));
	}	
}
