package com.test2.www.BCommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test2.www.DAO.BoardDAO;
import com.test2.www.DTO.BoardDTO;
import com.test2.www.Command.Command;

public class ModifyOKCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO bDao = BoardDAO.getBoardDAO();
		BoardDTO bDto = new BoardDTO();
		
		bDto.setNo(Integer.parseInt(request.getParameter("no")));
		bDto.setTitle(request.getParameter("title"));
		bDto.setContents(request.getParameter("contents"));
		bDto.setArticle_category(request.getParameter("article_category"));
		bDao.modifyDAO(bDto);		
		
		request.setAttribute("msg", "글이 수정되었습니다.");
		request.setAttribute("no", request.getParameter("no"));
	}
}
