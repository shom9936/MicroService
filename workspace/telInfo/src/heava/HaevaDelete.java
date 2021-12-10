package heava;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TelInfoDAO;

public class HaevaDelete implements HaevaImpl{ /////////
	@Override       //삭제에서도 진행 형식은 같음 
	public void haeva(HttpServletRequest request, 
			          HttpServletResponse response) throws Exception 
	{
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		TelInfoDAO tidao = null;
		String name = request.getParameter("name");//////
		
		tidao = new TelInfoDAO();
		tidao.delete(name);////////////////
		
	}
}
