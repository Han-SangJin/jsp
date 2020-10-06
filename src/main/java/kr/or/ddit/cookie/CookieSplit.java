package kr.or.ddit.cookie;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CookieSplit {
	
	private static final Logger Logger = LoggerFactory.getLogger(CookieSplit.class);
	
	// cookieStrim 문자열 변수에 담근 값은
	// 쿠키이름1 = 쿠키값1; 쿠키이름2=쿠키값2; .... 형태로 구성됨
	// 구성된 쿠키 이름과 값은 상황에 따라 변경될 수 있음
	private String cookieString = "USERNM=brown; REMEMBERME=Y; TEST=T;";
	
	
	public static void main(String[] args) {
		CookieSplit cookieSplit = new CookieSplit();
		Logger.debug(cookieSplit.getCookieValue("USERNM"));  // 기대되는 값 brown
		Logger.debug(cookieSplit.getCookieValue("REMEMBERME"));  // 기대되는 값 T
		Logger.debug(cookieSplit.getCookieValue("XXXX"));  // 기대되는 값 ""(WHITE SPACE)		
		
	}
	
	
	// cookieString 필드를 분석하여 메소드 인자로 넘어온 cookieName 에 해당하는 쿠키가 있을경우
	// 해단 쿠키의 값을 반환하는 메소드
	public String getCookieValue(String cookieName) {
		String[] cookies = cookieString.split("; ");
//		System.out.println(cookies.toString());
		System.out.println(Arrays.toString(cookies));
		String cookie = "";
		for(int i=0; i<cookies.length; i++) {
			if (cookieName.equals(cookies[i].split("=")[0])) {
				cookie = cookies[i].split("=")[1];
			}
		}
		return cookie;
	}
}
/*		for(int i=0; i<cookies.length; i++) {
			usernm = cookies[i].split("=");
			if(usernm == null) {
				usernm[1]="";
				return usernm[1];
			}else {
			System.out.println("cookieName : "+cookieName.toString());
			System.out.println(usernm[i]);
			return usernm[i];
			}
		}*/
