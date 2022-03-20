package com.test2.www.BCommand;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test2.www.DAO.BoardDAO;
import com.test2.www.DAO.ReplyDAO;
import com.test2.www.DTO.BoardDTO;
import com.test2.www.DTO.BoardInfoDTO;
import com.test2.www.DTO.ReplyDTO;
import com.test2.www.Command.Command;

public class ViewCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO bDao = BoardDAO.getBoardDAO();
		ReplyDAO rDao = ReplyDAO.getReplyDAO();
		String no = request.getParameter("no");
		BoardDTO bDto = bDao.viewDAO(no);
		bDto.setReplyCnt(rDao.replyCntDAO(Integer.parseInt(no)));		
		request.setAttribute("articleInfo", bDto);
		
		String SearchF = request.getParameter("searchF");
		request.setAttribute("searchF", SearchF);
		
		ArrayList<ReplyDTO> replyList = rDao.replyListDAO(no);
		request.setAttribute("replyList", replyList);
		
		BoardInfoDTO bIDto = bDao.getBoardInfoDAO(bDto.getBoard_code());
		request.setAttribute("boardInfo", bIDto);
	}
}
