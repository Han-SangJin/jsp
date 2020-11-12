package kr.or.ddit.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// 관심 타겟 모듈화 (target 역할 )
@Aspect // JoinPoint 를 자바로 사용할때 만 등록
public class profilingAdvice {
	
	private static final Logger logger = LoggerFactory.getLogger(profilingAdvice.class);

	// pointCut 설정을 위한 의미 없는 메소드
	// joint point 가 호출될 시점을 더 자세히 정함
	@Pointcut("execution(* kr.or.ddit..service.*.*(..))")
	public void dummy() {
		
	}
	
	// Aop 의 aspect 기능 시작전 호출 
	@Before("dummy()") // @Aspect 등록할때 같이 등록(어노테이션만)	
	public void beforeMethod(JoinPoint joinPoint) {
		logger.debug("beforeMethod : {}", joinPoint.getSignature().getName());
	}
	
	
	@Around("dummy()") // @Aspect 등록할때 같이 등록(어노테이션만)
	public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
		
		// 메소드 실행전 공통 관심사항  
		long start = System.currentTimeMillis();
		
		// 메소드 실행  ->  aspect 어떤일을 할지 구체하된것
		Object ret = joinPoint.proceed(joinPoint.getArgs());
		
		// 메소드 실행후 공통 관심사항	
		long end = System.currentTimeMillis();
		logger.debug("profiling : {} {} - {}", joinPoint.getSignature().getDeclaringTypeName(),
												joinPoint.getSignature().getName(),
												end-start +" ms");
		
		return ret;
	}
}
