package javacamp.hrms.buisness.abstracts;


import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.entities.concretes.WorkingType;

public interface WorkingTypeService {
	DataResult<List<WorkingType>> getAll();
}
