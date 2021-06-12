package javacamp.hrms.buisness.abstracts;


import java.util.List;


import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.JobPosting;
import javacamp.hrms.entities.dtos.JobPostingDto;

public interface JobPostingService {
	Result add(JobPosting jobPosting);
	 DataResult<List<JobPosting>> getAll();
	 DataResult<List<JobPosting>> getAllSorted();
	 
	 Result update (JobPosting jobPosting);
	 
	 DataResult<List<JobPostingDto>> getByIsActive(); 
	 DataResult<List<JobPostingDto>> getByEmployer_EmployerId(int employerId);
	

	
}
