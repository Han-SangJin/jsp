package kr.or.ddit.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.dao.MemberDaoI;
import kr.or.ddit.member.model.MemberVo;

@Service("memberService")
public class MemberService implements MemberServiceI {
	
	@Resource(name="memberDao")
	private MemberDaoI memberDao;
	
	
	// dao getter setter 생성
	public MemberDaoI getMemberDao() {
		return memberDao;
	}
	public void setMemberDao(MemberDaoI memberDao) {
		this.memberDao = memberDao;
	}
	
	
	// service 기본 생성자
	public MemberService() {
		
	}
	
	
	// dao 정보를 받아오는 service 생성자
	public MemberService(MemberDaoI memberRepository) {
		this.memberDao = memberRepository;
	}
	
	
	// 멤버 체크
	@Override
	public MemberVo getMember(String userid) {
		return memberDao.getMember(userid);
	}
	
	
	@Override
	public List<MemberVo> selectAllMember() {
		return memberDao.selectAllMember();
	}
	
	
	@Override
	public int insertMember(MemberVo memberVo) {
		return memberDao.insertMember(memberVo);
	}

	
	@Override
	public int deleteMember(String userid) {
		return memberDao.deleteMember(userid);
	}
		
	@Override
	public int updateMember(MemberVo memberVo) {
		return memberDao.updateMember(memberVo);
	}
	 
	
	
	@Override
	public Map<String, Object> selectMemberPageList(PageVo pageVo) {
		
		SqlSession sqlSession = MybatisUtil.getSession();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberList", memberDao.selectMemberPageList(sqlSession,pageVo));
		
		
		// 15건 ==(페이지사이즈 7)==> 3페이지
		// 15/7 ==  2.14.. ==(올림)==> 3페이지 
		int totalCnt = memberDao.selectMemberTotalCnt(sqlSession);
		int pages = (int)Math.ceil((double)totalCnt/7);
		map.put("pages", pages);
		
		sqlSession.close();
		return map;
	}
	 
	
	@Override
	public int selectMemberTotalCnt() {
		SqlSession sqlSession = MybatisUtil.getSession();
		return memberDao.selectMemberTotalCnt(sqlSession);
	}

}
