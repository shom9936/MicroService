package hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import helloProcess.HelloProcess;

public class Hello {

	public static void main(String[] args) {
		
		System.out.println("안녕");
		ApplicationContext ac = new ClassPathXmlApplicationContext("aopxml.xml");

		HelloProcess hp = (HelloProcess) ac.getBean("helloProcessBean");
		
		hp.kajaDrive(); // 핵심 로직 메소드
		hp.kajaTrip();
		hp.kajaDrive(); // 가동시, 전에 공통가동
		
		((AbstractApplicationContext) ac).close();
		
	}

}
