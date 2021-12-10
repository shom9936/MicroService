package heava;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TelInfoDAO;
import vo.TelInfoVO;

public class HaevaSearchone implements HaevaImpl{
	@Override
	public void haeva(HttpServletRequest request, 
			          HttpServletResponse response)  throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		TelInfoDAO tidao1 = null;
		TelInfoVO tv = null;
		try {
			tidao1 = new TelInfoDAO();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String name = request.getParameter("name");
		
		try {
			tv = tidao1.getOneInfo(name);/////////////
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("sname", name);/////////
		request.setAttribute("stv", tv);/////////////
	}

}

