package action.member;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import util.Action;
import vo.MemberVO;

public class JoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		MemberVO vo = new MemberVO();
		vo.setId(request.getParameter("id"));
		vo.setPwd(request.getParameter("pwd"));
		vo.setName(request.getParameter("name"));
		vo.setEmail(request.getParameter("email"));
		vo.setTel(request.getParameter("tel"));
		
		MemberDAO memberDAO = MemberDAO.getInstance();
		int result = memberDAO.join(vo);
		boolean checkJoin = false;
		if(result > 0) checkJoin = true;
		
		request.setAttribute("checkJoin", checkJoin);
		request.setAttribute("id", vo.getId());

	}

}
