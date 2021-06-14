package javacamp.hrms.buisness.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.dataAccess.abstracts.JobExperience;

public interface JobExperienceService {
	Result add(JobExperience jobExperience);
	DataResult<List<JobExperience>> getAll();
	DataResult<List<JobExperience>> sortOrderByEndedDateDesc(int resumeId);
}
