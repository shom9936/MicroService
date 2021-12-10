package action.surf;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SurfDAO;
import util.Action;
import vo.ShopReviewVO;

public class ReviewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = (String)request.getSession().getAttribute("login");
		String content = request.getParameter("content");
		int star_rating = Integer.parseInt(request.getParameter("star_rating"));
		String shop_name = request.getParameter("shop_name");
		
		SurfDAO dao = null;
		try {
			dao = new SurfDAO();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ShopReviewVO reviewVO = new ShopReviewVO();
		reviewVO.setId(id);
		reviewVO.setContent(content);
		reviewVO.setShop_name(shop_name);
		reviewVO.setStar_rating(star_rating);
		
		try {
			dao.writeReview(reviewVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("shop_name", shop_name);
	}

}
