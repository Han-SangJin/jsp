package kr.or.ddit.member.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import kr.or.ddit.member.model.MemberVo;

public class MemberDaoTest {
	
	@Test
	public void getMemberTest() {
		/***Given***/
		MemberDao memberdao = new MemberDao();
		String userId = "brown";

		MemberVo answerMemberVo = new MemberVo();
		answerMemberVo.setUserId("brown");
		answerMemberVo.setPassword("passBrown");
		 
		
		/***When***/
		MemberVo memberVo = memberdao.getMember(userId);

		
		/***Then***/
//		assertEquals("brown", memberVo.getUserId());
//		assertEquals("passBrown", memberVo.getPassword());
		
		assertEquals(answerMemberVo, memberVo);
	}

} 
