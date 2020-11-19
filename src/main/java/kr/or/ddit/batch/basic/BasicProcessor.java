package kr.or.ddit.batch.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class BasicProcessor implements ItemProcessor<String, String>{

	private static final Logger logger = LoggerFactory.getLogger(BasicProcessor.class);
	
	@Override
	public String process(String item) throws Exception {
		
		logger.debug("======process()======");
		logger.debug("process : {}, {}", item, item + "+_modified");
		
		// reader 에서 읽은데이터 이름 뒤에  "_modified"  를 붙여줌
		return item + "_modified";
	}

}
