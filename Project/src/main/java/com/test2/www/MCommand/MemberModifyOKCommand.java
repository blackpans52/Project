package com.test2.www.MCommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test2.www.DAO.MemberDAO;
import com.test2.www.DTO.MemberDTO;
import com.test2.www.Command.Command;

public class MemberModifyOKCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO mDao = MemberDAO.getMemberDAO();
		HttpSession session = request.getSession();
		MemberDTO userInfo = (MemberDTO)session.getAttribute("userInfo");
		String id = userInfo.getId();
		MemberDTO mDto = new MemberDTO();
		mDto.setId(id);
		mDto.setNickname(request.getParameter("nickname"));
		mDto.setPw(request.getParameter("pw"));
		mDto.setEmail(request.getParameter("email"));
		mDto.setPostcode(request.getParameter("postcode"));
		mDto.setRoadAddress(request.getParameter("roadAddress"));
		mDto.setJibunAddress(request.getParameter("jibunAddress"));
		mDto.setDetailAddress(request.getParameter("detailAddress"));
		mDto.setExtraAddress(request.getParameter("extraAddress"));
		mDto.setTel(request.getParameter("tel"));
		System.out.println(request.getParameter("tel"));
		System.out.println(mDto.getTel());
		mDao.modifyDAO(mDto);
		session.invalidate();
		request.setAttribute("msg", "회원정보가 수정되었습니다. 다시 로그인 해주십시오");
		request.setAttribute("from", "http://localhost:8080/Project/index.jsp");
	}	
}
