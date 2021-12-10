package action.member;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import util.Action;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		MemberDAO memberDAO = MemberDAO.getInstance();
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		boolean result = memberDAO.login(id, pwd);
		request.setAttribute("result", result);
		if(result) {
			request.getSession().setAttribute("login", id);
			request.setAttribute("msg", "로그인에 성공했습니다");
			request.setAttribute("url", "/Surf/index.me");
		} else {
			request.setAttribute("msg", "로그인에 실패했습니다.");
		}

	}

}
