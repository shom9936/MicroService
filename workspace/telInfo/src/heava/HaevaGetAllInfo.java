package heava;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TelInfoDAO;
import vo.TelInfoVO;

/* ��  HaevaGetAllInfo.java*/
public class HaevaGetAllInfo implements HaevaImpl{////////
	
	@Override     //parent���� �����ϰ� child���� ������ haeva() �޼���
	public void haeva(HttpServletRequest request,
			             HttpServletResponse response) throws Exception {///
		// TODO Auto-generated method stub
		//=============== �̺κе��� ================
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		TelInfoDAO tidao1 = null;
		
		tidao1 = new TelInfoDAO();
		ArrayList<TelInfoVO> alist1 = null;
		alist1 = tidao1.getAllInfo();
		request.setAttribute("alist1", alist1);
		//=========================================
		// ������ controller���� ���������� ����ߴٴ� 
		//BUT �ش�κ��� ó���ϴ� �񼭰� ����� 
	}
}







