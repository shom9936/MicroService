package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.board.CommentWriteAction;
import action.board.DeleteAction;
import action.board.DownloadAction;
import action.board.ListAction;
import action.board.ModifyAction;
import action.board.GetBoardInfoAction;
import action.board.ViewAction;
import action.board.WriteAction;
import util.Action;
import util.ActionForward;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("*.brd")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Action action = null;
		ActionForward actionForward = null;

		String requestURL = request.getRequestURL().toString();
		System.out.println(requestURL);
		int lastIndex1 = requestURL.lastIndexOf("/");
		int lastIndex2 = requestURL.lastIndexOf(".brd");
		
		String path = requestURL.substring(lastIndex1 + 1,lastIndex2);
		
		switch(path) {
		case "list":
			action = new ListAction();
			actionForward = new ActionForward("/board/list.jsp", false);
			break;
		case "view":
			action = new ViewAction();
			actionForward = new ActionForward("/board/view.jsp", false);
			break;
		case "write" :
			actionForward = new ActionForward("/Surf/board/write.jsp", true);
			break;
		case "checkBoardWrite":
			action = new WriteAction();
			actionForward = new ActionForward("/board/result.jsp", false);
			break;
		case "fileDownload" :
			action = new DownloadAction();
			actionForward = new ActionForward("/board/view.brd", false);
			break;
		case "modifyForm":
			action = new GetBoardInfoAction();
			actionForward = new ActionForward("/board/modify.jsp", false);
			break;
		case "modify":
			action = new ModifyAction();
			actionForward = new ActionForward("/board/result.jsp", false);
			break;
		case "delete" :
			action = new DeleteAction();
			actionForward = new ActionForward("/board/result.jsp", false);
			break;
		case "commentWrite":
			action = new CommentWriteAction();
			actionForward = new ActionForward("/board/view.brd", false);
			break;
		
		}
		
		
		if(action != null) {
			action.execute(request, response);
		}
		
		if(actionForward.isRedirect()) {
			response.sendRedirect(actionForward.getNextPath());
		}else {
			request.getRequestDispatcher(actionForward.getNextPath()).forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
