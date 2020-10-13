package kr.or.ddit.member.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.dao.MemberDao;
import kr.or.ddit.member.dao.MemberDaoI;
import kr.or.ddit.member.model.MemberVo;

public class MemberService implements MemberServiceI {
	
	private MemberDaoI memberDao;
	
	public MemberService() {
		memberDao = new MemberDao();
	}
	
	@Override
	public MemberVo getMember(String userId) {
		return memberDao.getMember(userId);
	}
	
	
	@Override
	public List<MemberVo> selectAllMember() {
		SqlSession sqlSession = MybatisUtil.getSession();
		List<MemberVo> memberList =  sqlSession.selectList("member.selectAllMember");
		
		sqlSession.close();
		return memberList;
	}
}
