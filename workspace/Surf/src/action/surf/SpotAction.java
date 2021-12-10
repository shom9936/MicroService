package action.surf;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SurfDAO;
import util.Action;
import vo.SurfAreaVO;
import vo.SurfShopVO;
import vo.SurfSpotVO;

public class SpotAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String location = request.getParameter("locationName");
		String areaName = request.getParameter("areaName");
		String spot = request.getParameter("spot");
		SurfDAO dao = null;
		System.out.println(location);
		try {
			dao = new SurfDAO();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<SurfShopVO> list = null;
		ArrayList<SurfAreaVO> areaList = null;
		ArrayList<SurfSpotVO> locationList = null;
		try {
			list = dao.shopSearch(spot);
			locationList = dao.spotSearch(location);
			areaList = dao.locationSearch(areaName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("list", list);
		request.setAttribute("areaList", areaList);
		request.setAttribute("locationList", locationList);
		request.setAttribute("locationName", location);
		request.setAttribute("areaName", areaName);
		request.setAttribute("spotName", spot);

	}
}
