package action.member;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import util.Action;

public class DeleteMemberAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		MemberDAO dao = MemberDAO.getInstance();
		String id = (String) request.getSession().getAttribute("login");
		int result = dao.delete(id);
		
		request.getSession().invalidate();

	}

}
