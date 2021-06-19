package javacamp.hrms.buisness.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.dataAccess.abstracts.EmployerDao;
import javacamp.hrms.buisness.abstracts.EmployerService;
import javacamp.hrms.buisness.abstracts.ValidateService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.entities.concretes.Employer;

@Service
@Component
public class EmployerManager implements EmployerService {

	private ValidateService<Employer> validateService;
	private EmployerDao employerDao;
	

	@Autowired
	public EmployerManager(ValidateService<Employer> validateService, EmployerDao employerDao) {
		super();
		this.validateService = validateService;
		this.employerDao = employerDao;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return this.validateService.getAll();
	}

	@Override
	public Result add(Employer employer) {
		return this.validateService.verifyData(employer);
	}

	@Override
	public DataResult<Employer> getById(int id) {
		return new SuccessDataResult<Employer>(this.employerDao.getById(id), "Listeleme başarılı");
	}

}
