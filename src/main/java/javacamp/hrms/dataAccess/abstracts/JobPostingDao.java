package javacamp.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import javacamp.hrms.entities.concretes.JobPosting;


public interface JobPostingDao extends JpaRepository<JobPosting, Integer> {
		
	@Query("From JobPosting where isActive = true") // JPQL ile sql kodlaması
	List<JobPosting> getAllIsActiveJobPostings();

	@Query("From JobPosting where isActive = true Order By closedDate Asc") // iş ilanı kapanış tarihi erkenden geçe doğru sıralayacak
	List<JobPosting> getAllIsActiveJobPostingsOrderBayClosedDateAsc();

	
	//List<JobPosting> getByIsActiveOrderByClosedDate(boolean status);

	@Query("From JobPosting where isActive = true and employerId =: id")
	List<JobPosting> getAllIsActiveJobPostingsByEmployer(int id);	

	JobPosting getById(int id);
	
	//List<JobPosting> getByIsActiveAndEmployer_CompanyName(boolean status, String companyName);	

}
