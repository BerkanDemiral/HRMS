package javacamp.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import javacamp.hrms.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer>{
	boolean existByIdentityNumber(String identity_number); // Kimlik numarası sorgulaması yapılacak
	List<Candidate> getByCandidateName(String candidateName);
}
