package helloProcess;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
//Aspect를 자바형식으로
@Aspect// xml의 <aop:aspect> 부분, 즉 aspectJ
public class Security2 {

	/*
	<aop:config> <!-- bean과 별도로 aop 구성 -->
		<aop:aspect id="securityAspect" ref="securityBean">
			<aop:pointcut expression="within(helloProcess.HelloProcess)" id="secuPoint"/>
					<!-- 공통이 적용된 부분 -->
			<aop:before  pointcut-ref="secuPoint" method="goSecurity"/>
					<!-- pointcut으로 지정한 부분이 실행되기 전 goSecurity가 가동됨 -->
					<!-- 즉, HelloProcess의 kajaDrive() 메소드가 가동되기 전(before) 보안처리함 -->
			<aop:after  pointcut-ref="secuPoint" method="goSecurity2"/>
		</aop:aspect>
	</aop:config>
	 */
	
	// 스프링은 Pointcut 적용 시 only 메소드
	@Pointcut("execution(* helloProcess..*())")
	private void mukja() {
		// 아무 이름의 메소드를 하나 만듬
		// 어떻게를 위해, 그리고 구조를 위해 mukja() 이것 사용함
		// 여기 내용은 없음
	}
	@Before("mukja()")
	public void goSecurity() {
		System.out.println("공통 : 여기는 보안 처리중");
		// 핵심 (주요) 메소드에 before를 적용, 공통 로직은 ㄴgoSecurity()
	}
	@After("mukja()")
	public void goSecurity2() {
		System.out.println("공통 : 여기는 보안 처리중2");
		System.out.println();
	}


}
