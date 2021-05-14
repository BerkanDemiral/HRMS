package javacamp.hrms.buisness.abstracts;

import java.util.List;

import javacamp.hrms.entities.concretes.JobPositions;

public interface JobPositionsService {
	List<JobPositions> getAll();
}
