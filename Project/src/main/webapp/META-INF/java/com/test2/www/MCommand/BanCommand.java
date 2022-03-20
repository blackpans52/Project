package com.test2.www.MCommand;

import java.io.IOException;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test2.www.Command.Command;
import com.test2.www.DAO.MemberDAO;
import com.test2.www.DTO.BanDTO;
import com.test2.www.DTO.MemberDTO;

public class BanCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if(request.getParameter("ban_time").equals("-1")) {
        	long MAX = (long) Integer.MAX_VALUE * 1000;
        	Date date = new Date(MAX);
        	cal.setTime(date);
        }
        else 
        	cal.add(Calendar.DATE, Integer.parseInt(request.getParameter("ban_time")));        
        	
        MemberDAO mDao = MemberDAO.getMemberDAO();
        BanDTO banDto = new BanDTO();
        MemberDTO mDto = mDao.getMember(request.getParameter("id"));
        banDto.setId(mDto.getId());
        banDto.setNickname(mDto.getNickname());
        banDto.setReason(request.getParameter("reason"));
        banDto.setBan_time(df.format(cal.getTime()));
        mDao.banMemberDAO(banDto);
	}
}
