package javacamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javacamp.hrms.entities.concretes.Education;

public interface EducationDao extends JpaRepository<Education, Integer>{
	
}
