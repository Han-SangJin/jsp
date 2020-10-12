package kr.or.ddit.member.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.jobs.dao.JobsDao;
import kr.or.ddit.jobs.model.JobsVo;

public class JobDaoTest {
	@Test
	public void getMemberTest() {
		/***Given***/
		JobsDao jobsDao = new JobsDao();

		/***When***/
		List<JobsVo> jobsVoList = jobsDao.selectAllJobs();
			 
		/***Then***/
		assertEquals(19, jobsVoList.size());
	}
}
