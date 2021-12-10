package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Servlet implementation class JsonServlet1
 */
@WebServlet("/json2")
public class JsonServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter writer = response.getWriter();
		
		JSONObject totalObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		
		JSONObject memberInfo = new JSONObject();
		memberInfo.put("name", "박지성");
		memberInfo.put("age", 25);
		memberInfo.put("gender", "남자");
		memberInfo.put("nickname", "날센돌이");
		jsonArray.add(memberInfo);
		
		memberInfo = new JSONObject();
		memberInfo.put("name", "송혜교");
		memberInfo.put("age", 45);
		memberInfo.put("gender", "여자");
		memberInfo.put("nickname", "이쁜이");
		jsonArray.add(memberInfo);
		
		totalObject.put("members", jsonArray);
		
		String jsonInfo = totalObject.toString();
		System.out.println(jsonInfo);
		writer.print(jsonInfo);
	}

}
