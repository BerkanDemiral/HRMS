package javacamp.hrms.buisness.concretes;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javacamp.hrms.buisness.abstracts.EducationService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Education;

@Service
@Component
public class EducationManager implements EducationService{

	@Override
	public Result add(Education education) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<Education>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<Education>> sortOrderByEndedDateDesc(int resumeId) {
		// TODO Auto-generated method stub
		return null;
	}

}
