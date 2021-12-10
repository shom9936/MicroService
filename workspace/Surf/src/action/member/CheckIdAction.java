package action.member;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import util.Action;
import vo.MemberVO;

public class CheckIdAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		MemberDAO memberDAO = MemberDAO.getInstance();
		boolean check = memberDAO.checkID(id);
		
		if(check) {
			request.setAttribute("id", id);
			request.setAttribute("available", true);
		}
		
	}

}
