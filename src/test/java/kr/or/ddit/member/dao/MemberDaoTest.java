package kr.or.ddit.member.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.model.MemberVo;

public class MemberDaoTest {
	
	// @BeforeClass
	// 테스트 메소드 실행 사이클 : @Before => @Test => @After
	// @AfterClass (static)
	
	private static final Logger logger = LoggerFactory.getLogger(MemberDaoTest.class);
	
	MemberDaoI memberDao ;
	
	
	@Before
	public void setup() {
		memberDao = new MemberDao();
		String userid = "hsj";
		memberDao.deleteMember(userid);
	}
	
	
	@Test
	public void getMemberTest() {
		/***Given***/
		memberDao = new MemberDao();
		String userId = "brown";

		MemberVo answerMemberVo = new MemberVo();
		answerMemberVo.setUserid("brown");
		answerMemberVo.setPass("brownPass");
		
		/***When***/
		MemberVo memberVo = memberDao.getMember(userId);
		
		/***Then***/
		assertEquals("brown", memberVo.getUserid());
		assertEquals("brownPass", memberVo.getPass());
		
//		assertEquals(answerMemberVo, memberVo);
	}
	
	
	@Test
	public void selectAllMemberTest() {
		/***Given***/
		memberDao = new MemberDao();
		
		/***When***/
		List<MemberVo> memberList = memberDao.selectAllMember();
		
		/***Then***/
		assertEquals(15, memberList.size());
	}
	
	
	@Test
	public void selectMemberPageList() {
		/***Given***/
		MemberDaoI memberDao = new MemberDao();
		PageVo pageVo = new PageVo(1,7);
		SqlSession sqlSession = MybatisUtil.getSession();
		//int page = 1;
		
		/***When***/
		List<MemberVo> memberList = memberDao.selectMemberPageList(sqlSession, pageVo);
		
		/***Then***/
		assertEquals(7, memberList.size());
	}
	
	
	@Test
	public void selectMemberTotalCnt() {
		/***Given***/
		memberDao = new MemberDao();
		SqlSession sqlSession = MybatisUtil.getSession();
		//int page = 1;
		
		/***When***/
		int totalCnt = memberDao.selectMemberTotalCnt(sqlSession);
		
		/***Then***/
		assertEquals(15, totalCnt);
	}
	
		
	@Test
	public void test() {
		/***Given***/
		
		/***When***/
		logger.debug("{}", (int)Math.ceil((double)15/7));   
		
		/***Then***/
	}
	 
	
	@Test
	public void insertMemberDaoTest() {
		/***Given***/
		memberDao = new MemberDao();
		memberDao.deleteMember("hsj");
		MemberVo memberVo = new MemberVo("hsj", "pass1234", "한상진", "HSJ", "대전 중구 중앙로 76", "영민빌딩 404호", "34940", "d:\\profile\\hsj.png", "hsj.png");
		SqlSession sqlSession = MybatisUtil.getSession();

		/***When***/
		int insertCnt = memberDao.insertMember(memberVo);
			 
		/***Then***/
		assertEquals(1, insertCnt);
	}
} 
