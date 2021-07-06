package javacamp.hrms.buisness.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.JobPosting;

public interface JobPostingService {
	Result add(JobPosting jobPosting);
	
	DataResult<JobPosting> getByName(String name);

	DataResult<List<JobPosting>> getAll();

	DataResult<List<JobPosting>> getAllSorted();
	
	DataResult<JobPosting> getById(int id);

	Result update(JobPosting jobPosting);

	DataResult<List<JobPosting>> getByIsActive();

	DataResult<List<JobPosting>> getByEmployer_Id(int employerId);

	DataResult<JobPosting> changeStatus(int jobPostingId, boolean status, int employerId);

}
