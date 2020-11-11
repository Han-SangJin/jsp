package kr.or.ddit.config.ioc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;

public class IocTest {
	private static final Logger logger = LoggerFactory.getLogger(IocTest.class);
		
	public static void main(String[] args) {
		// 스프링 빈 사용설명서를 사용하여 스프링 컨테이너를 생성
		// 스프링 컨테이너로 : applicationContext
		ApplicationContext context  = 
				new ClassPathXmlApplicationContext("classpath:kr/or/ddit/config/spring/ioc/ioc.xml",
												   "classpath:kr/or/ddit/config/spring/datasource-context_dev.xml");
		
		// 스프링 컨테이너로 부터 스프링 빈을 받아서 사용
		// 컨테이너에게 원하는 스프링 빈을 요청하여 받는 과정(DL: Dependency Lookup)
		BoardService boasdService = context.getBean("boardService", BoardService.class);
		if(boasdService.getBoardRepository() != null) {
			System.out.println("boardRepository is not null");
		}
			
		logger.debug("getBoard : {}", boasdService.getBoard(1));
		
		
		// 스프링 빈 boardService를 DL 하여 getBoard(1) 메소드를 call 
		
		// ioc.xml 파일에서 설정한 boardServiceC 가 설정한 Dao 를 연결
		BoardServiceI boardServiceC = (BoardServiceI)context.getBean("boardServiceC");
		// Dao의 getboard(1) 메소드의 값을 가져옴
		logger.debug("boardServiceC.getBoard(1) : {}", boardServiceC.getBoard(1));
		
	}
}