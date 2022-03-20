package com.test2.www.MCommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test2.www.Command.Command;
import com.test2.www.DAO.MemberDAO;
import com.test2.www.DTO.MemberDTO;

public class MemberDeleteCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO mDao = MemberDAO.getMemberDAO();
		HttpSession session = request.getSession();
		MemberDTO userInfo = (MemberDTO)session.getAttribute("userInfo");
		mDao.DeleteMemberDAO(userInfo.getId());
		String from = request.getParameter("from");
		session.invalidate();
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
		    for(int i = 0 ; i < cookies.length; i++) {
		        if(cookies[i].getName().equals("id")) {
		            cookies[i].setMaxAge(0);
		            response.addCookie(cookies[i]);
		            break;
		        }
		    }
		}
		request.setAttribute("msg", "회원 탈퇴 되었습니다.");
		request.setAttribute("from", from);
	}	
}
