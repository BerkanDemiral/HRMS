package javacamp.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javacamp.hrms.entities.concretes.JobPosting;
import javacamp.hrms.entities.dtos.JobPostingDto;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer>{
	List<JobPosting> getByIsActive(boolean status);
	List<JobPosting> getByIsActiveOrderByClosedDate(boolean status);
	
	@Query("Select new kodlamaio.northwind.entities.dtos.ProductWithCategoryDto"
			+ "(e.companyName, jp.position, jp.createDate, jp.closedDate) " + "From JobPosting jp Inner Join jp.employer e")
	List<JobPostingDto> getByIsActiveAndEmployer_CompanyName(boolean status,@Param("companyName") String companyName);
	
	
	
}
