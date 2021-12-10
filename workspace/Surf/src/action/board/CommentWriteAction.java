package action.board;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import util.Action;
import vo.CommentVO;

public class CommentWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		CommentVO vo = new CommentVO();
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		vo.setBoard_no(board_no);
		vo.setId((String)request.getSession().getAttribute("login"));
		vo.setContent(request.getParameter("content"));
		
		BoardDAO.getInstance().commentWrite(vo);
		
		request.setAttribute("seq", board_no);

	}

}
