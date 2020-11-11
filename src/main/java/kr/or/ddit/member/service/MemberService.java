package kr.or.ddit.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import ch.qos.logback.classic.Logger;
import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.dao.MemberDaoI;
import kr.or.ddit.member.model.MemberVo;

@Service("memberService")
public class MemberService implements MemberServiceI {
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(MemberService.class);
	
	@Resource(name="memberDao")
	private MemberDaoI memberDao;
	

	public void setMemberDao(MemberDaoI memberDao) {
		this.memberDao = memberDao;
	}
	
	
	// service 기본 생성자
	public MemberService() {
		
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
//		logger.debug("첫번째 insert 시작전");
//		memberDao.insertMember(memberVo);
//		logger.debug("첫번째 insert 시작후");
//		
//		logger.debug("두번째 insert 시작전");
//		memberDao.insertMember(memberVo);
//		logger.debug("두번째 insert 시작후");
		
		
		// 첫번재 쿼리는 정상적으로 실행되지만
		// 두번째 쿼리에서 동일한 데이터를 이별가형 primary key 제약조건에 의해
		// sql 실행실패
		// 첫번재 쿼리는 성공했지만 트랜잭션 설정을 service 레벨에 설정하였기 때문에
		// 서비스 메소드에서 실행된 모든 쿼리를 rollback 처리한다
		
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
