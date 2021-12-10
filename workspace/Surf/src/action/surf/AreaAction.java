package action.surf;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SurfDAO;
import util.Action;
import vo.SurfAreaVO;

public class AreaAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException{
		SurfDAO dao = null;
		try {
			dao = new SurfDAO();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int area = Integer.parseInt(request.getParameter("area"));
		ArrayList<SurfAreaVO> list = null;
		String areaName = "";

		switch (area) {
		case 1:
			areaName = "남해";
			break;
		case 2:
			areaName = "동해";
			break;
		case 3:
			areaName = "제주도";
			break;
		case 4:
			areaName = "서해";
			break;
		}

		try {
			list = dao.locationSearch(areaName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (areaName.equals(""))
			areaName = "error";
		
		request.setAttribute("areaName", areaName);
		request.setAttribute("list", list);
	}

}
