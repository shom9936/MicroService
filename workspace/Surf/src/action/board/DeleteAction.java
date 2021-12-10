package action.board;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import util.Action;

public class DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int seq = Integer.parseInt(request.getParameter("seq"));
		int num = BoardDAO.getInstance().delete(seq);
		
		boolean checkWrite = false;
		String msg = null;
		String url = "/Surf/board/list.brd?pg=1";
		
		if(num != 0) {
			checkWrite = true;
			msg = "삭제되었습니다.";
		} else {
			msg = "삭제에 실패했습니다.";
		}
		
		request.setAttribute("checkWrite", checkWrite);
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);

	}

}
