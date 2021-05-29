package javacamp.hrms.buisness.abstracts;

import java.util.List;

import javacamp.hrms.entities.concretes.JobPosition;

public interface JobPositionsService {
	List<JobPosition> getAll();
}
