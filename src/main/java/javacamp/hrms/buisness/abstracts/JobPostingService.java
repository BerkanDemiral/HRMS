package javacamp.hrms.buisness.abstracts;

import java.util.List;

import org.springframework.data.repository.query.Param;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Employer;
import javacamp.hrms.entities.concretes.JobPosting;
import javacamp.hrms.entities.dtos.JobPostingDto;

public interface JobPostingService {
	Result add(JobPosting jobPosting);
	Result update(JobPosting jobPosting);
	Result closeJobPosting(JobPosting jobPosting, Employer employer);
	
	DataResult<List<JobPostingDto>> getByIsActive(boolean status);
	DataResult<List<JobPosting>> getByIsActiveOrderByClosedDate(boolean status);
	DataResult<List<JobPostingDto>> getByIsActiveAndEmployer_CompanyName(boolean status,@Param("companyName") String companyName);
}
