package kr.or.ddit.jobs.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.jobs.model.JobsVo;

public class JobsDao implements JobsDaoI {
	
	@Override
	public List<JobsVo> selectAllJobs() {
		
		SqlSession sqlSession = MybatisUtil.getSession();
		List<JobsVo> jobsList =  sqlSession.selectList("jobs.selectAllJobs");
		return jobsList;
	}
	
}
