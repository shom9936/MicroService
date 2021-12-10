package action.surf;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SurfDAO;
import util.Action;
import vo.SurfAreaVO;
import vo.SurfSpotVO;

public class LocationAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String location = request.getParameter("location");
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
		
		
		String areaName = request.getParameter("areaName");
		System.out.println(areaName);
		ArrayList<SurfAreaVO> areaList = null;
		ArrayList<SurfSpotVO> locationList = null;
		try {
			locationList = dao.spotSearch(location);
			areaList = dao.locationSearch(areaName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("areaList", areaList);
		request.setAttribute("locationList", locationList);
		request.setAttribute("locationName", location);
		request.setAttribute("areaName", areaName);
		
	}
}
