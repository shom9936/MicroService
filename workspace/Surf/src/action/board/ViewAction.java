package action.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import util.Action;
import vo.BoardVO;
import vo.CommentVO;

public class ViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String strSeq = request.getParameter("seq");
		int seq;
		if(strSeq == null) {
			System.out.println(request.getAttribute("seq"));
			seq = (int) request.getAttribute("seq");
		} else {
			seq = Integer.parseInt(strSeq);
		}
		
		BoardDAO dao = BoardDAO.getInstance();
		
		BoardVO vo = dao.getBoardInfo(seq);
		String temp = vo.getLogtime();
		vo.setLogtime(temp.substring(0,10));
		dao.updateHit(seq);
		ArrayList<CommentVO> list = dao.getComment(seq);
		
		boolean isEmpty;
		if(list.isEmpty()) isEmpty = true;
		else isEmpty = false;
		
		request.setAttribute("isEmpty", isEmpty);
		request.setAttribute("comList", list);
		request.setAttribute("boardVO", vo);

	}

}