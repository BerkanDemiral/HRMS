package javacamp.hrms.buisness.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.entities.concretes.WorkingTime;

public interface WorkingTimeService {
	DataResult<List<WorkingTime>> getAll();

}
