package mvcc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hakjum
 */
@WebServlet("/hakjum")
public class hakjum extends HttpServlet {
        private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hakjum() {
        super();
        // TODO Auto-generated constructor stub
    }

        /**
         * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                // TODO Auto-generated method stub
                // response.getWriter().append("Served at: ").append(request.getContextPath());
        
        }

        /**
         * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                // TODO Auto-generated method stub
                // doGet(request, response); //주석처리
                //여기서 kaja()메소드 호출및 작성도 가능
                
                // business logic
                request.setCharacterEncoding("EUC-KR");
                //response.setCharacterEncoding("text/html;charset=EUC-KR);
                response.setContentType("text/html;charset=EUC-KR");
                
                String irum=request.getParameter("irum");
                String jum1=request.getParameter("jum");
                int jum = Integer.parseInt(jum1);
                
                /* 아래 부분이 MVC2방식 */
                String kaja = null;
                /* ==========business logic 을 jsp가  담당============= */
                if(jum>=90)
                        kaja = "A.jsp";
                else if(jum>=80)
                        kaja = "B.jsp";
                else if(jum>=70)
                        kaja = "C.jsp";
                else if(jum>=60)
                        kaja = "D.jsp";
                else
                        kaja = "F.jsp";
                
                //ㄴ> 5개의 jsp를 만드는 이유는 jsp에서 계산은 하지 않고 view만 하기 때문이다.
        
                
                
                
                //만일 business logic 이 크면 service logic 이 요구된다
                
                // 이건 두줄로 쓴 것 뿐 한줄과 같다
                RequestDispatcher rd1=request.getRequestDispatcher("./jspview/"+kaja);
                rd1.forward(request, response);
        }

}












