package cookie;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import kr.or.ddit.cookie.CookieSplit;

public class CookieSplitTest {
	
	@Test
	public void getCookieValueSuccessTest() {
		/***Given : 주어진 상황 기술 ***/
		CookieSplit cookieSplit = new CookieSplit();
		
		/***When : 행위 ***/
		String result = cookieSplit.getCookieValue("USERNM");
		
		/***Then : 결과 ***/
		assertNotNull(result);
		
	}
	
	
	
	@Test
	public void getCookieValueFailTest() {
		/***Given : 주어진 상황 기술 ***/
		CookieSplit cookieSplit = new CookieSplit();
		
		/***When : 행위 ***/
		String result = cookieSplit.getCookieValue("PASSWORD");
		
		/***Then : 결과 ***/
		assertNotNull(result);
		
	}
}
