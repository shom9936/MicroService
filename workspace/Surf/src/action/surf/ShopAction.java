package action.surf;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SurfDAO;
import util.Action;
import vo.ShopReviewVO;
import vo.SurfShopVO;

public class ShopAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String info = request.getParameter("info");
		if(info == null) {
			info = (String) request.getAttribute("shop_name");
		} 
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
		
		SurfShopVO shopVO = null;
		ArrayList<ShopReviewVO> reviewList = null;
		boolean isEmpty = true;
		try {
			shopVO = dao.shopInfo(info);
			reviewList = dao.getReview(shopVO.getShop_name());
			if(reviewList != null) {
				isEmpty = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("shopVO", shopVO);
		request.setAttribute("reviewList", reviewList);
		request.setAttribute("isEmpty", isEmpty);
	}
}
