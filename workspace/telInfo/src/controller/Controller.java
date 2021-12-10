package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import heava.HaevaDelete;
import heava.HaevaGetAllInfo;
import heava.HaevaImpl;
import heava.HaevaInsert;
import heava.HaevaSearchone;
import heava.HaevaUpdate;

/**
 * Servlet implementation class Sawonfrontcontroller
 */
//@WebServlet("/Sawonfrontcontroller")
@WebServlet("*.do")
public class Controller extends HttpServlet {
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		/*******************************/
		String c =request.getRequestURI().substring
                     (request.getContextPath().length());
		/**********************************/
		
		String str = null;  ///////////
		HaevaImpl h1 = null; //Impl ,implements,HaevaImpl = �������̽�
		   //   ���    A extends B  A implements B
		   //          (B�� Ŭ����)    (B�� interface) 
		switch(c) {
		  case "/getAllInfo.do":
			//h1 = new HaevaImpl(); //�̷� ������ �Ǵ� ���� �⺻ 
			h1 = new HaevaGetAllInfo();
			try {   //you know ???!!! �θ������ �ڽ��� ����Ű�� �� 
				   //�̰�� haeva()�� 2���ε� �����? child�� ã�ư� ���� 
				h1.haeva(request, response); //child �� �ִ� �޼ҵ� 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();}
			str = "view.jsp";
			break;

		case "/telSearchOne.do":
			h1 = new HaevaSearchone();///////
			try { h1.haeva(request, response);
			} catch (Exception e) {
				e.printStackTrace(); }
			str = "sawonUpdateForm.jsp";/////
			break;
			
			
		case "/telInsert.do":
			h1 = new HaevaInsert();//////
			try { h1.haeva(request, response);
			} catch (Exception e) {
				e.printStackTrace(); }
			str = "view.jsp";///////
			break;
		case "/telUpdate.do":
			h1 = new HaevaUpdate();//////
			try { h1.haeva(request, response);
			} catch (Exception e) {
				e.printStackTrace(); }
			str = "updateForm.jsp";///////
			break;
		case "/telDelete.do":
			h1 = new HaevaDelete();//HaevaDelete.java
			try { h1.haeva(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace(); }
			str = "view.jsp";
			break;
		} //swich -end 
		RequestDispatcher rd1 = request.getRequestDispatcher(str);
		rd1.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
