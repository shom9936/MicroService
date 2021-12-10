package mvcc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controllers
 */

public class Controllers extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		request.setCharacterEncoding("euc-kr");
		response.setCharacterEncoding("euc-kr");
		char yourScore;
		int score = Integer.parseInt(request.getParameter("score"));
		if(score >= 90) yourScore = 'A';
		else if(score >= 80) yourScore = 'B';
		else if(score >= 70) yourScore = 'C';
		else if(score >= 60) yourScore = 'D';
		else yourScore = 'F';
		request.setAttribute("name", name);
		request.setAttribute("yourScore", yourScore);
		request.getRequestDispatcher("/mvc/viewjsp/" + "view.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
