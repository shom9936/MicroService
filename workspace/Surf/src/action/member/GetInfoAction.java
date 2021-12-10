package action.member;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import util.Action;
import vo.MemberVO;

public class GetInfoAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = (String) request.getSession().getAttribute("login");
		MemberVO vo = MemberDAO.getInstance().getInfo(id);
		request.setAttribute("vo", vo);

	}

}
