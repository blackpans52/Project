package com.test2.www.MCommand;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test2.www.Command.Command;
import com.test2.www.DAO.BoardDAO;
import com.test2.www.DAO.MemberDAO;
import com.test2.www.DTO.BoardInfoDTO;
import com.test2.www.DTO.MemberDTO;

public class MemberManageCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO mDao = MemberDAO.getMemberDAO();
		ArrayList<MemberDTO> list = mDao.memberListDAO();
		
		request.setAttribute("memberList", list);
		
		BoardDAO bDao = BoardDAO.getBoardDAO();
		ArrayList<BoardInfoDTO> boardList = bDao.boardListDAO();
		
		request.setAttribute("boardList", boardList);
		
	}
}
