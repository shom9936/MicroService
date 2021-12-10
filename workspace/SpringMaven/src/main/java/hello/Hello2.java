package hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import helloProcess.HelloProcess2;

public class Hello2 {

	public static void main(String[] args) {
		
		System.out.println("안녕");
		ApplicationContext ac = new ClassPathXmlApplicationContext("aopxml2.xml");

		HelloProcess2 hp = (HelloProcess2) ac.getBean("helloProcessBean2");
		
		hp.kajaDrive(); // 핵심 로직 메소드
		
		((AbstractApplicationContext) ac).close();
		
	}

}
