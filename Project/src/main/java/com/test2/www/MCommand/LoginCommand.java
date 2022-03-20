package com.test2.www.MCommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test2.www.Command.Command;

public class LoginCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String save = request.getParameter("saveID");
		String id = request.getParameter("id");
		
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
	}
}
