package javacamp.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import javacamp.hrms.entities.concretes.JobPosting;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer>{
	List<JobPosting> getByIsActive(boolean status);
	List<JobPosting> getByIsActiveOrderByClosedDate(boolean status);
	List<JobPosting> getByIsActiveAndEmployer_CompanyName(boolean status, String companyName);
	
}
