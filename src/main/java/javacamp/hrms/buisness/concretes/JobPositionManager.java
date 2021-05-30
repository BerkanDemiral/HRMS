package javacamp.hrms.buisness.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.buisness.abstracts.JobPositionService;
import javacamp.hrms.buisness.abstracts.ValidateService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {

	private ValidateService<JobPosition> validateService;
	
	@Autowired
	public JobPositionManager(ValidateService<JobPosition> validateService) {
		super();
		this.validateService =  validateService;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return validateService.getAll();
	}

	@Override
	public Result add(JobPosition newJobPositions) {
		return validateService.verifyData(newJobPositions);
	}

}
