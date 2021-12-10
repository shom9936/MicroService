package action.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import util.Action;
import vo.BoardVO;

public class ListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {	
		
		int pg = Integer.parseInt(request.getParameter("pg"));
		// 페이지당 글 목록
		int article = 8; // 페이지당 글 수
		int currentPage = pg; // 현재 페이지
		int startNum = (currentPage - 1) * article + 1;
		int endNum = startNum + article - 1;

		BoardDAO boardDAO = BoardDAO.getInstance();
		ArrayList<BoardVO> list = boardDAO.boardList(startNum, endNum);
		
		for(BoardVO vo : list) {
			String temp = vo.getLogtime().substring(0, 10);
			vo.setLogtime(temp);
		}

		// 페이징
		int totalArticle = boardDAO.getTotalArticle(); // 전체 글 수
		int totalPage = (totalArticle - 1) / article + 1;
		int block = 3; // 페이지 블록
		int startPage = (currentPage - 1) / block * block + 1;
		int endPage = startPage + block - 1;
		if(endPage > totalPage) endPage = totalPage;
		
		boolean checkList = true;
		if(list.isEmpty()) {
			checkList = false;
		}
		
		request.getSession().setAttribute("pg", pg);
		request.setAttribute("startNum", startNum);
		request.setAttribute("endNum", endNum);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("block", block);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("list", list);
		request.setAttribute("checkList", checkList);

	}

}
