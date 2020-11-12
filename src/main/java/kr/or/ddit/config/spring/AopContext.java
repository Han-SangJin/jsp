package kr.or.ddit.config.spring;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;


/*
<context:component-scan base-package="kr.or.ddit" use-default-filters="false"> 		<!-- @Aspect  -->
		<context:include-filter type="annotation" expression="org.aspectj.lang.annotation.Aspect"/>
</context:component-scan>
*/
@Configuration
@ComponentScan(basePackages = {"kr.or.ddit"}, useDefaultFilters = false, 
			 includeFilters = {@Filter(type=FilterType.ANNOTATION, 
					classes = {Aspect.class})} )
public class AopContext {
	//	xml파일을 context 로 쓸때보다 java 파일을 context 로 쓸때의 장점
	//	xml은 주소를 문자열로 받기 때문에 오타가 나도 모름
	//	자바는 자바언어로 받기 때문에 틀린것을 바로 확인이 가능
}
