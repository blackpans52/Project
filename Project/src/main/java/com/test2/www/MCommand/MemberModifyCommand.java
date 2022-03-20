package com.test2.www.MCommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test2.www.Command.Command;
import com.test2.www.DAO.MemberDAO;
import com.test2.www.DTO.MemberDTO;

public class MemberModifyCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO mDao = MemberDAO.getMemberDAO();
		HttpSession session = request.getSession();
		MemberDTO mDto = (MemberDTO)session.getAttribute("userInfo");
		String id = mDto.getId();
		MemberDTO userInfo = mDao.getMember(id);
		session.setAttribute("userInfo", userInfo);
	}
}
