package javacamp.hrms.buisness.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Education;

public interface EducationService {
	Result add(Education education);
	DataResult<List<Education>> getAll();
	DataResult<List<Education>> sortOrderByEndedDateDesc(int resumeId);
	
	
}
