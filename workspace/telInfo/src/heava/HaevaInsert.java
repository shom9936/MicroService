package heava;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TelInfoDAO;

public class HaevaInsert implements HaevaImpl{
	@Override
	public void haeva(HttpServletRequest request, 
			          HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String d = request.getParameter("sDate");//문자로 받은 날짜 
		
		TelInfoDAO tidao = null;
		
		tidao = new TelInfoDAO();
		tidao.insert(id, name, tel, d);////////////
	}
}

