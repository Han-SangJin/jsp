package kr.or.ddit.member.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.model.MemberVo;

public class MemberDaoTest {
	
	
	private static final Logger logger = LoggerFactory.getLogger(MemberDaoTest.class);
	
	
	@Test
	public void getMemberTest() {
		/***Given***/
		MemberDao memberdao = new MemberDao();
		String userId = "brown";

		MemberVo answerMemberVo = new MemberVo();
		answerMemberVo.setUserid("brown");
		answerMemberVo.setPass("brownPass");
		
		/***When***/
		MemberVo memberVo = memberdao.getMember(userId);
		
		/***Then***/
		assertEquals("brown", memberVo.getUserid());
		assertEquals("brownPass", memberVo.getPass());
		
//		assertEquals(answerMemberVo, memberVo);
	}
	
	
	@Test
	public void selectAllMemberTest() {
		/***Given***/
		MemberDao memberdao = new MemberDao();
		
		/***When***/
		List<MemberVo> memberList = memberdao.selectAllMember();
		
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
		MemberDaoI memberDao = new MemberDao();
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
} 
