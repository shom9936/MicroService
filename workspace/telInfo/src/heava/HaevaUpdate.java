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
		//������� ������ ������ �Ѿ�´� 
		String sname = request.getParameter("sname");
		 //��ũ�� ������ �̸��� ��� �Ѱܹް� �ִ� (you know ?...hidden)
		
		
		try {
			tidao1 = new TelInfoDAO();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {    //DAO���� �ش� �̸��� �����Ǿ� DB�� 
			tidao1.update(name, tel, d);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
