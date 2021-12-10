package action.board;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import util.Action;
import vo.BoardVO;

public class GetBoardInfoAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO vo = dao.getBoardInfo(seq);
		
		request.setAttribute("boardVO", vo);
		
	}
}
