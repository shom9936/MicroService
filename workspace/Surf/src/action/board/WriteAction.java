package action.board;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.BoardDAO;
import vo.BoardVO;
import util.Action;

public class WriteAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		String realPath = request.getServletContext().getRealPath("/storage");
		System.out.println(realPath);
		MultipartRequest mr = new MultipartRequest(request, realPath, 1024*1024*10, "UTF-8", new DefaultFileRenamePolicy());
		
		String id = (String)session.getAttribute("login");
		String title = mr.getParameter("title");
		String content = mr.getParameter("content");
		String fileName = mr.getFilesystemName("filename");

		BoardVO boardVO = new BoardVO();
		boardVO.setId(id);
		boardVO.setTitle(title);
		boardVO.setContent(content);
		boardVO.setFilename(fileName);
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		int num = boardDAO.write(boardVO);
		
		boolean checkWrite = false;
		String msg = null;
		String url = "/Surf/board/list.brd?pg=1";
		
		if(num != 0) {
			checkWrite = true;
			msg = "작성하신 글이 저장되었습니다.";
		} else {
			msg = "저장에 실패했습니다.";
		}
		
		request.setAttribute("checkWrite", checkWrite);
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
	}
}
