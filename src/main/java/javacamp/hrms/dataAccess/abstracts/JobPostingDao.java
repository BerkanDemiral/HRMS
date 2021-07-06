package javacamp.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import javacamp.hrms.entities.concretes.JobPosting;


public interface JobPostingDao extends JpaRepository<JobPosting, Integer> {
	
	List<JobPosting> getByIsActive(boolean isActive);
	List<JobPosting> getByEmployer_Id(int employerId);
	JobPosting getById(int id);
	JobPosting getByJobPosition_Position(String name);

}
