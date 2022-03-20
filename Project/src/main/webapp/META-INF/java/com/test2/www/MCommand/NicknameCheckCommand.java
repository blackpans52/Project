package com.test2.www.MCommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test2.www.Command.Command;
import com.test2.www.DAO.MemberDAO;
import com.test2.www.DTO.MemberDTO;

public class NicknameCheckCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO mDao = MemberDAO.getMemberDAO();
		HttpSession session = request.getSession();
		MemberDTO userInfo = null;
		MemberDTO mDto = null;
		String nick = request.getParameter("nick");
		Boolean result = mDao.duplicateNick(nick);
		Boolean notModify = false;
		if(session.getAttribute("userInfo") != null) {
			userInfo = (MemberDTO)session.getAttribute("userInfo");
			mDto = mDao.getMember(userInfo.getId());
			if(mDto.getNickname().equals(nick)) {
				notModify = true;
			}		
		}
		request.setAttribute("result", result);
		request.setAttribute("nick", nick);
		request.setAttribute("notModify", notModify);
	}
}
