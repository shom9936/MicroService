package hello;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import helloProcess.SawonDAO;
import helloProcess.SawonVO;

public class Hello {
	static SawonDAO sd;
	
	public static void main(String[] args) {
		ApplicationContext ac = new GenericXmlApplicationContext("jdbctemplatexml.xml");
		sd = (SawonDAO) ac.getBean("sawonDAOBean");
		
		kaja();
		sd.update();
		kaja();
		
		((AbstractApplicationContext) ac).close();
	}
	
	public static void kaja() {
		
		ArrayList<Object> alist = sd.selectAll();
		Iterator<Object> it = alist.iterator();
		
		while(it.hasNext()) {
			SawonVO sv = (SawonVO) it.next();
			System.out.println(sv.getName()+"\t"+sv.getTel());
			System.out.println();
		}
		
		
	}

}
