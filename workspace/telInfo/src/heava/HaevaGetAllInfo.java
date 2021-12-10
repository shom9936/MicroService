package heava;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TelInfoDAO;
import vo.TelInfoVO;

/* 나  HaevaGetAllInfo.java*/
public class HaevaGetAllInfo implements HaevaImpl{////////
	
	@Override     //parent에서 선언하고 child에서 구현한 haeva() 메서드
	public void haeva(HttpServletRequest request,
			             HttpServletResponse response) throws Exception {///
		// TODO Auto-generated method stub
		//=============== 이부분들이 ================
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		TelInfoDAO tidao1 = null;
		
		tidao1 = new TelInfoDAO();
		ArrayList<TelInfoVO> alist1 = null;
		alist1 = tidao1.getAllInfo();
		request.setAttribute("alist1", alist1);
		//=========================================
		// 전에는 controller에서 구구절절이 기록했다는 
		//BUT 해당부분을 처리하는 비서가 생긴것 
	}
}







