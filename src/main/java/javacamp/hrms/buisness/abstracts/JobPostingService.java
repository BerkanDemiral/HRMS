package javacamp.hrms.buisness.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.JobPosting;

public interface JobPostingService {
	Result add(JobPosting jobPosting);
	Result delete(JobPosting jobPosting);
	
	DataResult<List<JobPosting>> getByIsActive(boolean status);
	DataResult<List<JobPosting>> getByIsActiveOrderByClosedDate(boolean status);
	DataResult<List<JobPosting>> getByIsActiveAndEmployer_CompanyName(boolean status, String companyName);
}
