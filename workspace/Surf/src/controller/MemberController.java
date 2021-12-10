package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.member.CheckIdAction;
import action.member.DeleteMemberAction;
import action.member.GetInfoAction;
import action.member.JoinAction;
import action.member.LoginAction;
import action.member.LogoutAction;
import action.member.UpdateMemberAction;
import util.Action;
import util.ActionForward;

@WebServlet("*.me")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Action action = null;
		ActionForward actionForward = null;
		
		// http://localhost:8080/Surf/surf/surfSpot.me?area=4
		String requestURL = request.getRequestURL().toString();
		System.out.println(requestURL);
		int lastIndex1 = requestURL.lastIndexOf("/");
		int lastIndex2 = requestURL.lastIndexOf(".me");
		
		String path = requestURL.substring(lastIndex1 + 1,lastIndex2);
		
		switch(path) {
		case "index":
			actionForward = new ActionForward("/Surf/index.jsp", true); // true
			break;
		case "loginForm" :
			actionForward = new ActionForward("/Surf/login/loginForm.jsp", true);
			break;
		case "login":
			action = new LoginAction();
			actionForward = new ActionForward("/login/loginResult.jsp", false);
			break;
		case "joinForm" :
			actionForward = new ActionForward("/Surf/member/joinForm.jsp", true);
			break;
		case "checkID" :
			action = new CheckIdAction();
			actionForward = new ActionForward("/member/joinForm.jsp", false);
			break;
		case "join" :
			action = new JoinAction();
			actionForward = new ActionForward("/member/joinResult.jsp", false);
			break;
		case "logout" :
			action = new LogoutAction();
			actionForward = new ActionForward("/Surf/index.jsp", true);
			break;
		case "myPage" :
			action = new GetInfoAction();
			actionForward = new ActionForward("/member/page.jsp", false);
			break;
		case "deleteForm" :
			action = new GetInfoAction();
			actionForward = new ActionForward("/member/deleteForm.jsp", false);
			break;
		case "updateForm" :
			action = new GetInfoAction();
			actionForward = new ActionForward("/member/updateForm.jsp", false);
			break;
		case "delete" :
			action = new DeleteMemberAction();
			actionForward = new ActionForward("/Surf/member/deleteResult.jsp", true);
			break;
		case "update" :
			action = new UpdateMemberAction();
			actionForward = new ActionForward("/Surf/member/updateResult.jsp", true);
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

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
