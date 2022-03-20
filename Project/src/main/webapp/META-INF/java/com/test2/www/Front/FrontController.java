package com.test2.www.Front;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test2.www.Command.Command;
import com.test2.www.DTO.BoardInfoDTO;
import com.test2.www.BCommand.*;
import com.test2.www.CCommand.ArcadeCommand;
import com.test2.www.CCommand.CommunityCommand;
import com.test2.www.CCommand.MobileCommand;
import com.test2.www.CCommand.NewsCommand;
import com.test2.www.CCommand.NintendoCommand;
import com.test2.www.CCommand.PcCommand;
import com.test2.www.CCommand.PlaystationCommand;
import com.test2.www.CCommand.XboxCommand;
import com.test2.www.MCommand.*;
import com.test2.www.RCommand.DeleteReplyCommand;
import com.test2.www.RCommand.ModifyReplyCommand;
import com.test2.www.RCommand.NestedReplyCommand;
import com.test2.www.RCommand.ReplyCommand;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FrontController() {
        super();
    }
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String commandName = request.getServletPath();
		String view = null;
		Command command = null;
		boolean flag = false;
		
		if(commandName.contains("/index.do")) {
			view = "/index.jsp";
		} else if(commandName.contains("/Community.do")) {
			command = new CommunityCommand();
			command.execute(request, response);
			view = "/Community.jsp";
		} else if(commandName.contains("/News.do")) {
			command = new NewsCommand();
			command.execute(request, response);
			view = "/News.jsp";
		} else if(commandName.contains("/Playstation.do")) {
			command = new PlaystationCommand();
			command.execute(request, response);
			view = "/Playstation.jsp";
		} else if(commandName.contains("/Nintendo.do")) {
			command = new NintendoCommand();
			command.execute(request, response);
			view = "/Nintendo.jsp";
		} else if(commandName.contains("/Xbox.do")) {
			command = new XboxCommand();
			command.execute(request, response);
			view = "/Xbox.jsp";
		} else if(commandName.contains("/PC.do")) {
			command = new PcCommand();
			command.execute(request, response);
			view = "/PC.jsp";
		} else if(commandName.contains("/Mobile.do")) {
			command = new MobileCommand();
			command.execute(request, response);
			view = "/Mobile.jsp";
		} else if(commandName.contains("/Arcade.do")) {
			command = new ArcadeCommand();
			command.execute(request, response);
			view = "/Arcade.jsp";
		} 
		//////////////////////////////////////////////////////////////////////////////////////////////
		else if(commandName.contains("/login.do")) {
			view = "/login.jsp";
		} else if(commandName.contains("/loginOK.do")) {
			command = new LoginOKCommand();
			command.execute(request, response);
			view = "/loginLoading.jsp";
		} else if(commandName.contains("/logout.do")) {
			command = new LogoutCommand();
			command.execute(request, response);
			view = "/loginLoading.jsp";
		} else if(commandName.contains("/sign_up.do")) {
			view = "/Member/sign_up.jsp";
		} else if(commandName.contains("/sign_upOK.do")) {
			command = new SignUpCommand();
			command.execute(request, response);
			view = "/loginLoading.jsp";
		} else if(commandName.equals("/idCheck.do")) {
			view = "/Member/idCheck.jsp";
		} else if(commandName.equals("/idCheckOK.do")) {
			command = new IDCheckCommand();
			command.execute(request, response);
			view = "/Member/idCheck.jsp";
		} else if(commandName.equals("/nickCheck.do")) {
			view = "/Member/nickCheck.jsp";
		} else if(commandName.equals("/nickCheckOK.do")) {
			command = new NicknameCheckCommand();
			command.execute(request, response);
			view = "/Member/nickCheck.jsp";
		} else if(commandName.contains("/memberModify.do")) {
			command = new MemberModifyCommand();
			command.execute(request, response);
			view = "/Member/memberModify.jsp";
		} else if(commandName.contains("/memberModifyOK.do")) {
			command = new MemberModifyOKCommand();
			command.execute(request, response);
			view = "/loginLoading.jsp";
		} else if(commandName.equals("/memberDelete.do")) {
			command = new MemberDeleteCommand();
			command.execute(request, response);
			view = "/loginLoading.jsp";
		} else if(commandName.contains("/Membermanage.do")) {
			command = new MemberManageCommand();
			command.execute(request, response);
			view = "/Manage/Membermanage.jsp";
		} else if(commandName.equals("/memberAuthority.do")) {
			command = new AuthorityCommand();
			command.execute(request, response);
			view = "/Membermanage.do";
		} else if(commandName.equals("/memberBan.do")) {
			command = new BanCommand();
			command.execute(request, response);
			view = "/Membermanage.do";
		}
		////////////////////////////////////////////////////////////////////////
		else if(commandName.equals("/board.do")) {
			command = new ListCommand();
			command.execute(request, response);
			BoardInfoDTO bIDto = (BoardInfoDTO)request.getAttribute("boardInfo");
			if(bIDto.getBoard_category2().equals("picture")) {
				view = "Board/pictureBoard.jsp";
			} else if(bIDto.getBoard_code().contains("002")) {
				view = "Board/newsBoard.jsp";			
			} else {
				view = "Board/board.jsp";
			}
		} else if(commandName.contains("/best.do")) {
			command = new BestCommand();
			command.execute(request, response);
			view = "Board/bestBoard.jsp";
		} else if(commandName.contains("/bestSearch.do")) {
			command = new BestSearchCommand();
			command.execute(request, response);
			view = "Board/bestBoard.jsp";
		} else if(commandName.contains("/bestOn.do")) {
			command = new BestChoiceCommand();
			command.execute(request, response);
			view = "Board/viewLoading.jsp";
		} else if(commandName.contains("/bestOff.do")) {
			command = new BestOffCommand();
			command.execute(request, response);
			view = "Board/viewLoading.jsp";
		} else if(commandName.contains("/mainNewsOn.do")) {
			command = new MainNewsOnCommand();
			command.execute(request, response);
			view = "Board/viewLoading.jsp";
		} else if(commandName.contains("/mainNewsOff.do")) {
			command = new MainNewsOffCommand();
			command.execute(request, response);
			view = "Board/viewLoading.jsp";
		} else if(commandName.equals("/write.do")) {
			command = new WriteCommand();
			command.execute(request, response);
			BoardInfoDTO bIDto = (BoardInfoDTO)request.getAttribute("boardInfo");
			if(bIDto.getBoard_code().contains("002")) {
				view = "Board/newsWrite.jsp";
			} else {
				view = "Board/Swrite.jsp";
			}
		} else if(commandName.equals("/writeOK.do")) {
			command = new WriteOKCommand();
			command.execute(request, response);
			view = "Board/listLoading.jsp";
		} else if(commandName.equals("/view.do")) {
			command = new ViewCommand();
			command.execute(request, response);
			view = "Board/Sview.jsp";
		} else if(commandName.equals("/modify.do")) {
			command = new ModifyCommand();
			command.execute(request, response);
			BoardInfoDTO bIDto = (BoardInfoDTO)request.getAttribute("boardInfo");
			if(bIDto.getBoard_code().contains("002")) {
				view = "Board/newsModify.jsp";
			} else {
				view = "Board/Smodify.jsp";
			}
		} else if(commandName.equals("/modifyOK.do")) {
			command = new ModifyOKCommand();
			command.execute(request, response);
			view = "Board/viewLoading.jsp";
		} else if(commandName.equals("/delete.do")) {
			command = new DeleteCommand();
			command.execute(request, response);
			view = "Board/listLoading.jsp";
		}  else if(commandName.equals("/search.do")) {
			command = new SearchCommand();
			command.execute(request, response);
			BoardInfoDTO bIDto = (BoardInfoDTO)request.getAttribute("boardInfo");
			if(bIDto.getBoard_category2().equals("picture")) {
				view = "Board/pictureBoard.jsp";
			} else if(bIDto.getBoard_code().contains("002")){
				view = "Board/newsBoard.jsp";			
			} else {
				view = "Board/board.jsp";
			}
		} else if(commandName.equals("/reply.do")) {
			command = new ReplyCommand();
			command.execute(request, response);
			view = "Board/viewLoading.jsp";
		} else if(commandName.equals("/deleteReply.do")) {
			command = new DeleteReplyCommand();
			command.execute(request, response);
			view = "Board/viewLoading.jsp";
		} else if(commandName.equals("/nestedReply.do")) {
			command = new NestedReplyCommand();
			command.execute(request, response);
			view = "Board/viewLoading.jsp";
		} else if(commandName.equals("/modifyReply.do")) {
			command = new ModifyReplyCommand();
			command.execute(request, response);
			view = "Board/viewLoading.jsp";
		} else if(commandName.equals("/boardManage.do")) {
			command = new BoardListCommand();
			command.execute(request, response);
			view = "Manage/boardManage.jsp";
		} else if(commandName.equals("/createBoard.do")) {
			command = new CreateBoardCommand();
			command.execute(request, response);
			view = "boardManage.do";
			flag = true;
		} else if(commandName.equals("/deleteBoard.do")) {
			command = new DeleteBoardCommand();
			command.execute(request, response);
			view = "boardManage.do";
			flag = true;
		}
		////////////////////////////////////////////////////////////////////////
			command = new RealTimeBestCommand();
			command.execute(request, response);
		////////////////////////////////////////////////////////////////////////
		if(flag) { response.sendRedirect(view); } 
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

}
