package kr.or.ddit.ranger.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.cookie.CookieSplit;

public class CookieTest {

	@Test
	public void getRangersTest() {
		/***Given : 주어진 상황 기술 ***/
		CookieSplit cookieSplit = new CookieSplit();
		
		/***When : 행위 ***/
		String result = cookieSplit.getCookieValue("USERNM");
		
		/***Then : 결과 ***/
		assertNotNull(result);
		
	}

}
