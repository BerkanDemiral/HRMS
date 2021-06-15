package javacamp.hrms.buisness.concretes;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javacamp.hrms.buisness.abstracts.JobExperienceService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.dataAccess.abstracts.JobExperience;

@Service
@Component
public class JobExperienceManager implements JobExperienceService{

	@Override
	public Result add(JobExperience jobExperience) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<JobExperience>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<JobExperience>> sortOrderByEndedDateDesc(int resumeId) {
		// TODO Auto-generated method stub
		return null;
	}

}
