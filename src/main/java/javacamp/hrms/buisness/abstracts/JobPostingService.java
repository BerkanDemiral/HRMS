package javacamp.hrms.buisness.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.JobPosting;

public interface JobPostingService {
	Result add(JobPosting jobPosting);

	Result update(JobPosting jobPosting);

	Result delete(int id);

	Result closeJobPosting(int jobPostingId);
	
	
	DataResult<JobPosting> getById(int id);
	DataResult<List<JobPosting>> getAll();

	DataResult<List<JobPosting>> getAllIsActiveJobPostings();

	DataResult<List<JobPosting>> getAllIsActiveJobPostingsOrderBayClosedDateAsc();

	DataResult<List<JobPosting>> getAllIsActiveJobPostingsByEmployer(int id);
	
	

	/*
	 * DataResult<List<JobPostingDto>> getByIsActive(boolean status); // aktif olan
	 * ilanları listeleme DataResult<List<JobPosting>>
	 * getByIsActiveOrderByClosedDate(boolean status); // Son başvuru tarihine göre
	 * ilan listeleme DataResult<List<JobPostingDto>>
	 * findByIsActiveAndEmployer_CompanyName(String companyName); // şirket ismine
	 * göre iş ilanı listeleme
	 */
}
