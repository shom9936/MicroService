 package heava;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


       /*나는 HaevaImpl.java*/  
public interface HaevaImpl { //class x, interface o

	public void haeva(HttpServletRequest request, 
			          HttpServletResponse response)	 
			        		          throws Exception;
	//선언은 여기서하고 구현은 child 에서 함 
}
