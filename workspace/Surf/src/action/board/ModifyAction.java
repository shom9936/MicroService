package action.board;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.BoardDAO;
import util.Action;
import vo.BoardVO;

public class ModifyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String realPath = request.getServletContext().getRealPath("/storage");
		MultipartRequest mr = new MultipartRequest(request, realPath, 1024*1024*10, "UTF-8", new DefaultFileRenamePolicy());
		
		String title = mr.getParameter("title");
		String content = mr.getParameter("content");
		int seq = Integer.parseInt(mr.getParameter("seq"));
		String fileName = mr.getFilesystemName("filename");

		BoardVO boardVO = new BoardVO();
		boardVO.setTitle(title);
		boardVO.setContent(content);
		boardVO.setFilename(fileName);
		boardVO.setSeq(seq);
		
		int num = BoardDAO.getInstance().update(boardVO);
		
		boolean checkWrite = false;
		String msg = null;
		String url = "/Surf/board/view.brd?seq="+seq;
		
		if(num != 0) {
			checkWrite = true;
			msg = "작성하신 글이 수정되었습니다.";
		} else {
			msg = "수정에 실패했습니다.";
		}
		
		request.setAttribute("checkWrite", checkWrite);
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);


	}

}
