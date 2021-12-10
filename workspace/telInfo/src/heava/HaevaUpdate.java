package heava;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TelInfoDAO;
import vo.TelInfoVO;

public class HaevaUpdate implements HaevaImpl{
	@Override
	public void haeva (HttpServletRequest request,
			           HttpServletResponse response)  throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		TelInfoDAO tidao1 = null;
		TelInfoVO tv = null;
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String d = request.getParameter("d");
		//여기까지 수정된 내용이 넘어온다 
		String sname = request.getParameter("sname");
		 //링크시 선택한 이름을 계속 넘겨받고 있다 (you know ?...hidden)
		
		
		try {
			tidao1 = new TelInfoDAO();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {    //DAO에서 해당 이름이 수정되어 DB로 
			tidao1.update(name, tel, d);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
