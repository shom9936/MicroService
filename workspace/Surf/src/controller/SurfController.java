package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.surf.AreaAction;
import action.surf.LocationAction;
import action.surf.ReviewAction;
import action.surf.ShopAction;
import action.surf.SpotAction;
import util.Action;
import util.ActionForward;

@WebServlet("*.su")
public class SurfController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Action action = null;
		ActionForward actionForward = null;

		String requestURL = request.getRequestURL().toString();
		System.out.println(requestURL);
		int lastIndex1 = requestURL.lastIndexOf("/");
		int lastIndex2 = requestURL.lastIndexOf(".su");

		String path = requestURL.substring(lastIndex1 + 1, lastIndex2);

		switch (path) {
		case "surfArea":
			action = new AreaAction();
			actionForward = new ActionForward("/surf/surfArea.jsp", false);
			break;
		case "surfLocation":
			action = new LocationAction();
			actionForward = new ActionForward("/surf/surfLocation.jsp", false);
			break;
		case "surfSpot":
			action = new SpotAction();
			actionForward = new ActionForward("/surf/surfSpot.jsp", false);
			break;
		case "surfShop":
			action = new ShopAction();
			actionForward = new ActionForward("/surf/surfShop.jsp", false);
			break;
		case "reviewWrite" :
			action = new ReviewAction();
			actionForward = new ActionForward("/surf/surfShop.su", false);
			break;
		}

		if (action != null) {
			try {
				action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (actionForward.isRedirect()) {
			response.sendRedirect(actionForward.getNextPath());
		} else {
			request.getRequestDispatcher(actionForward.getNextPath()).forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}