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

public class LoginOKCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO mDao = MemberDAO.getMemberDAO();
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String save = request.getParameter("saveID");
		String from = request.getParameter("from");
		MemberDTO mDto = mDao.loginDAO(id);
		
		if(save != null) {
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(60*60*24*365);
			response.addCookie(cookie);
		}
		else {
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
		}
		
		if(mDto.getId() == null) {
			request.setAttribute("msg", "존재하지 않는 아이디입니다.");
		} else if(!pw.equals(mDto.getPw())) {
			request.setAttribute("msg", "잘못된 비밀번호 입니다.");
		} else if(mDto.getBan_time() != null) {
			request.setAttribute("msg", mDto.getBan_time() + "까지 정지된 회원입니다." );
		} else {
			session.setMaxInactiveInterval(30*60);
			session.setAttribute("userInfo", mDto);
		}
			request.setAttribute("from", from);
	}	
}
