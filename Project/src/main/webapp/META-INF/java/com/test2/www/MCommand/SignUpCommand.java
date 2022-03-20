package com.test2.www.MCommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test2.www.Command.Command;
import com.test2.www.DAO.MemberDAO;
import com.test2.www.DTO.MemberDTO;

public class SignUpCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO mDao = MemberDAO.getMemberDAO();
		MemberDTO mDto = new MemberDTO();
		mDto.setId(request.getParameter("id"));
		mDto.setNickname(request.getParameter("nickname"));
		mDto.setPw(request.getParameter("pw"));
		mDto.setEmail(request.getParameter("email"));
		mDto.setPostcode(Integer.parseInt(request.getParameter("postcode")));
		mDto.setRoadAddress(request.getParameter("roadAddress"));
		mDto.setJibunAddress(request.getParameter("jibunAddress"));
		mDto.setDetailAddress(request.getParameter("detailAddress"));
		mDto.setExtraAddress(request.getParameter("extraAddress"));
		mDto.setTel(request.getParameter("tel"));
		mDao.signUpDAO(mDto);
		request.setAttribute("msg", "회원가입이 완료되었습니다.");
	}
}
