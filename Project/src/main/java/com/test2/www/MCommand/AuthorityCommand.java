package com.test2.www.MCommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test2.www.Command.Command;
import com.test2.www.DAO.BoardDAO;
import com.test2.www.DAO.MemberDAO;
import com.test2.www.DTO.BoardInfoDTO;
import com.test2.www.DTO.MemberDTO;

public class AuthorityCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO bDao = BoardDAO.getBoardDAO();
		String bCode = request.getParameter("authority");
		BoardInfoDTO bIDto = bDao.getBoardInfoDAO(bCode);
		bIDto.setAdmin_id(request.getParameter("admin_id"));
		bDao.boardAuthorityDAO(bIDto);
		
		MemberDAO mDao = MemberDAO.getMemberDAO();
		MemberDTO mDto = new MemberDTO();
		mDto.setId(request.getParameter("admin_id"));
		mDao.memberAuthorityDAO(mDto);
	}
}
