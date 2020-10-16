package kr.or.ddit.member.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.member.dao.MemberDao;
import kr.or.ddit.member.model.MemberVo;

public class MemberServiceTest {
	
	@Test
	public void getMemberTest() {
		/***Given***/
		MemberServiceI memberService = new MemberService();
		String userId = "brown";

		MemberVo answerMemberVo = new MemberVo();
		answerMemberVo.setUserid("brown");
		answerMemberVo.setPass("brownPass");
		 
		
		/***When***/
		MemberVo memberVo = memberService.getMember(userId);

		
		/***Then***/
		assertEquals("brown", memberVo.getUserid());
		assertEquals("brownPass", memberVo.getPass());
		
//		assertEquals(answerMemberVo, memberVo);
	}
	
	
	@Test
	public void selectMemberPageList() {
		/***Given***/
		MemberServiceI memberService = new MemberService();
		PageVo pageVo = new PageVo(1,7);
//		int page = 1;
		
		/***When***/
		// memberList 확인
		Map<String,Object> map =  memberService.selectMemberPageList(pageVo);
		List<MemberVo> memberList = (List<MemberVo>) map.get("memberList");
		 
		// 생성해야할 page수
		int pages = (Integer)map.get("pages");
		
		/***Then***/
		assertEquals(7, memberList.size());
		assertEquals(3, pages);
	}
}
