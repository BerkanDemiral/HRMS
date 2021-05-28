package javacamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javacamp.hrms.entities.concretes.JobSeekers;

public interface JobSeekersDao extends JpaRepository<JobSeekers, Integer>{

}
