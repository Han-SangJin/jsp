package kr.or.ddit.member.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.jobs.model.JobsVo;
import kr.or.ddit.jobs.service.JobsService;

public class JobServiceTest {
	@Test
	public void getMemberTest() {
		/***Given***/
		JobsService jobsService = new JobsService();

		/***When***/
		List<JobsVo> jobsVoList = jobsService.selectAllJobs();
			
		/***Then***/
		assertEquals(19, jobsVoList.size());
	}
}
