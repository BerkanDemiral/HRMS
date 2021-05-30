package javacamp.hrms.buisness.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.buisness.abstracts.EmployerService;
import javacamp.hrms.buisness.abstracts.ValidateService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private ValidateService<Employer> validateService;

	@Autowired
	public EmployerManager(ValidateService<Employer> validateService) {
		super();
		this.validateService = validateService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return this.validateService.getAll();
	}

	@Override
	public Result add(Employer employer) {
		return this.validateService.verifyData(employer);
	}

}
